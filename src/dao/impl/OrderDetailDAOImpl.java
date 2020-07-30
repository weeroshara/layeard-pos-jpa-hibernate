package dao.impl;

import dao.OrderDetailDAO;
import db.DBConnection;
import entity.Customer;
import entity.OrderDetail;
import entity.OrderDetailPK;
import entity.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public List<OrderDetail> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM OrderDetail");
            List<OrderDetail> orderDetails = new ArrayList<>();
            while (rst.next()) {
                orderDetails.add(new OrderDetail(rst.getString(1),
                        rst.getString(2),
                        rst.getInt(3),
                        rst.getBigDecimal(4)));
            }
            return orderDetails;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public OrderDetail find(OrderDetailPK key) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM OrderDetail WHERE orderId=? AND itemCode=?");
            OrderDetailPK entity = new OrderDetailPK();
            pstm.setObject(1, entity.getOrderId());
            pstm.setObject(2, entity.getItemCode());
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                return new OrderDetail(rst.getString(1),
                        rst.getString(2),
                        rst.getInt(3),
                        rst.getBigDecimal(4));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(OrderDetail entity) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetail VALUES (?,?,?,?)");
            OrderDetail orderDetail = entity;
            pstm.setObject(1, orderDetail.getOrderDetailPK().getOrderId());
            pstm.setObject(2, orderDetail.getOrderDetailPK().getItemCode());
            pstm.setObject(3, orderDetail.getOrderQty());
            pstm.setObject(4, orderDetail.getUnitPrice());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderDetail entity) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE OrderDetail SET orderQty=?, unitPrice=? WHERE orderId=? AND itemCode=?");
            OrderDetail orderDetail = entity;
            pstm.setObject(3, orderDetail.getOrderDetailPK().getOrderId());
            pstm.setObject(4, orderDetail.getOrderDetailPK().getItemCode());
            pstm.setObject(1, orderDetail.getOrderQty());
            pstm.setObject(2, orderDetail.getUnitPrice());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(OrderDetailPK key) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.
                    prepareStatement("DELETE FROM OrderDetail WHERE orderId=? AND itemCode=?");
            OrderDetailPK entity = new OrderDetailPK();
            pstm.setObject(1, entity.getOrderId());
            pstm.setObject(2, entity.getItemCode());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
