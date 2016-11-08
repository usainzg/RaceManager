package principal;

import javax.swing.JFrame;

import vista.ventanas.MainView;

public class LanzadorGui {

	public static void main(String[] args) {

		MainView main = new MainView();
		

		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		

	}

}
