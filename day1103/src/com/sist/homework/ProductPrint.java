package com.sist.homework;

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

public class ProductPrint extends JFrame {

	JTextArea jta;
	
	public ProductPrint() {
		jta = new JTextArea();
		
		setLayout(new BorderLayout());
		
		JButton btn = new JButton("출력");
		
		add(jta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		setSize(500,400);
		setVisible(true);
		setTitle("product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = "select * from product";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String number = rs.getString(1);
						String item = rs.getString(2);
						int qty = rs.getInt(3);
						int price = rs.getInt(4);
						jta.append(number+","+item+","+qty+","+price+"\n");
					}
					
					rs.close();
					stmt.close();
					conn.close();
					
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			}});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProductPrint();
	}

}
