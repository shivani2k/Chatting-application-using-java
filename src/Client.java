import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.net.*;
import java.io.*;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text1;
	 static JTextArea area1;
	 
	 static Socket s;
	    static DataInputStream din;
	    static DataOutputStream dout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try
        {
            s= new Socket("127.0.0.1",7006);
            
            din =new DataInputStream(s.getInputStream());
            dout =new DataOutputStream(s.getOutputStream());
            String msginput ="";
            msginput = din.readUTF();
            area1.setText(area1.getText() + "\n" + msginput);
            
            
        }
        catch (Exception e)
        {
           
            
        }
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 328, 394, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		text1 = new JTextField();
		text1.setBounds(10, 11, 283, 47);
		panel_1.add(text1);
		text1.setColumns(10);
		
		JButton btnNewButton = new JButton("send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try
			        {
			            String out =text1.getText();
			            area1.setText(area1.getText() + "\n\t\t\t" + out);
			            dout.writeUTF(out);
			            
			            text1.setText("");
			        }
			        catch (Exception ex)
			        {
			            
			        }
			}
		});
		btnNewButton.setBounds(295, 23, 89, 23);
		panel_1.add(btnNewButton);
		
		 area1= new JTextArea();
		area1.setBounds(28, 72, 355, 234);
		panel.add(area1);
		
		
		
	}

}
