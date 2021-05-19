import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
            while(true) {
            msginput = din.readUTF();
            area1.setText(area1.getText() + "\n" + msginput);
            }
            
            
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
		setBounds(100, 100, 533, 504);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 507, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 363, 487, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		text1 = new JTextField();
		text1.setBounds(10, 11, 368, 47);
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
		btnNewButton.setBounds(388, 23, 89, 23);
		panel_1.add(btnNewButton);
		
		 area1= new JTextArea();
		area1.setBounds(10, 97, 487, 255);
		panel.add(area1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(10, 11, 487, 86);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel arrow = new JLabel("New label");
		arrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		arrow.setBounds(0, 11, 46, 14);
		panel_2.add(arrow);
		
		JLabel manali = new JLabel("New label");
		manali.setBounds(10, 36, 92, 50);
		panel_2.add(manali);
		
		JLabel Manali = new JLabel("Manali");
		Manali.setForeground(new Color(255, 255, 255));
		Manali.setFont(new Font("Tahoma", Font.BOLD, 14));
		Manali.setBounds(220, 16, 147, 27);
		panel_2.add(Manali);
		
		JLabel active1 = new JLabel("Active Now");
		active1.setForeground(new Color(255, 255, 255));
		active1.setFont(new Font("Tahoma", Font.BOLD, 13));
		active1.setBounds(220, 54, 86, 14);
		panel_2.add(active1);
		
		
		ImageIcon myimg =new ImageIcon(Server.class.getResource("/icons/3.png"));
        Image img1=myimg.getImage();
        Image img2=img1.getScaledInstance(arrow.getWidth(),arrow.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i =new ImageIcon(img2);
        arrow.setIcon(i);
        
        
        ImageIcon myimg1 =new ImageIcon(Server.class.getResource("/icons/Screenshot (373).png"));
        Image img11=myimg1.getImage();
        Image img12=img11.getScaledInstance(manali.getWidth(),manali.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i1 =new ImageIcon(img12);
        manali.setIcon(i1);
		
		
		
	}

}
