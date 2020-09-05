package lk.ijse.dep.poss.dao.custom;

import lk.ijse.dep.poss.dao.CrudDAO;
import lk.ijse.dep.poss.entity.Item;

public interface ItemDAO extends CrudDAO<Item,String> {

     String getLastItemCode();
}
