package com.javaquasar.java.core.chapter_21_Network.practice.task_5_02_2;

import java.net.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ServerWindow {
  private JFrame      frame;
  private JPanel      panelTop;
  private JButton     buttonStart;
  private JButton     buttonExit;
  private JScrollPane scrollPaneClients;
  private JScrollPane scrollPaneMessages;
  private JTextArea   textAreaClients;
  private JTextArea   textAreaMessages;
  private ChatServer  chatServer;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ServerWindow window = new ServerWindow();
          window.frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ServerWindow() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setTitle("Сервер");
    frame.setBounds(100, 100, 558, 439);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(getPanelTop(), BorderLayout.SOUTH);
    frame.getContentPane().add(getScrollPaneClients(), BorderLayout.WEST);
    frame.getContentPane().add(getScrollPaneMessages(), BorderLayout.CENTER);
  }

  private JPanel getPanelTop() {
    if (panelTop == null) {
      panelTop = new JPanel();
      panelTop.add(getButtonStart());
      panelTop.add(getButtonExit());
    }
    return panelTop;
  }

  private JButton getButtonStart() {
    if (buttonStart == null) {
      buttonStart = new JButton("Запустить сервер");
      buttonStart.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          chatServer = new ChatServer();
          chatServer.start();
        }
      });
    }
    return buttonStart;
  }

  private JButton getButtonExit() {
    if (buttonExit == null) {
      buttonExit = new JButton("      Выйти      ");
      buttonExit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (chatServer != null) {
            chatServer.shutdownServer();
            chatServer.interrupt();
          }
          frame.dispose();
        }
      });
    }
    return buttonExit;
  }

  private JScrollPane getScrollPaneClients() {
    if (scrollPaneClients == null) {
      scrollPaneClients = new JScrollPane();
      scrollPaneClients.setBorder(new TitledBorder(null, "Клиенты", 
          TitledBorder.LEADING, TitledBorder.TOP, null, null));
      scrollPaneClients.setPreferredSize(new Dimension(200, 4));
      scrollPaneClients.setViewportView(getTextAreaClients());
    }
    return scrollPaneClients;
  }

  private JScrollPane getScrollPaneMessages() {
    if (scrollPaneMessages == null) {
      scrollPaneMessages = new JScrollPane();
      scrollPaneMessages.setBorder(new TitledBorder(null, "Сообщения",
          TitledBorder.LEADING, TitledBorder.TOP, null, null));
      scrollPaneMessages.setViewportView(getTextAreaMessages());
    }
    return scrollPaneMessages;
  }

  private JTextArea getTextAreaClients() {
    if (textAreaClients == null) {
      textAreaClients = new JTextArea();
    }
    return textAreaClients;
  }

  private JTextArea getTextAreaMessages() {
    if (textAreaMessages == null) {
      textAreaMessages = new JTextArea();
    }
    return textAreaMessages;
  }

  private class ClientThread extends Thread {
    private String name = "";
    private BufferedReader input;
    private PrintWriter output;
    
    public ClientThread(Socket clientSocket) throws Exception  {
    // Получаем потоки ввода/вывода от клиента:
      input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//поток ввода
      output = new PrintWriter(clientSocket.getOutputStream(), true);//поток вывода  
      name = input.readLine(); // читаем имя клиента
      this.start();
    }

    public void run() {
      String line;
      try {
        while (true) {
          line = input.readLine();
  
          if (line.equals("end")) {
            chatServer.clients.remove(this);
            break;
          }

          if(chatServer.clientToClient(name, line)== false){
        	   chatServer.clientToClients(name, line);
        	   System.out.println("allchat");
          }

          try {          
            sleep(5);
          } 
          catch (Exception ex) {
            break;
          } 
        }
        if (chatServer.clients.size() <= 0)
          if (!chatServer.serverSocket.isClosed())
            chatServer.serverSocket.close();
      }
      catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        ex.printStackTrace();
        System.out.println("atata");
      }
    }
    public Object getUserName() {
      return name;
    }

    public void sendMessage(String userName, String msg) {
      output.println(userName + ":" + msg);//посылаем сообщение клиенту 
      final String userName1 = userName;//локальная константа дублирует userName - для метода run()
      final String msg1 = msg;//локальная константа дублирует msg - для метода run()
 
      SwingUtilities.invokeLater(new Runnable() {//отправляем основной нити (серверной) объект Runnable с методом run(), который перерисует форму
        @Override
        public void run() {
          getTextAreaMessages().append(userName1 + ":" + msg1 + "\n");//пишем на форму в TextAreaHistory информацию о клиенте
        }
      });
    }

    public void removeClient() {//удаляем клиента
      chatServer.clients.remove(this);//удаляем клиента из списка клиентов
    }

  }

  private class ChatServer extends Thread {
    ServerSocket serverSocket;
    ArrayList<ClientThread> clients = new ArrayList<>();

    @Override
    public void run() {
      try {
        serverSocket = new ServerSocket(9003); // создаем сервер-сокет
        while (true) {
          if (serverSocket.isClosed())
            return;
          try {
            Socket clientSocket = serverSocket.accept(); // сервер ожидает клиента
            final ClientThread client = new ClientThread(clientSocket); // создаем нового клиента
            clients.add(client); // добавляем клиента в список клиентов
            // Отправляем основной нити объект Runnable с методом run(), который перерисует форму:
            SwingUtilities.invokeLater(new Runnable() {
              @Override
              public void run() {
                // Пишем на форму в TextArea информацию о клиенте:
                getTextAreaClients().append(client.getUserName() + "\n");
              }
            });
          }
          catch (Exception ex) {
            break;
          }
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    private String getFirstWord(String text) {
        if (text.indexOf(' ') > -1) { // Check if there is more than one word.
          return text.substring(0, text.indexOf(' ')); // Extract first word.
        } else {
          return text; // Text is the first word itself.
        }
      }
    
    public boolean clientToClient(String name, String line) {
    	for (ClientThread c : clients){
            if (c.getUserName().equals(getFirstWord(line))){
              c.sendMessage(name, line);

              return true;
            }
    	}
		return false;
	}

	public synchronized void shutdownServer() {//закрытие сервера
      try {
        for (ClientThread c : clients) {
          c.removeClient();//удаляем клиентов из списка
        }
        if (!serverSocket.isClosed())
          serverSocket.close();
      }
      catch (Exception ignored) {
      }
    }

    public void clientToClients(String user, String message) {
      // посылаем сообщение всем подключенным клиентам
      for (ClientThread c : clients)
        if (!c.getUserName().equals(user))
          c.sendMessage(user, message);
    }

  }
}