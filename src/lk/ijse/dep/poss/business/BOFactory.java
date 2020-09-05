package lk.ijse.dep.poss.business;

import lk.ijse.dep.poss.business.custom.impl.CustomerBOImpl;
import lk.ijse.dep.poss.business.custom.impl.ItemBOImpl;
import lk.ijse.dep.poss.business.custom.impl.OrderBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            default:
                return null;
        }
    }
}
