package principal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {


	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
	}

	public Main() {
		setBounds(100, 100, 446, 274);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnMysql = new JButton("MySql");
		btnMysql.setBounds(46, 66, 89, 23);
		getContentPane().add(btnMysql);
		
		JButton btnOracle = new JButton("Oracle");
		btnOracle.setBounds(274, 66, 89, 23);
		getContentPane().add(btnOracle);
		
		JButton btnDbo = new JButton("Db4o");
		btnDbo.setBounds(46, 143, 89, 23);
		getContentPane().add(btnDbo);
		
		JLabel lblEligeLaBd = new JLabel("Elige la BD que quieres utilizar:");
		lblEligeLaBd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEligeLaBd.setBounds(90, 11, 302, 24);
		getContentPane().add(lblEligeLaBd);
		
		btnMysql.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
	
}
