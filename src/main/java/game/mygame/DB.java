package game.mygame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DB {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/hellowen_adventure";
    final String USER = "root";
    final String PASS = "";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }

    public void setNamaUser(String namaUser) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO user (user_name) VALUES ('" + namaUser + "')";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPoin(int poin, String namaUser) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO user (point) VALUES ('" + poin + "') WHERE user_name = '" + namaUser + "'";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePoint(int poin, String namaUser) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "UPDATE user SET point = '" + poin + "' WHERE user_name = '" + namaUser + "'";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
