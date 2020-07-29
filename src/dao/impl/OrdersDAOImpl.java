package dao.impl;

import dao.OrdersDAO;
import db.DBConnection;
import entity.Customer;
import entity.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {

    public String getLastOrderId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1");
            if (rst.next()){
                return rst.getString(1);
            }else{
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Orders> findAllOrders(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Orders");
            List<Orders> orders = new ArrayList<>();
            while (rst.next()) {
                orders.add(new Orders(rst.getString(1),
                        rst.getDate(2),
                        rst.getString(3)));
            }
            return orders;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public Orders findOrder(String orderId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Orders WHERE orderId=?");
            pstm.setObject(1, orderId);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                return new Orders(rst.getString(1),
                        rst.getDate(2),
                        rst.getString(3));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public boolean saveOrder(Orders orders){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Orders VALUES (?,?,?)");
            pstm.setObject(1, orders.getOrderID());
            pstm.setObject(2, orders.getOrderDate());
            pstm.setObject(3, orders.getCustomerId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean updateOrder(Orders orders){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Orders SET orderDate=?, customerId=? WHERE orderId=?");
            pstm.setObject(1, orders.getOrderID());
            pstm.setObject(2, orders.getOrderDate());
            pstm.setObject(3, orders.getCustomerId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteOrder(String orderId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Orders WHERE orderId=?");
            pstm.setObject(1, orderId);
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
