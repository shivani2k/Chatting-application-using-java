import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.net.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Server extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6734632686774511121L;
	private JPanel contentPane;
	private JTextField text;
	 static ServerSocket skt;
	 static Socket s;
	 static DataInputStream din;
	 static DataOutputStream dout;
	 static JTextArea area;
	  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		String msginput ="";
        try
        {
            skt= new ServerSocket(7006);
            s=skt.accept();
            din =new DataInputStream(s.getInputStream());
            dout =new DataOutputStream(s.getOutputStream());
            
            msginput = din.readUTF();
            area.setText(area.getText() + "\n" + msginput);
            skt.close();
            s.close();
            
        }
        catch (Exception e)
        {
           
            
        }
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 342, 385, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		text = new JTextField();
		text.setBounds(10, 11, 262, 53);
		panel.add(text);
		text.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				   try
			        {
			            String out =text.getText();
			            area.setText(area.getText() + "\n\t\t\t\t" + out);
			            dout.writeUTF(out);
			            
			            text.setText("");
			        }
			        catch (Exception ex)
			        {
			            
			        }
				
			}
		});
		btnNewButton.setBounds(286, 26, 89, 23);
		panel.add(btnNewButton);
		
		 area= new JTextArea();
		area.setBackground(Color.WHITE);
		area.setBounds(10, 35, 385, 286);
		contentPane.add(area);
	}
}
