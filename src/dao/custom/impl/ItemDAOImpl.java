package dao.custom.impl;

import dao.custom.ItemDAO;
import db.DBConnection;
import db.HibernateUtil;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;

    }

    @Override
    public String getLastItemCode() {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Statement stm = connection.createStatement();
//            ResultSet rst = stm.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
//            if (rst.next()){
//                return rst.getString(1);
//            }else{
//                return null;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return (String) session.createNativeQuery("SELECT i.itemCode FROM Item i ORDER BY i.itemCode DESC LIMIT 1").uniqueResult();
    }

    @Override
    public List<Item> findAll() {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Statement stm = connection.createStatement();
//            ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//            List<Item> items = new ArrayList<>();
//            while (rst.next()){
//                items.add(new Item(rst.getString(1),
//                        rst.getString(2),
//                        rst.getBigDecimal(3),
//                        rst.getInt(4)));
//            }
//            return items;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return session.createNativeQuery("SELECT i.itemCode, i.description, i.unitPrice, i.qtyOnHand FROM Item i ",Item.class).list();
    }

    @Override
    public Item find(String key) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE Code=?");
//            pstm.setObject(1, key);
//            ResultSet rst = pstm.executeQuery();
//            if (rst.next()){
//                return new Item(rst.getString(1),
//                        rst.getString(2),
//                        rst.getBigDecimal(3),
//                        rst.getInt(4));
//            }
//            return null;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return session.get(Item.class,key);
    }

    @Override
    public void save(Item entity) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Item item =  entity;
//            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
//            pstm.setObject(1, item.getItemCode());
//            pstm.setObject(2, item.getDescription());
//            pstm.setObject(3, item.getUnitPrice());
//            pstm.setObject(4, item.getQtyOnHand());
//            return pstm.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        session.save(entity);


    }

    @Override
    public void update(Item entity) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Item item =  entity;
//            PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE Code=?");
//            pstm.setObject(4, item.getItemCode());
//            pstm.setObject(1, item.getDescription());
//            pstm.setObject(2, item.getUnitPrice());
//            pstm.setObject(3, item.getQtyOnHand());
//            return pstm.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        session.update(entity);
    }

    @Override
    public void delete(String key) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE Code=?");
//            pstm.setObject(1, key);
//            return pstm.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        session.delete(session.get(Item.class,key));
    }
}
