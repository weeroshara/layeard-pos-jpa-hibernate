package lk.ijse.dep.poss.business.custom.impl;

import lk.ijse.dep.poss.business.custom.ItemBO;
import lk.ijse.dep.poss.dao.DAOFactory;
import lk.ijse.dep.poss.dao.DAOType;
import lk.ijse.dep.poss.dao.custom.ItemDAO;
import lk.ijse.dep.poss.db.JpaUtil;
import lk.ijse.dep.poss.entity.Item;
import lk.ijse.dep.poss.util.ItemTM;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    // Dependency Declaration
    private ItemDAO itemDAO;

    public ItemBOImpl(){
        // Constructor Injection
        this.itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);
    }

    public String getNewItemCode() throws Exception {

//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
//        Transaction tx=null;

        String lastItemCode=null;
        try {
            entityManager.getTransaction().begin();

                lastItemCode = itemDAO.getLastItemCode();

            entityManager.getTransaction().rollback();

        }catch (Throwable th){
            th.printStackTrace();
        }finally {
            entityManager.close();
        }


        if (lastItemCode == null) {
            return "I001";
        } else {
            int maxId = Integer.parseInt(lastItemCode.replace("I", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "I00" + maxId;
            } else if (maxId < 100) {
                id = "I0" + maxId;
            } else {
                id = "I" + maxId;
            }
            return id;
        }
    }


    public List<ItemTM> getAllItems() throws Exception {

//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);

//        Transaction tx=null;
        List<ItemTM> items = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();

            List<Item> allItems = itemDAO.findAll();
        for (Item item : allItems) {
            items.add(new ItemTM(item.getItemCode(), item.getDescription(), item.getQtyOnHand(),
                    item.getUnitPrice().doubleValue()));
        }

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return items;
    }

    public void saveItem(String code, String description, int qtyOnHand, double unitPrice) throws Exception {
//        return itemDAO.save(new Item(code, description, BigDecimal.valueOf(unitPrice), qtyOnHand));
//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
//        Transaction tx=null;

        try {
            entityManager.getTransaction().begin();

            itemDAO.save(new Item(code, description, BigDecimal.valueOf(unitPrice), qtyOnHand));

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    public void deleteItem(String itemCode) throws Exception {
//        return itemDAO.delete(itemCode);
//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
//        Transaction tx=null;

        try {
            entityManager.getTransaction().begin();

            itemDAO.delete(itemCode);

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    public void updateItem(String description, int qtyOnHand, double unitPrice, String itemCode) throws Exception {
//        return itemDAO.update(new Item(itemCode, description, BigDecimal.valueOf(unitPrice), qtyOnHand));

//        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);;
//        Transaction tx=null;

        try {
            entityManager.getTransaction().begin();

            itemDAO.update(new Item(itemCode, description, BigDecimal.valueOf(unitPrice), qtyOnHand));

            entityManager.getTransaction().commit();
        }catch (Throwable th){
            th.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
