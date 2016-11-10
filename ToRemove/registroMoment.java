// register event handler
			/*
			 * okBtn.addActionListener(new ActionListener() { public void
			 * actionPerformed(ActionEvent e) { boolean salidaForm =
			 * validarFormulario(); if (salidaForm == true) {
			 */

			// NORMAL USER REGISTER
			/*
			 * if
			 * (comboTipoUsuario.getSelectedItem().toString().equals("Normal"))
			 * { UsuarioEstandar uToInsert = new
			 * UsuarioEstandar(registroNombre.getText(),
			 * registroApellidos.getText(), registroDireccion.getText(),
			 * registroEmail.getText(), registroPassword.getText(),
			 * Integer.parseInt(registroTelf.getText()),
			 * registroClub.getText()); try {
			 * 
			 * int filas = dbm.altaUsuarioNormal(uToInsert);
			 * System.out.println("introducidas: " + filas);
			 * 
			 * util.
			 * createInfobox("El usuario ha sido introducido correctamente en la base de datos."
			 * , "Insercion correcta."); } catch (Exception e1) {
			 * util.createErrorbox("No se han podido introducir los datos.",
			 * "Insercion incorrecta."); }
			 */

			// ORGANIZACION USER REGISTER
			/*
			 * } else { UsuarioOrganizador uOrg = new
			 * UsuarioOrganizador(registroNombre.getText(),
			 * registroApellidos.getText(), registroDireccion.getText(),
			 * registroEmail.getText(), registroPassword.getText(),
			 * Integer.parseInt(registroTelf.getText()),
			 * registroClub.getText()); try {
			 * 
			 * int filas = dbm.altaOrganizador(uOrg);
			 * System.out.println("introducidas: " + filas);
			 * 
			 * util.
			 * createInfobox("El usuario ha sido introducido correctamente en la base de datos."
			 * , "Insercion correcta."); } catch (Exception e1) {
			 * util.createErrorbox("No se han podido introducir los datos.",
			 * "Insercion incorrecta."); } } }
			 * 
			 * } });
			 */