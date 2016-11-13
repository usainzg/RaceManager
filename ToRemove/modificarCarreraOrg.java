ddWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				ArrayList<Carrera> arr = new ArrayList<>();

				try {
					arr = mySql.consultarCarreras();

					for (Carrera c : arr) {
						comboBox.addItem(c.getNbCarrera());
					}
				} catch (Exception e) {
					util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
				}

			}
		});

		// listeners
		txtFecha.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				util.resetJTextField(txtFecha);

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!util.isValidDate(txtFecha)) {
					util.createInfobox(
							"Vuelva a introducir la fecha en el siguiente formato: 0000-00-00 / aï¿½os-meses-dias",
							"Formato fecha erroneo");
				}
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (util.isValidDate(txtFecha)) {
					try {

						Carrera c = new Carrera(comboBox.getSelectedItem().toString(), null, 0, 0, 0, "", "");
						Carrera cNueva = new Carrera();
						cNueva.setNbCarrera(comboBox.getSelectedItem().toString());
						cNueva.setOrgCarrera(null);
						cNueva.setDistanciaCarrera(Integer.parseInt(txtDistancia.getText()));
						cNueva.setDesnivelCarrera(Integer.parseInt(txtDesnivel.getText()));
						cNueva.setPrecioCarrera(Integer.parseInt(txtPrecio.getText()));

						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						String str = txtFecha.getText();

						try {
							Date date = formatter.parse(str);
							String formateado = formatter.format(date);
							cNueva.setFechaCarrera(formateado);
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						cNueva.setLugarCarrera(txtLugar.getText());

						int filas = mySql.updateCarreraAdmin(c, cNueva);
						util.createInfobox("Se han modificado " + filas + " filas de la base de datos.",
								"Modificacion no completada.");

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				} else {
					util.createErrorbox("Revise los campos", "Fallo de formato");
				}

			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				util.resetJTextField(txtDesnivel, txtDistancia, txtLugar, txtFecha);
			}
		});
