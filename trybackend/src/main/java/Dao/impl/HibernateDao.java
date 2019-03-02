package Dao.impl;

import Dao.service.BasicDatabaseService;
import enums.resultMessage.DatabaseRM;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;
import javax.security.auth.login.AppConfigurationEntry;
import java.util.ArrayList;
import java.util.List;

public class HibernateDao<T> implements BasicDatabaseService<T> {

    T type;
    private SessionFactory sessionFactory;
    private Session session = null;

    public HibernateDao(T t){
        type=t;
        Configuration cfg = new Configuration();
        cfg.setImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE);//      更改命名方式，但有显式命名应该问题不大
        cfg.configure();
        cfg.addPackage("../../entity").addAnnotatedClass(type.getClass());//        添加entity中的对象，具体对象是根据getclass指定，但路径不确保正确，，
        sessionFactory = cfg.buildSessionFactory(); //初始化sessionfactory，作用见https://www.bbsmax.com/A/xl56ZxDx5r/
    }

    public synchronized DatabaseRM add(T t0){
        DatabaseRM res=DatabaseRM.SUCCESS;

        session = sessionFactory.openSession();//线程不安全，看J2EE的PPT，getCurrentSession方法
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.save(t0);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.out.println("新增失败，发生回滚");
                tx.rollback();

                e.printStackTrace();

            }
            res=DatabaseRM.ROLL_BACK;
        } catch (PersistenceException e) {        //数据库中已有此主键
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("主键已经存在");
            res=DatabaseRM.KEY_EXITS;

        } finally {
            session.close();
        }
        return res;
    }

    public synchronized DatabaseRM delete(String keyValue){
        DatabaseRM res = DatabaseRM.SUCCESS;
        session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(session.get(type.getClass(), keyValue));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("删除失败,发生回滚");
            }
            res = DatabaseRM.ROLL_BACK;
        } finally {
            session.close();
        }
        return res;
    }

    public synchronized DatabaseRM update(Object t0){
        DatabaseRM res=DatabaseRM.SUCCESS;
        session=sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx = session.beginTransaction();
            session.update(t0);     //固定游离对象，一般用于注册或初始化
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                System.out.println("更新失败");
            }
            res = DatabaseRM.ROLL_BACK;
        }finally {
            session.close();
        }
        return res;
    }

    public synchronized T findByKey(String keyValue){
        session=sessionFactory.openSession();
        Transaction tx = null;
        T po = null;
        try{
            tx = session.beginTransaction();
            po = (T)session.get(type.getClass(),keyValue);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                System.out.println("获取失败");

            }
        }finally {
            session.close();
        }
        return po;
    }

    public synchronized boolean checkKeyExists(String keyValue){
        if(findByKey(keyValue)==null){
            return false;
        }
        else{
            return true;
        }
    }

    public synchronized ArrayList<T> getAllObjects(){
        session=sessionFactory.openSession();
        Transaction tx=null;
        List<T> list=new ArrayList<T>();
        try{
            tx=session.beginTransaction();
            String s0 = "FROM "+type.getClass().getName();
            list=session.createQuery(s0).list();
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                System.out.println("取列失败");
            }
        }finally {
            session.close();
        }
        return (ArrayList<T>) list;
    }
}
