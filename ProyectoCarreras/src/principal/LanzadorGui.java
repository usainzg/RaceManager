package principal;

import java.util.ArrayList;

import javax.swing.JFrame;

import bbdd.MongoManager;
import clases.Carrera;
import vista.ventanas.MainView;

public class LanzadorGui {

	public static void main(String[] args) {

		MainView main = new MainView();

		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		MongoManager mongo = new MongoManager();
		
		try {
			ArrayList<Carrera> c = mongo.consultarCarreras();
			for(Carrera rc: c) System.out.println(rc.getNbCarrera());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
