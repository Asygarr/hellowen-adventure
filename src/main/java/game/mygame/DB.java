package game.mygame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DB {

    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost:3306/hellowen_adventure";
    private String USER = "root";
    private String PASS = "";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void setNamaUser(String namaUser) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO user (user_name) VALUES ('" + namaUser + "')";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
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
            System.out.println(e);
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
            System.out.println(e);
        }
    }

}
