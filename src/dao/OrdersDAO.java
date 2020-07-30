package dao;

import entity.Orders;

import java.util.List;

public interface OrdersDAO extends SuperDAO<Orders,String>{
     String getLastOrderId();


}
