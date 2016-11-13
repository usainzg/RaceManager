btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboTipo.getSelectedItem().equals("Normal")) {

					try {
						UsuarioEstandar uStd = new UsuarioEstandar();
						uStd.setNbUsuario("");
						uStd.setApellidosUsuario("");
						uStd.setEmailUsuario(comboEmail.getSelectedItem().toString());
						uStd.setPassUsuario("");
						uStd.setDirUsuario("");
						uStd.setTelfUsuario(0);
						uStd.setClubUsuario("");
						int filas = manager.deleteUsuarioNormal(uStd);
						util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
						comboEmail.removeItem(uStd.getEmailUsuario());
					} catch (Exception ex) {
						util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
					}

				} else {

					try {
						UsuarioOrganizador uOrg = new UsuarioOrganizador();

						uOrg.setNbUsuario("");
						uOrg.setApellidosUsuario("");
						uOrg.setEmailUsuario(comboEmail.getSelectedItem().toString());
						uOrg.setPassUsuario("");
						uOrg.setDirUsuario("");
						uOrg.setTelfUsuario(0);
						uOrg.setClubUsuario("");
						int filas = manager.deleteUsuarioOrganizador(uOrg);
						util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
						comboEmail.removeItem(uOrg.getEmailUsuario());
					} catch (Exception ex) {
						util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
					}

				}

			}
		});
		
		comboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboEmail.removeAllItems();
				if (comboTipo.getSelectedItem().equals("Normal")) {

					ArrayList<UsuarioEstandar> arrU = new ArrayList<UsuarioEstandar>();
					try {
						arrU = mySql.consultarEmailNormal();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioEstandar u : arrU) {
						comboEmail.addItem(u.getEmailUsuario());
					}

				} else {

					ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
					try {
						arrU = mySql.consultarEmailOrg();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioOrganizador u : arrU) {
						comboEmail.addItem(u.getEmailUsuario());
					}

				}

			}
		});