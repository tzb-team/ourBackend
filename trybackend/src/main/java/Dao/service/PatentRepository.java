package Dao.service;

import entity.patent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//      jpa提供的接口，加快对于数据定位检索
@Repository
public interface PatentRepository extends JpaRepository<patent,String> {

    @Query(value = "select * from patent where patent_id=?1", nativeQuery = true)
    patent findByPatent_id(String patent_id);

    @Transactional
    @Modifying
    @Query(value = "update patent  set patent_owner=?2,poolid=?3,valid=?4,price=?5 where patent_id=?1",nativeQuery = true)
    void updatePatent(String id,String owner,String poolid,boolean isvalid,int price);

    @Transactional
    @Modifying
    @Query(value = "insert into patent (patent_id,patent_owner,poolid,valid,price)values (?1,?2,?3,?4,?5)",nativeQuery = true)
    void insertPatent(String id,String owner,String poolid,boolean isvalid,int price);
}
