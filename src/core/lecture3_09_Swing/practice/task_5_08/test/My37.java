package core.lecture3_09_Swing.practice.task_5_08.test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//многоадресна€ передача событий
//создание дочернего окна

public class My37
{
	public static void main(String[] args)
	{
		System.out.println("It is program My");
		MyFrame37 frame=new MyFrame37();
		//условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	
	}

}

class MyFrame37 extends JFrame
{
	public MyFrame37()
	{
		setTitle("Dart");
		setSize(300,200);
		MyPanel37 panel=new MyPanel37();
		//получение клиентской части
		Container pane=getContentPane();
		pane.add(panel);
		
	}
	
}	

class MyPanel37 extends JPanel
{
	public MyPanel37()
	{
		//создание кнопок
		JButton newButton=new JButton("New");
		add(newButton);
		final JButton closeAllButton=new JButton("Close all");
		add(closeAllButton);
		//безым€нный класс
		ActionListener newListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				BlankFrame frame=new BlankFrame(closeAllButton);
				frame.show();
			}
		};
		newButton.addActionListener(newListener);
	}
}
//
class BlankFrame extends JFrame
{
	private ActionListener closeListener;
	
	private static int counter=0;
	
	public BlankFrame(final JButton closeAllButton)
	{
		counter++;
		setTitle("Frame "+counter);
		setSize(200,150);
		setLocation(200+counter*40,200+counter*30);
		closeListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				closeAllButton.removeActionListener(closeListener);
				dispose();
			}
		};
		closeAllButton.addActionListener(closeListener);
	}
	
}
		
		