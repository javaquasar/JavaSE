package core.lecture3_09_Swing.practice.task_5_08.test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

//текстовое поле


public class My40 
{
	public static void main(String[] args)
	{
		System.out.println("It is program My");
		MyFrame40 frame=new MyFrame40();
		//условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	
	}

}

class MyFrame40 extends JFrame
{
	public MyFrame40()
	{
		setTitle("Dart");
		setSize(300,200);
		MyPanel40 panel=new MyPanel40();
		//получение клиентской части
		Container pane=getContentPane();
		pane.add(panel);
		
	}
	
}	

class MyPanel40 extends JPanel
{
	JTextField text1;
	JTextField text2;
	String s1="",s2="",s3="";
	//текстова€ область
	public MyPanel40()
	{
		text1=new JTextField(20);
		add(text1);
		text2=new JTextField("Text",20);
		add(text2);
		text1.getDocument().addDocumentListener(new MyListener());
	}
	public void paintComponent(Graphics g)
	{
		
		//необходиом чтобы текст коректно отрисовывалс€ в окне
		super.paintComponent(g);
		//рисуем текст в окне
		g.drawString(s1, 33, 77);
		g.drawString(s2, 33, 99);
		g.drawString(s3, 33, 122);
	}
	private class MyListener implements DocumentListener
	{
		//добавление чего-то
		public void insertUpdate (DocumentEvent e)
		{ 
			s3="("+text1.getText().trim()+")";
			text2.setText("\""+text1.getText()+"\"");
			s1=text1.getText(); repaint();
		}
		//удаление чего-то в поле
		public void removeUpdate (DocumentEvent e)
		{
			s3="("+text1.getText().trim()+")";
			s2=text1.getText(); repaint();
		}
		//изменение чего-то в поле
		public void changedUpdate (DocumentEvent e)
		{   
			//trim отбрасывает пробелы
			s3="("+text1.getText().trim()+")"; repaint();
		}
	}
}
		