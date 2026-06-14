package com.example.mitienda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label lblMensaje;
    @FXML
    private TextField txtNombre;
    @FXML
    private PasswordField pwdContra;
    @FXML
    private ComboBox<String> cmbRol;
    @FXML
    public void initialize() {
        cmbRol.getItems().addAll(
                "Administrador",
                "Vendedor",
                "Cajero"
        );
    }
    @FXML
    private void Ingreso() {

        String nombre = txtNombre.getText().trim();
        String password = pwdContra.getText();
        if (nombre.isEmpty()) {
            lblMensaje.setText("El usuario es obligatorio");
            return;
        }

        if (nombre.length() < 3) {
            lblMensaje.setText("El usuario debe tener al menos 3 caracteres");
            return;
        }

        if (password.isEmpty()) {
            lblMensaje.setText("La contraseña es obligatoria");
            return;
        }

        if (password.length() < 4) {
            lblMensaje.setText("La contraseña debe tener al menos 4 caracteres");
            return;
        }
        if (cmbRol.getValue() == null) {
            lblMensaje.setText("Seleccione un rol");
            return;
        }
        if (nombre.equals("admin") &&
                password.equals("1234") &&
                cmbRol.getValue().equals("Administrador")) {

            abrirVentanaAdministrador();

        } else {
            lblMensaje.setText("Datos incorrectas");
        }
    }
    private void abrirVentanaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Administrador.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menú Principal");
            stage.show();

            ((Stage) txtNombre.getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
