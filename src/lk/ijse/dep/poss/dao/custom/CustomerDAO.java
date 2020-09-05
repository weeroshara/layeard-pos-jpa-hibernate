package lk.ijse.dep.poss.dao.custom;

import lk.ijse.dep.poss.dao.CrudDAO;
import lk.ijse.dep.poss.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {
     String getLastCustomerId();

}
