package com.sist.homework;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProductInsert extends JFrame {

	JTextField jtf_p_number;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	public ProductInsert() {
		jtf_p_number = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		p.add(new JLabel("상품번호:"));
		p.add(jtf_p_number);
		p.add(new JLabel("상품명:"));
		p.add(jtf_item);
		p.add(new JLabel("수량:"));
		p.add(jtf_qty);
		p.add(new JLabel("단가:"));
		p.add(jtf_price);
		
		JButton btn = new JButton("추가");
		add(p,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		setSize(300,200);
		setVisible(true);
		setTitle("product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String number = jtf_p_number.getText();
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText()); 
				int price = Integer.parseInt(jtf_price.getText()); 
				
				String sql = "insert into product values('"+number+"','"+item+"',"+qty+","+price+")";
				System.out.println(sql);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					System.out.println("re:"+re);
					
					conn.close();
					stmt.close();
					
					
				} catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProductInsert();
	}

}
