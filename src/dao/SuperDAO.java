package dao;

import org.hibernate.Session;

import java.util.List;

public interface SuperDAO <T,ID>{

    public void setSession(Session session);

//    List<T>findAll() throws Exception;
//
//    T find(ID key) throws  Exception;
//
//    boolean save(T entity) throws Exception;
//
//    boolean update(T entity) throws Exception;
//
//    boolean delete(ID key) throws Exception;
}
