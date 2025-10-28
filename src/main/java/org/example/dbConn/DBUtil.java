package org.example.dbConn;


import java.sql.*;

// 재사용 가능한 방식으로 코드 분리
public class DBUtil {

    // 무조건 프로그램이 시작하면 실행  1. JDBC 통역기(드라이버)를 받아옵니다. 클래스 메서드로 프로그램 실행시 1번 메모리에 올려두면 변경될 일이 없음
    static {
        try {
            // JDBC 통역기(드라이버)를 받아옵니다.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2. DB 접속을 위한 메서드 getConnection
    // Connection conn = DBUtil.getConnection()
    public static Connection getConnection() throws SQLException {
        // 2. DB접속을 위한 객체를 만들어서 url, id, pw를 넘겨줍니다.
        String url = "jdbc:mysql://118.67.131.22:3306/fisa";
        String id = "fisaai";
        String pw = "Woorifisa5!";
        return DriverManager.getConnection(url, id, pw);
    }

    // 5. 자원 반납
    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }
}
