package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utilidades {

	// valid patterns
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_PASS_REGEX = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]))");
	private static final Pattern VALID_TELF_REGEX = Pattern.compile("\\d{9}");
	private static final Pattern VALID_DATE_REGEX = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

	// method to validate email address in forms
	public boolean validarEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	// method to validate password
	public boolean isValidPassword(String pass) {
		Matcher matcher = VALID_PASS_REGEX.matcher(pass);
		return matcher.find();
	}

	// method to valida phonenumber
	public boolean isValidPhone(String numero) {
		Matcher matcher = VALID_TELF_REGEX.matcher(numero);
		return matcher.find();
	}

	public boolean isValidDate(JTextField fecha) {
		Matcher matcher = VALID_DATE_REGEX.matcher(fecha.getText());
		return matcher.find();
	}

	// to generate error and infoboxes
	public void createInfobox(String infoMessage, String title) {
		JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public void createErrorbox(String errMessage, String title) {
		JOptionPane.showMessageDialog(null, errMessage, title, JOptionPane.ERROR_MESSAGE);
	}

}
