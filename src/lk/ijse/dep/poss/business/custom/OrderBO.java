package lk.ijse.dep.poss.business.custom;

import lk.ijse.dep.poss.business.SuperBO;
import lk.ijse.dep.poss.util.OrderDetailTM;
import lk.ijse.dep.poss.util.OrderTM;

import java.util.List;

public interface OrderBO extends SuperBO {

    public String getNewOrderId() throws Exception;

    public void placeOrder(OrderTM order, List<OrderDetailTM> orderDetails)throws Exception;
}
