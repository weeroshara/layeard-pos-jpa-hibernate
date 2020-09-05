package lk.ijse.dep.poss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements SuperEntity{

    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int orderQty;
    private BigDecimal unitPrice;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_Id", referencedColumnName = "orderID", insertable = false, updatable = false)
    private Orders orders;


//        public OrderDetail() {
//    }
//
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
//
//    public Integer getOrderQty() {
//        return orderQty;
//    }
//
//    public void setOrderQty(Integer orderQty) {
//        this.orderQty = orderQty;
//    }
//
//    public BigDecimal getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(BigDecimal unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//
//
//    public OrderDetailPK getOrderDetailPK() {
//        return orderDetailPK;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderDetail{" +
//                "orderDetailPK=" + orderDetailPK +
//                ", orderQty=" + orderQty +
//                ", unitPrice=" + unitPrice +
//                '}';
//    }
//
//    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
//        this.orderDetailPK = orderDetailPK;
//    }
}
