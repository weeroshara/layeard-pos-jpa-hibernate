package dao;

import db.DBConnection;
import entity.Customer;
import entity.Item;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CrudUtil {

    public static <T> T execute(String sql, Object... params) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        int i = 0;
        for (Object param : params) {
            i++;
            pstm.setObject(i, param);
        }
        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();     // ResultSet
        }
        return (T) ((Boolean) (pstm.executeUpdate() > 0));    // boolean
    }

   /* public static boolean executeUpdate(String sql, Object... params) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        int i = 0;
        for (Object param : params) {
            i++;
            pstm.setObject(i, param);
        }
        return pstm.executeUpdate() > 0;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        //SELECT * FROM Customer WHERE id=? AND name=?
        PreparedStatement pstm = connection.prepareStatement(sql);
//        System.out.println(params[0]);
        int i = 0;
        for (Object param : params) {
            i++;
            pstm.setObject(i, param);
        }
        return pstm.executeQuery();
    }*/

}
