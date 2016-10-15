package utilidades;

import javax.swing.JButton;

public class UI {
	
	private static void quitarAspectoBoton(JButton boton){
		boton.setOpaque(false);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
	}
}
