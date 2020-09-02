package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Orders;

public interface OrdersDAO extends CrudDAO<Orders,String> {
     String getLastOrderId();


}
