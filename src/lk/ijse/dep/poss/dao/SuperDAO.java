package lk.ijse.dep.poss.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;

public interface SuperDAO <T,ID>{

    public void setEntityManager(EntityManager entityManager);

//    List<T>findAll() throws Exception;
//
//    T find(ID key) throws  Exception;
//
//    boolean save(T lk.ijse.dep.poss.entity) throws Exception;
//
//    boolean update(T lk.ijse.dep.poss.entity) throws Exception;
//
//    boolean delete(ID key) throws Exception;
}
