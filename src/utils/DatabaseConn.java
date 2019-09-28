package utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {
    public DatabaseConn() {
    }

    public Connection getConnection() {
        Connection conn = null;
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/highwaytollmanager?serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭数据库的连接，使用静态方法
    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
