package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

public class NumberGuess extends JFrame implements ActionListener{

	//����ڰ� ���ڸ� �Է��ϱ� ���� �ؽ�Ʈ�ʵ带 �ɹ������� ����
	JTextField jtf;
	
	//����ڰ� �Է��� ���ڰ� ��ǻ�Ͱ� ������ ���ڸ� ���߾�����,�� ū��,������ ����� ����� ���� �ɹ������� ����
	JTextField result;
	
	//��ǻ�Ͱ� ������ ������ �����ϱ� ���� ������ �ɹ������� ����
	int num;
	
	
	
	public NumberGuess() {
		
		//������ �ϳ� �����Ͽ� �ɹ����� num�� ����
		Random r = new Random();
		num = r.nextInt(100)+1;		//100���� �Ϸ��� +1����� ��
		
		
		//�ɹ����� �ؽ�Ʈ�ʵ�� �� ����
		jtf = new JTextField(10);
		result = new JTextField("                      ���⿡ ����� ��Ÿ���ϴ�.                       ");		//�ƹ��͵� �� ���� ȭ�鿡 ǥ��X
		
		//�������� ��ġ����� �÷ο췹�̾ƿ����� ����
		setLayout(new FlowLayout());
		
		//ȭ���� ������� ���
		add(new JLabel("���ڸ� �����Ͻÿ�."));
		add(jtf);
		add(result);
		
		//�ΰ��� ��ư ����
		JButton btn01 = new JButton("�ٽ� �ѹ�");
		JButton btn02 = new JButton("����");
		add(btn01);
		add(btn02);
		
		//�������� ũ��� ȭ�鿡 ���̵��� ����
		setSize(300,300);
		setVisible(true);
		
		//â�� ������ ���α׷��� �����ϵ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//â�� ũ�� ���� ����
		setResizable(false);
		
		//�ΰ��� ��ư�� �̺�Ʈ�� ���
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGuess();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//"�ٽ� �ѹ�" ��ư�� ������ "����"��ư�� ������ �� �޼ҵ尡 ����
		//�׷��� � ��ư�� ���������� �Ǵ��ؾ� ��
		//�׷��� �ϱ� ���ؼ� �Ű����� ActionEvent�� ActionCommand�޼ҵ� ���� ��ư�� ������ ���� �о��
		String cmd = e.getActionCommand();
		
		if(cmd.equals("�ٽ� �ѹ�")) {
			//��ǻ�Ͱ� �����ϰ� �ִ� ������ ����ڰ� �Է��� ���ڰ� �������� �Ǻ�
			
			//����ڰ� �Է��� ���ڸ� ������
			int user = Integer.parseInt(jtf.getText());
			
			//������,�� ū��,�� ������ �Ǻ��Ͽ� ����� ���
			if(user == num) {
				result.setText("                      �����Դϴ�!                       ");
				result.setBackground(Color.BLUE);
			}else if(user > num) {
				result.setText("                   �� ū ���ڸ� �Է��߾��!                   ");
				jtf.setText("");
				result.setBackground(Color.RED);
			}else {
				result.setText("                  �� ���� ���ڸ� �Է��߾��!                   ");
				jtf.setText("");
				result.setBackground(Color.RED);
			}
			
			
		}else if(cmd.equals("����")) {
			System.exit(0);
		}
		
	}

}
