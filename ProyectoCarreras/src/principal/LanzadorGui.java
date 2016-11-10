package principal;

import javax.swing.JFrame;

import bbdd.ManagerBd;
import vista.ventanas.MainView;
import vista.ventanas.NormalView;

public class LanzadorGui {

	public static void main(String[] args) {
		
		ManagerBd manager = new ManagerBd();
		manager.setDb("mysql");
		NormalView main = new NormalView(manager);
		
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
