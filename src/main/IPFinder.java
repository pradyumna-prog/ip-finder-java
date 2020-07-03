package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IPFinder extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JLabel label;
	JTextField tf;
	JButton find;
	
	IPFinder(){
		super("IP Finder App");
		label = new JLabel("Enter an url: ");
		label.setBounds(50,70,150,20);
		
		tf = new JTextField(25);
	    tf.setBounds(50,100,200,20);
	    
		find = new JButton("Search !");
	    find.setBounds(100,150,100,30);  
		find.addActionListener(this);
		
		add(label);
		add(tf);
		add(find);
		setSize(300,400);
		setLayout(null);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String url = tf.getText();
		try {
			InetAddress ia = InetAddress.getByName(url);
			String result = ia.getHostAddress();
			JOptionPane.showMessageDialog(this, "IP of "+url+" is: "+result);
		}catch(UnknownHostException e1) {
			if(Pattern.matches("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$", url)) {
				JOptionPane.showMessageDialog(this, "Check your internet and try again");
			} 
			else {
				JOptionPane.showMessageDialog(this, "Invalid URL entered");
			}
		}
		
	}

	public static void main(String[] args) {
		new IPFinder();
	}

}
