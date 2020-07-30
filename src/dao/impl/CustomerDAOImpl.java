package dao.impl;

import dao.CustomerDAO;
import db.DBConnection;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String getLastCustomerId() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT CustomerID FROM Customer ORDER BY CustomerID DESC LIMIT 1");
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

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM Customer");
            ArrayList<Customer>customers = new ArrayList<>();
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Customer find(String key) {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE customerId=?");
            pstm.setObject(1,key);
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()){
                return new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Customer entity) {
        Connection connection = DBConnection.getInstance().getConnection();
        Customer customer =  entity;
        try {
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?)");
            pstm.setObject(1,customer.getCustomerId());
            pstm.setObject(2,customer.getCustomerName());
            pstm.setObject(3,customer.getCustomerAddress());
            return pstm.executeUpdate()>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Customer entity) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Customer customer =  entity;
            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET customerName=?, customerAddress=? WHERE customerId=?");
            pstm.setObject(1, customer.getCustomerId());
            pstm.setObject(2, customer.getCustomerName());
            pstm.setObject(3, customer.getCustomerAddress());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String key) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE customerId=?");
            pstm.setObject(1, key);
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
