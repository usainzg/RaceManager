package principal;

import javax.swing.JFrame;

import vista.MainWindow;
import vista.ModificacionUsuario;

public class LanzadorMySql {

	public static void main(String[] args) {

		/*MainWindow main = new MainWindow();

		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);*/
		
		ModificacionUsuario usu = new ModificacionUsuario();
		usu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usu.setVisible(true);

	}

}
