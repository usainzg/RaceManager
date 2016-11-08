comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				if (comboBox.getSelectedItem().equals("Normal")) {

					ArrayList<UsuarioEstandar> arrU = new ArrayList<UsuarioEstandar>();
					try {
						arrU = mySql.consultarEmailNormal();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioEstandar u : arrU) {
						comboBox_1.addItem(u.getEmailUsuario());
					}

				} else {

					ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
					try {
						arrU = mySql.consultarEmailOrg();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioOrganizador u : arrU) {
						comboBox_1.addItem(u.getEmailUsuario());
					}

				}

			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarEntrada() == true) {

					if (comboBox.getSelectedItem().equals("Normal")) {
						UsuarioEstandar uViejo = new UsuarioEstandar("", "", comboBox_1.getSelectedItem().toString(),
								"", "", 0, "");
						UsuarioEstandar u = new UsuarioEstandar();

						u.setNbUsuario(txtNombre.getText());
						u.setApellidosUsuario(txtApellidos.getText());
						u.setEmailUsuario(comboBox_1.getSelectedItem().toString());
						u.setPassUsuario(txtPass.getText());
						u.setDirUsuario(txtDir.getText());
						u.setTelfUsuario(Integer.parseInt(txtTelf.getText()));
						u.setClubUsuario(txtClub.getText());

						try {
							int filas = mySql.updateUsuarioNormal(uViejo, u);
							util.createInfobox("Se han modificado " + filas + " correctamente.",
									"Modificacion correcta");
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} else {

						UsuarioOrganizador uViejo = new UsuarioOrganizador("", "", "",
								comboBox_1.getSelectedItem().toString(), "", 0, "");
						UsuarioOrganizador uOrg = new UsuarioOrganizador();

						uOrg.setNbUsuario(txtNombre.getText());
						uOrg.setApellidosUsuario(txtApellidos.getText());
						uOrg.setEmailUsuario(comboBox_1.getSelectedItem().toString());
						uOrg.setPassUsuario(txtPass.getText());
						uOrg.setDirUsuario(txtDir.getText());
						uOrg.setTelfUsuario(Integer.parseInt(txtTelf.getText()));
						uOrg.setClubUsuario(txtClub.getText());

						try {
							int filas = mySql.updateUsuarioOrganizador(uViejo, uOrg);
							util.createInfobox("Se han modificado " + filas + " correctamente.",
									"Modificacion correcta");
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					}

				} else {
					util.createErrorbox("Vuelve a introducir los datos por favor.", "Datos erroneos");
				}
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				util.resetJTextField(txtNombre, txtApellidos, txtDir, txtPass, txtTelf, txtClub);
			}
		});
	}

	// TODO refactor
	public boolean validarEntrada() {

		if (!txtNombre.getText().equals("") && !txtApellidos.getText().equals("") && !txtPass.getText().equals("")
				&& !txtDir.getText().equals("") && !txtTelf.getText().equals("") && !txtClub.getText().equals("")) {

			// validate pass
			if (!util.isValidPassword(txtPass.getText())) {
				util.createErrorbox(
						"La contraseña debe tener al menos 6 caracteres de longitud y algun letra mayuscula.",
						"Formato contraseña erroneo.");
				txtPass.setText("");
				return false;
			}

			// validate telf
			if (!util.isValidPhone(txtTelf.getText())) {
				util.createErrorbox("El campo telefono debe ser numerico y tener un maximo de 9 digitos.",
						"Formato telefono erroneo.");
				return false;
			}
			return true;
		} else {
			util.createErrorbox("Te faltan campos por rellenar, por favor completa todos los campos.",
					"Faltan campos por rellenar.");
			return false;
		}
	}