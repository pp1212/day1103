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

	//사용자가 숫자를 입력하기 위한 텍스트필드를 맴버변수로 선언
	JTextField jtf;
	
	//사용자가 입력한 숫자가 컴퓨터가 생각한 숫자를 맞추었는지,더 큰지,작은지 결과를 출력할 라벨을 맴버변수로 선언
	JTextField result;
	
	//컴퓨터가 생각할 난수를 저장하기 위한 변수를 맴버변수로 선언
	int num;
	
	
	
	public NumberGuess() {
		
		//난수를 하나 생성하여 맴버변수 num에 저장
		Random r = new Random();
		num = r.nextInt(100)+1;		//100까지 하려면 +1해줘야 함
		
		
		//맴버변수 텍스트필드와 라벨 생성
		jtf = new JTextField(10);
		result = new JTextField("                      여기에 결과가 나타납니다.                       ");		//아무것도 안 쓰면 화면에 표시X
		
		//프레임의 배치방식을 플로우레이아웃으로 설정
		setLayout(new FlowLayout());
		
		//화면의 구성요소 담기
		add(new JLabel("숫자를 추측하시오."));
		add(jtf);
		add(result);
		
		//두개의 버튼 생성
		JButton btn01 = new JButton("다시 한번");
		JButton btn02 = new JButton("종료");
		add(btn01);
		add(btn02);
		
		//프레임의 크기와 화면에 보이도록 설정
		setSize(300,300);
		setVisible(true);
		
		//창을 닫으면 프로그램을 종료하도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//창의 크기 변경 금지
		setResizable(false);
		
		//두개의 버튼에 이벤트를 등록
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
		
		//"다시 한번" 버튼을 눌러도 "종료"버튼을 눌러도 이 메소드가 동작
		//그래서 어떤 버튼이 눌러졌는지 판단해야 함
		//그렇게 하기 위해서 매개변수 ActionEvent의 ActionCommand메소드 통해 버튼의 쓰여진 글자 읽어옴
		String cmd = e.getActionCommand();
		
		if(cmd.equals("다시 한번")) {
			//컴퓨터가 생각하고 있는 난수와 사용자가 입력한 숫자가 동일한지 판별
			
			//사용자가 입력한 숫자를 가져옴
			int user = Integer.parseInt(jtf.getText());
			
			//같은지,더 큰지,더 작은지 판별하여 결과를 출력
			if(user == num) {
				result.setText("                      정답입니다!                       ");
				result.setBackground(Color.BLUE);
			}else if(user > num) {
				result.setText("                   더 큰 숫자를 입력했어요!                   ");
				jtf.setText("");
				result.setBackground(Color.RED);
			}else {
				result.setText("                  더 작은 숫자를 입력했어요!                   ");
				jtf.setText("");
				result.setBackground(Color.RED);
			}
			
			
		}else if(cmd.equals("종료")) {
			System.exit(0);
		}
		
	}

}
