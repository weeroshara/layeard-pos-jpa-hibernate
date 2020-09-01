package dao.custom;

import dao.SuperDAO;
import entity.Orders;

public interface OrdersDAO extends SuperDAO<Orders,String> {
     String getLastOrderId();


}
