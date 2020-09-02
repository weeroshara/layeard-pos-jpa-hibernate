package dao.custom.impl;

import dao.custom.OrdersDAO;
import db.DBConnection;
import entity.Orders;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {


    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public String getLastOrderId() {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Statement stm = connection.createStatement();
//            ResultSet rst = stm.executeQuery("SELECT o.id FROM `Order` o ORDER BY o.id DESC LIMIT 1");
//            if (rst.next()){
//                return rst.getString(1);
//            }else{
//                return null;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return (String) session.createNativeQuery("SELECT o.orderID FROM Orders o ORDER BY o.orderID DESC LIMIT 1").uniqueResult();
    }

    @Override
    public List<Orders> findAll() {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Statement stm = connection.createStatement();
//            ResultSet rst = stm.executeQuery("SELECT * FROM `Order`");
//            List<Orders> orders = new ArrayList<>();
//            while (rst.next()) {
//                orders.add(new Orders(rst.getString(1),
//                        rst.getDate(2),
//                        rst.getString(3)));
//            }
//            return orders;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return session.createQuery("FROM entity.Orders").list();
    }

    @Override
    public Orders find(String key) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM `Order` WHERE id=?");
//            pstm.setObject(1, key);
//            ResultSet rst = pstm.executeQuery();
//            if (rst.next()) {
//                return new Orders(rst.getString(1),
//                        rst.getDate(2),
//                        rst.getString(3));
//            }
//            return null;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return session.get(Orders.class,key);
    }

    @Override
    public void save(Orders entity) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Orders orders =  entity;
//            PreparedStatement pstm = connection.prepareStatement("INSERT INTO `Order` VALUES (?,?,?)");
//            pstm.setObject(1, orders.getOrderID());
//            pstm.setObject(2, orders.getOrderDate());
//            pstm.setObject(3, orders.getCustomerId());
//            return pstm.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        session.save(entity);
    }

    @Override
    public void update(Orders entity) {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            Orders orders =  entity;
//            PreparedStatement pstm = connection.prepareStatement("UPDATE `Order` SET date=?, id=? WHERE customerId=?");
//            pstm.setObject(1, orders.getOrderID());
//            pstm.setObject(2, orders.getOrderDate());
//            pstm.setObject(3, orders.getCustomerId());
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
//            PreparedStatement pstm = connection.prepareStatement("DELETE FROM `Order` WHERE id=?");
//            pstm.setObject(1, key);
//            return pstm.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        session.delete(session.get(Orders.class,key));
    }
}
