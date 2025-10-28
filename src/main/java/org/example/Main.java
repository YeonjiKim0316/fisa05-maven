


package org.example;

import org.example.dbConn.DBUtil;
import org.example.dbConn.Dept;
import org.example.lombok.HelloLombok;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws SQLException {

        HelloLombok h1 = new HelloLombok(1, "김연지", "123-45");
        System.out.println(h1.getName());
        System.out.println(h1.getNum());
        h1.setName("신짱구");
        h1.setNum(2);
        System.out.println(h1.getName());
        System.out.println(h1); // HelloLombok(num=2, name=신짱구, ssn=123-45)

//        HelloLombok h2 = new HelloLombok("123-24"); // ssn만(required) 필수 값으로 입력받는 생성자
        HelloLombok h3 = new HelloLombok(); // 빈 생성자




        System.out.println("------------------ DBUtil을 활용한 MySQL DB 접근 ----------------------");
        // 어떤 sql문을 실행하면 결과를 가변적으로 담을 수 있는 ArrayList를 만들어서 달라지는 쿼리에 대한 결과를 담도록
        ArrayList<Dept> deptList = new ArrayList<>();

        Connection conn = DBUtil.getConnection(); // DB에 접속하는 객체를 재사용

        // 3. 문장 실행
        // 문장 실행해줄 객체
        Statement stmt = conn.createStatement();

        String sql = "select * from dept";

        ResultSet rs = stmt.executeQuery(sql); // Get, Set,

        // DB에서 가져온 값으로 실제 동작을 수행
        while (rs.next()) {
            int deptno = rs.getInt(1); // 컬럼 순번(SQL의 규칙대로 1부터 시작) 정수형으로 된 자료 컬럼을 출력
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");// 컬럼명으로 문자열로 된 자료 컬럼을 출력

            Dept dept = new Dept(deptno, dname, loc); // [deptno=10, dname=SALES, loc=NEW YORK]
            deptList.add(dept);

            System.out.println(dept);
            System.out.println(deptList);
        }

        DBUtil.close(conn, stmt, rs); // 자원을 한꺼번에 닫도록 재사용


    }
}