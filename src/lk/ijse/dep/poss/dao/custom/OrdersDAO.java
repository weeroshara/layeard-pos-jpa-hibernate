package lk.ijse.dep.poss.dao.custom;

import lk.ijse.dep.poss.dao.CrudDAO;
import lk.ijse.dep.poss.entity.Orders;

public interface OrdersDAO extends CrudDAO<Orders,String> {
     String getLastOrderId();


}
