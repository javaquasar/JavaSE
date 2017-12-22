package core.lecture3_11_Network.practice.task_5_02_2;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientWindow {
  private JFrame      frame;
  private JPanel      panelTop;
  private JTextField  textFieldMessage;
  private JButton     buttonSend;
  private JButton     buttonExit;
  private JScrollPane scrollPane;
  private JTextArea   textArea;
  private ChatClient  client;


  public static void main(String[] args) throws Exception {
    final String name = JOptionPane.showInputDialog(null, "Введите имя:", "Имя пользователя",
        JOptionPane.PLAIN_MESSAGE);
    final String serverName = "localhost";
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ClientWindow window = new ClientWindow(name, serverName);
          window.frame.setTitle(name);
          window.frame.setVisible(true);
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Ошибка соединения", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ClientWindow(String userName, String serverName) throws Exception {
    initialize();
    client = new ChatClient(userName, serverName);
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(getPanelTop(), BorderLayout.SOUTH);
    frame.getContentPane().add(getScrollPane(), BorderLayout.CENTER);
  }

  private JPanel getPanelTop() {
    if (panelTop == null) {
      panelTop = new JPanel();
      panelTop.add(getTextFieldMessage());
      panelTop.add(getButtonSend());
      panelTop.add(getButtonExit());
    }
    return panelTop;
  }

  private JTextField getTextFieldMessage() {
    if (textFieldMessage == null) {
      textFieldMessage = new JTextField();
      textFieldMessage.setColumns(50);
    }
    return textFieldMessage;
  }

  private JButton getButtonSend() {
    if (buttonSend == null) {
      buttonSend = new JButton("Отправить");
      buttonSend.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          client.sendMessage(getTextFieldMessage().getText());
        }
      });
    }
    return buttonSend;
  }

  private JButton getButtonExit() {
    if (buttonExit == null) {
      buttonExit = new JButton("    Выйти    ");
      buttonExit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          client.close();
          frame.dispose();
        }
      });
    }
    return buttonExit;
  }

  private JScrollPane getScrollPane() {
    if (scrollPane == null) {
      scrollPane = new JScrollPane();
      scrollPane.setViewportView(getTextArea());
    }
    return scrollPane;
  }

  private JTextArea getTextArea() {
    if (textArea == null) {
      textArea = new JTextArea();
    }
    return textArea;
  }
  
  private class ChatClient implements Runnable {
    String userName;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    Socket socketClient;
    
    ChatClient(String userName, String serverName) throws Exception { // создаем нового клиента с указанным именем (userName)
      this.userName = userName;
      socketClient  = new Socket(serverName, 9003);// создаем сокет (хост localhost и порт №9999)
      bufferedReader = new BufferedReader( new InputStreamReader( socketClient.getInputStream()) ) ;
      printWriter = new PrintWriter(socketClient.getOutputStream(), true);
      printWriter.println(userName);  // посылаем имя серверу
      printWriter.println(userName);
      new Thread(this).start();  // создаем и запускаем нить чтения из  textAreaMessages
    }
    
    void sendMessage(String message) {
      printWriter.println(message);
    }
    
    synchronized void close() {//метод close синхронизирован, чтобы исключить двойное закрытие.  
      if (!socketClient.isClosed()) { // проверяем, что сокет не закрыт 
        try {
          socketClient.close(); // закрываем 
        }
        catch (IOException ignored) {
          ignored.printStackTrace();
        }
      }
    }
    
    @Override
    public void run() {
      String line;
      try {
        while(true) {
          line = bufferedReader.readLine();
              //new StringTokenizer(line, ":").nextToken();
          String cl = new StringTokenizer(line, ":").nextToken();
          textArea.append(line + "\n");
        }
      } 
      catch(Exception ex) {
        
      }
    }
    
  }
}