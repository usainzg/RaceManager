package gui;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView login = new LoginView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
