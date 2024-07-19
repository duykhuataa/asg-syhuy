package dao;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO extends DBContext {

    public Connection con = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    public String sql = null;

    public DAO() {
        con = connection;
    }

    public void finalize() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
