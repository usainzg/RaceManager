package vista.paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class RegistroPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField registroNombre;
	private JTextField registroApellidos;
	private JTextField registroEmail;
	private JTextField registroPassword;
	private JTextField registroDireccion;
	private JTextField registroTelf;
	private JTextField registroClub;
	private final String[] USERTYPES = { "Normal", "Organizacion" };

	
	public RegistroPanel() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// labels
				{
					JLabel lblNewLabel = new JLabel("Nombre");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel.setBounds(10, 38, 56, 14);
					add(lblNewLabel);
				}
				
								// textfields
								{
									registroNombre = new JTextField();
									registroNombre.setBounds(76, 36, 125, 20);
									add(registroNombre);
									registroNombre.setColumns(10);
								}
				{
					JLabel lblContrasena = new JLabel("Contrasena");
					lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblContrasena.setBounds(222, 82, 83, 14);
					add(lblContrasena);
				}
				{
					registroPassword = new JTextField();
					registroPassword.setBounds(307, 80, 150, 20);
					add(registroPassword);
					registroPassword.setColumns(10);
				}
				{
					JLabel lblDireccion = new JLabel("Direccion");
					lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblDireccion.setBounds(10, 121, 56, 14);
					add(lblDireccion);
				}
				{
					registroDireccion = new JTextField();
					registroDireccion.setBounds(76, 119, 125, 20);
					add(registroDireccion);
					registroDireccion.setColumns(10);
				}
				{
					JLabel lblTelefono = new JLabel("Telefono");
					lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblTelefono.setBounds(222, 121, 56, 14);
					add(lblTelefono);
				}
				{
					registroTelf = new JTextField();
					registroTelf.setBounds(307, 119, 150, 20);
					add(registroTelf);
					registroTelf.setColumns(10);
				}
				{
					JLabel lblApellidos = new JLabel("Apellidos");
					lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblApellidos.setBounds(222, 38, 65, 14);
					add(lblApellidos);
				}
				{
					registroApellidos = new JTextField();
					registroApellidos.setBounds(307, 36, 150, 20);
					add(registroApellidos);
					registroApellidos.setColumns(10);
				}
				{
					JLabel lblEmail = new JLabel("Email");
					lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblEmail.setBounds(10, 82, 46, 14);
					add(lblEmail);
				}
				{
					registroEmail = new JTextField();
					registroEmail.setBounds(76, 80, 125, 20);
					add(registroEmail);
					registroEmail.setColumns(10);
				}
				{
					JLabel lblClub = new JLabel("Club");
					lblClub.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblClub.setBounds(10, 160, 46, 14);
					add(lblClub);
				}
				{
					registroClub = new JTextField();
					registroClub.setBounds(76, 158, 125, 20);
					add(registroClub);
					registroClub.setColumns(10);
				}
				
								// label for combobox
								JLabel lblTipoUsuario = new JLabel("Tipo usuario");
								lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblTipoUsuario.setBounds(222, 161, 83, 14);
								add(lblTipoUsuario);

				// combobox with user types
				JComboBox<String> comboTipoUsuario = new JComboBox<String>();
				comboTipoUsuario.setBounds(307, 158, 150, 20);

				// populate combobox with constant string array
				comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
				add(comboTipoUsuario);
				
								{
									JPanel buttonPane = new JPanel();
									buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
									add(buttonPane);
									{
										JButton okBtn = new JButton("Registrarse");
				
										// register event handler
										 /*okBtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												boolean salidaForm = validarFormulario();
												if (salidaForm == true) { */
				
													// NORMAL USER REGISTER
													/* if (comboTipoUsuario.getSelectedItem().toString().equals("Normal")) {
														UsuarioEstandar uToInsert = new UsuarioEstandar(registroNombre.getText(),
																registroApellidos.getText(), registroDireccion.getText(),
																registroEmail.getText(), registroPassword.getText(),
																Integer.parseInt(registroTelf.getText()), registroClub.getText());
														try {
															
															int filas = dbm.altaUsuarioNormal(uToInsert);
															System.out.println("introducidas: " + filas);
															
															util.createInfobox("El usuario ha sido introducido correctamente en la base de datos.",
																	"Insercion correcta.");
														} catch (Exception e1) {
															util.createErrorbox("No se han podido introducir los datos.",
																	"Insercion incorrecta.");
														} */
				
														// ORGANIZACION USER REGISTER
													/* } else {
														UsuarioOrganizador uOrg = new UsuarioOrganizador(registroNombre.getText(),
																registroApellidos.getText(), registroDireccion.getText(),
																registroEmail.getText(), registroPassword.getText(),
																Integer.parseInt(registroTelf.getText()), registroClub.getText());
														try {
															
															int filas = dbm.altaOrganizador(uOrg);
															System.out.println("introducidas: " + filas);
															
															util.createInfobox("El usuario ha sido introducido correctamente en la base de datos.",
																	"Insercion correcta.");
														} catch (Exception e1) {
															util.createErrorbox("No se han podido introducir los datos.",
																	"Insercion incorrecta.");
														}
													}
												}
				
											}
										});*/
										okBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
										okBtn.setActionCommand("");
										buttonPane.add(okBtn);
										getRootPane().setDefaultButton(okBtn); 
										
										{
											JButton btnLimpiar = new JButton("Limpiar");
											/*btnLimpiar.addActionListener(new ActionListener() {
												JTextField[] arrJ = { registroNombre, registroApellidos, registroClub, registroDireccion,
														registroEmail, registroPassword, registroTelf };
				
												public void actionPerformed(ActionEvent arg0) {
													for (JTextField j : arrJ) {
														util.resetJTextField(j);
													}
				
												}
											});*/
											btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
											buttonPane.add(btnLimpiar);
										}
				
									}
									{
										JButton cancelBtn = new JButton("Cancel");
				
										// cancel event handler
										cancelBtn.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												// TODO return to main panel (mainLoginPanel)
											}
										});
										cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
										cancelBtn.setActionCommand("Cancel");
										buttonPane.add(cancelBtn);
									}
								}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
				{
					JLabel label = new JLabel("");
					add(label);
				}
			}

	}

// }
