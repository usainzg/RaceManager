package principal;

import javax.swing.JFrame;

import vista.MainWindow;

public class LanzadorGui {

	public static void main(String[] args) {

		MainWindow main = new MainWindow();
		

		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		

	}

}
