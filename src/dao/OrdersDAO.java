package dao;

import entity.Orders;

import java.util.List;

public interface OrdersDAO {
    public String getLastOrderId();
    public List<Orders> findAllOrders();
    public Orders findOrder(String orderId);
    public boolean saveOrder(Orders orders);
    public boolean updateOrder(Orders orders);
    public boolean deleteOrder(String orderId);

}
