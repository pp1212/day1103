package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String sql = "select * from student";
			
			//1.jdbc 드라이버를 메모리로 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist"); 
			
			//3.Statement 객체 생성
			Statement stmt = conn.createStatement();
			
			//4.데이터베이스 명령을 실행
			ResultSet rs =stmt.executeQuery(sql);
			
			//레코드가 있는만큼 커서를 한 행씩 옮기기
			while( rs.next() ) {
				String name = rs.getString(1);
				int kor = rs.getInt(2);
				int eng = rs.getInt(3);
				int math = rs.getInt(4);
				System.out.println(name+","+kor+","+eng+","+math);
			}
			//5.사용했던 자원들 닫기
			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
