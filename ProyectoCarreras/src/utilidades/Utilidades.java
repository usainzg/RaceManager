package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utilidades {

	
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_PASS_REGEX = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]))");
	private static final Pattern VALID_TELF_REGEX = Pattern.compile("\\d{9}");
	private static final Pattern VALID_DATE_REGEX = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

	/**
	 * Funcion para comprobar si el email es valido
	 * 
	 * @param emailStr email a comprobar
	 * @return si es valido true, sino false
	 */
	public boolean isValidEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	/**
	 * Funcion para comprobar si la pass es valida
	 * 
	 * @param pass pass a comprobar
	 * @return si es valido true, sino false
	 */
	public boolean isValidPassword(String pass) {
		Matcher matcher = VALID_PASS_REGEX.matcher(pass);
		return matcher.find();
	}

	/**
	 * Funcion para comprobar si el telefono es valido
	 * 
	 * @param numero numero a comprobar
	 * @return si es valido true, sino false
	 */
	public boolean isValidPhone(String numero) {
		Matcher matcher = VALID_TELF_REGEX.matcher(numero);
		return matcher.find();
	}

	/**
	 * Funcion para comprobar si la fecha es valida
	 * 
	 * @param fecha fecha a comprobar
	 * @return si es valido true, sino false
	 */
	public boolean isValidDate(JTextField fecha) {
		Matcher matcher = VALID_DATE_REGEX.matcher(fecha.getText());
		return matcher.find();
	}

	/**
	 * Funcion para crear popup con mensajes de informacion
	 * 
	 * @param infoMessage mensaje a mostrar
	 * @param title titulo del popup
	 */
	public void createInfobox(String infoMessage, String title) {
		JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Funcion para crear popups de error/alerta 
	 * 
	 * @param errMessage mensaje del error/alerta a mostrar
	 * @param title titulo del popup
	 */
	public void createErrorbox(String errMessage, String title) {
		JOptionPane.showMessageDialog(null, errMessage, title, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Funcion para limpiar JTextFields
	 * @param fields JTextFields a limpiar
	 */
	public void resetJTextField(JTextField... fields) {
		for (JTextField f : fields)
			f.setText("");
	}

}
