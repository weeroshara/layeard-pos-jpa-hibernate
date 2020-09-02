package dao;

import db.HibernateUtil;
import entity.Customer;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateTest {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        Customer customer = session.get(Customer.class, 1);
//        customer.getCustomerId();

//        List list = session.createQuery("FROM entity.Customer").list();
//        for (Object o : list) {
//            System.out.println(o);
        List<Item> list = session.createNativeQuery("SELECT i.itemCode, i.description, i.unitPrice, i.qtyOnHand FROM Item i ", Item.class).list();
        for (Item item : list) {
            System.out.println(item);
        }
//        }

        transaction.commit();
        session.close();

    }

}
