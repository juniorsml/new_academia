package br.com.consulti.academics.dao;

import java.util.List;
import org.hibernate.Session;

public interface DAO<T> {

    void save(T persistentObject);

    List<T> getAll();

    void update(T persistentObject);

    void createOrUpdate(T persistentObject);

    void delete(T persistentObject);

    void start();

    void finish();

    Session getSession();
}