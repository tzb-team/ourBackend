package Dao.service;

import enums.resultMessage.DatabaseRM;

import java.util.ArrayList;

public interface BasicDatabaseService<T> {
    DatabaseRM add(T t0);
    DatabaseRM delete(String keyValue);
    DatabaseRM update(T t0);
    T findByKey(String keyvalue);
    boolean checkKeyExists(String keyValue);
    ArrayList<T> getAllObjects();

}
