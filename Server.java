import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;



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
            while(true) {
		            s=skt.accept();
		            din =new DataInputStream(s.getInputStream());
		            dout =new DataOutputStream(s.getOutputStream());
		            while(true) {
            
		            msginput = din.readUTF();
		            area.setText(area.getText() + "\n" + msginput);}
            }
            
		            
            
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
		setBounds(100, 100, 533, 504);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 379, 497, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		text = new JTextField();
		text.setBounds(10, 11, 367, 53);
		panel.add(text);
		text.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				   try
			        {
			            String out =text.getText();
			            area.setText(area.getText() + "\n\t\t\t" + out);
			            dout.writeUTF(out);
			            
			            text.setText("");
			        }
			        catch (Exception ex)
			        {
			            
			        }
				
			}
		});
		btnNewButton.setBounds(387, 26, 89, 23);
		panel.add(btnNewButton);
		
		 area= new JTextArea();
		 area.setEditable(false);
		 area.setWrapStyleWord(true);
		area.setBackground(Color.WHITE);
		area.setBounds(10, 102, 497, 266);
		contentPane.add(area);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(10, 11, 497, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel arrow = new JLabel("gggggg");
		arrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		arrow.setBackground(Color.WHITE);
		arrow.setBounds(10, 11, 38, 20);
		panel_1.add(arrow);
		
		
		
		//arrow.setIcon(new ImageIcon(Server.class.getResource("/icons/3.png")));
		//arrow.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		
		//arrow.setBounds(10, 11, 42, 16);
		//panel_1.add(arrow);
		
		
		 ImageIcon myimg =new ImageIcon(Server.class.getResource("/icons/3.png"));
         Image img1=myimg.getImage();
         Image img2=img1.getScaledInstance(arrow.getWidth(),arrow.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon i =new ImageIcon(img2);
         arrow.setIcon(i);
         
         JLabel shivani = new JLabel("New label");
         shivani.setBounds(10, 42, 74, 36);
         panel_1.add(shivani);
         
         
         ImageIcon myimg1 =new ImageIcon(Server.class.getResource("/icons/WhatsApp Image 2021-05-19 at 1.12.30 PM.jpeg"));
         Image img11=myimg1.getImage();
         Image img12=img11.getScaledInstance(shivani.getWidth(),shivani.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon i1 =new ImageIcon(img12);
         shivani.setIcon(i1);
         
         JLabel name_shivani = new JLabel("Shivani");
         name_shivani.setForeground(Color.WHITE);
         name_shivani.setFont(new Font("Tahoma", Font.BOLD, 14));
         name_shivani.setBounds(182, 17, 90, 26);
         panel_1.add(name_shivani);
         
         JLabel active = new JLabel("Active Now");
         active.setForeground(Color.WHITE);
         active.setFont(new Font("Tahoma", Font.BOLD, 13));
         active.setBounds(167, 54, 105, 24);
         panel_1.add(active);
         
        
         
		 
		
		 
	}
}
