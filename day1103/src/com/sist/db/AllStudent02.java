package com.sist.db;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllStudent02 extends JFrame {
	
	JTextArea jta;
	
	public AllStudent02() {
		jta = new JTextArea();
		
		setLayout(new BorderLayout());
		
		JButton btn = new JButton("출력");
		
		add(jta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		setSize(500,300);
		setVisible(true);
		setTitle("student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String sql = "select * from student";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
	
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist"); 
	
					Statement stmt = conn.createStatement();

					ResultSet rs =stmt.executeQuery(sql);

					while( rs.next() ) {
						String name = rs.getString(1);
						int kor = rs.getInt(2);
						int eng = rs.getInt(3);
						int math = rs.getInt(4);
						jta.append(name+","+kor+","+eng+","+math+"\n");
					}

					rs.close();
					stmt.close();
					conn.close();
			
				} catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			}//end actionPerformed
			
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AllStudent02();
		
	}

}
