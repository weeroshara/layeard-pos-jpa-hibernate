package lk.ijse.dep.poss.dao;

import lk.ijse.dep.poss.db.JpaUtil;
import lk.ijse.dep.poss.entity.Customer;
import lk.ijse.dep.poss.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateTest {

    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();

//        Customer customer = session.get(Customer.class, 1);
//        customer.getCustomerId();

//        List list = session.createQuery("FROM lk.ijse.dep.poss.entity.Customer").list();
//        for (Object o : list) {
//            System.out.println(o);
//        List<Item> list = session.createNativeQuery("SELECT i.itemCode, i.description, i.unitPrice, i.qtyOnHand FROM Item i ", Item.class).list();
//        for (Item item : list) {
//            System.out.println(item);
//        }
////        }
//
//        transaction.commit();
//        session.close();

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

//        List resultList = entityManager.createNativeQuery("SELECT c.customerId, c.customerName, c.customerAddress FROM Customer c", Customer.class).getResultList();
//        for (Object o : resultList) {
//            System.out.println(o);
//        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
