package core.lecture3_09_Swing.practice.task_5_08.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//создаем три окна 
public class My25 
{
	
	public static void main(String[] args)
	{
		System.out.println("It is program My");
		MyFrame25 frame=new MyFrame25(30,30,300,200);
		//мен€ем название окна
		frame.setTitle("Dart");
		//не мен€етс€ размер окна
		frame.setResizable(false);
		//условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
		MyFrame25 frame2=new MyFrame25(50,50,300,200);
		//мен€ем иконку окна
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image im=kit.getImage("dartvejder.jpg");
		frame2.setIconImage(im);
		//размер окна на весь экран
		frame2.show();
		frame2.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		MyFrame25 frame3=new MyFrame25(40,40,300,200);
		//убираем рамку с окна
		frame3.setUndecorated(true);
		frame3.show();
	}

}
class MyFrame25 extends JFrame
{
	public MyFrame25(int x, int y, int w, int h)
	{
		//setSize задает размер окна
		//setSize(300,200);
		//setLocation задает положение окна на экране относительно верхнего левого угла
		//setLocation(x,y);
		//setBounds задает размер окнаи его положение на экране
		//setBounds=setSize+setLocation
		//setBounds(x,y,300,200);
		//ѕолучение размера экрана компа
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int lx=screenSize.width;
		int ly=screenSize.height;
		setBounds(x*lx/100-w/2,y*ly/100-h/2,300,200);
	}
}