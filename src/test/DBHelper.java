package test;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
  
public class DBHelper {  
    public static final String url = "jdbc:mysql://rm-2ze86ne9n05vf0uw3o.mysql.rds.aliyuncs.com:3306/p2p_test";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "zcb_p2p_test_sql";  
    public static final String password = "Zhichubao!@#$%^&*(0";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper(String sql) {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  