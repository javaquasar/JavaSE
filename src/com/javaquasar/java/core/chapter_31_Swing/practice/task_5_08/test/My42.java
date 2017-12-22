package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_08.test;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

//зародыш блокнота

public class My42
{
	public static void main(String[] args)
	{
		System.out.println("It is program My");
		MyFrame42 frame=new MyFrame42();
		//условие закрыти€ окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	
	}

}

class MyFrame42 extends JFrame
{
	private JTextArea text;
	private JScrollPane scrollPane;
	private JPanel bPanel;
	private JButton wButton;
	private JTextField field, field2, field3;
	public MyFrame42()
	{
		setTitle("Dart");
		setSize(400,200);
		//—оздание контейнера дл€ окна
		Container pane=getContentPane();
		bPanel=new JPanel();
		JButton aButton=new JButton("Add");
		bPanel.add(aButton);
		
		aButton.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//чтобы отобразилась кавычка " нужно перед ней поставить обратный слеш \
				text.append(field.getText());
			}
		});
		
		field =new JTextField("abcd",10);
		bPanel.add(field);
		JButton iButton=new JButton("Insert");
		bPanel.add(iButton);
		
		iButton.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if (text.getSelectionStart()==
						text.getSelectionEnd())
					text.insert(field.getText(),text.getSelectionStart());
				else
				//text.replaceRange(field.getText(), text.getSelectionStart(), text.getSelectionEnd());	
				//вставка текста в место расположени€  курсора
				text.insert(field.getText(),
						text.getSelectionStart());
			}
		});
		wButton=new JButton("Wrap");
		bPanel.add(wButton);
		
		wButton.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean wrap=!text.getLineWrap();
				text.setLineWrap(wrap);
				scrollPane.validate();
				wButton.setText(wrap ? "No wrap":"Wrap");
			}
		});
		JButton dButton=new JButton("Clear");
		bPanel.add(dButton);
		
		dButton.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				text.setText("");
				
			}
		});
		pane.add(bPanel,BorderLayout.SOUTH);
		//10 строк по 40 размер символов
		text=new JTextArea(10,30);
		scrollPane=new JScrollPane(text);
		pane.add(scrollPane, BorderLayout.CENTER); 
		
		
		//панель поиска текста
		JPanel tPanel=new JPanel ();
		field2 =new JTextField("",5);
		tPanel.add(field2);
		JButton fButton=new JButton("Find");
		tPanel.add(fButton);
		
		fButton.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int i=text.getText().indexOf(field2.getText(),
						text.getSelectionStart()+1);
				if (i>=0)
					text.select(i, i+field2.getText().length());
				//возвращает фокус в текст
				text.requestFocusInWindow();
			}
		});
		field3 =new JTextField("",5);
		tPanel.add(field3);
		JButton rButton=new JButton("Replace");
		tPanel.add(rButton);
		
		rButton.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int i=text.getText().indexOf(field2.getText(),
						text.getSelectionStart());
				if (i>=0)
				{	text.replaceRange(field3.getText(),i, i+field2.getText().length());
				text.setSelectionStart(i);
				}
				//возвращает фокус в текст
				text.requestFocusInWindow();
			}
		});
		pane.add(tPanel, BorderLayout.NORTH); 
	}
	
}	


		
		