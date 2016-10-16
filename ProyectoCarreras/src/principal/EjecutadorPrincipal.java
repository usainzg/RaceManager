package principal;

import javax.swing.JFrame;

import vista.BorradoUsuario;
import vista.MainWindow;
import vista.MenuAdmin;
import vista.MenuOrg;
import vista.ModificacionUsuario;

public class EjecutadorPrincipal {

	public static void main(String[] args) {

		/*MainWindow main = new MainWindow();
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main.setVisible(true);*/
		BorradoUsuario usu = new BorradoUsuario();
		usu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		usu.setVisible(true);
		
	}

}
