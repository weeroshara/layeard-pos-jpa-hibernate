package lk.ijse.dep.poss.business.custom.impl;

import lk.ijse.dep.poss.business.custom.CustomerBO;
import lk.ijse.dep.poss.dao.DAOFactory;
import lk.ijse.dep.poss.dao.DAOType;
import lk.ijse.dep.poss.dao.custom.CustomerDAO;
import lk.ijse.dep.poss.db.JpaUtil;
import lk.ijse.dep.poss.entity.Customer;
import lk.ijse.dep.poss.util.CustomerTM;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    // Field Injection
    private CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

    public List<CustomerTM> getAllCustomers() throws Exception {

//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();

        customerDAO.setEntityManager(entityManager);

//        Transaction tx=null;
        List<CustomerTM> customers = new ArrayList<>();
        try {
//            tx = session.beginTransaction();
            entityManager.getTransaction().begin();
            List<Customer> allCustomers = customerDAO.findAll();

            for (Customer customer : allCustomers) {
                customers.add(new CustomerTM(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress()));
            }

//            tx.commit();
            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
//            tx.rollback();
            entityManager.getTransaction().rollback();
        }finally {
//            session.close();
            entityManager.close();
        }
        return customers;


//        List<Customer> allCustomers = customerDAO.findAll();
//        List<CustomerTM> customers = new ArrayList<>();
//        for (Customer customer : allCustomers) {
//            customers.add(new CustomerTM(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress()));
//        }
//        return customers;
    }

    public void saveCustomer(String id, String name, String address) throws Exception {
//        return customerDAO.save(new Customer(id, name, address));
//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);

//        Transaction tx=null;
        try {
            entityManager.getTransaction().begin();

            customerDAO.save(new Customer(id, name, address));

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
         entityManager.close();
        }
    }

    public void deleteCustomer(String customerId) throws Exception {
//        return customerDAO.delete(customerId);

//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

        customerDAO.setEntityManager(entityManager);

//        Transaction tx=null;
        try {
            entityManager.getTransaction().begin();

            customerDAO.delete(customerId);

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    public void updateCustomer(String name, String address, String customerId) throws Exception {
//        return customerDAO.update(new Customer(customerId, name, address));

//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);

//        Transaction tx=null;
        try {
            entityManager.getTransaction().begin();

            customerDAO.update(new Customer(customerId, name, address));

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }

    }

    public String getNewCustomerId() throws Exception {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);

//        Transaction tx=null;
        String lastCustomerId =null;
        try {
            entityManager.getTransaction().begin();

            lastCustomerId = customerDAO.getLastCustomerId();

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();

        }finally {
            entityManager.close();
        }




        if (lastCustomerId == null) {
            return "C001";
        } else {
            int maxId = Integer.parseInt(lastCustomerId.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }

    }

}
