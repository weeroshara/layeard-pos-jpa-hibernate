package entity;

import java.math.BigDecimal;

public class OrderDetail {

    private OrderDetailPK orderDetailPK;
    private int orderQty;
    private BigDecimal unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPK, int orderQty, BigDecimal unitPrice) {
        this.orderDetailPK = orderDetailPK;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(String orderId, String itemCode,int orderQty, BigDecimal unitPrice) {
        this.orderDetailPK = new OrderDetailPK(orderId,itemCode);
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }



    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", orderQty=" + orderQty +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }
}
