package com.example.mitienda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdministradorController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private ComboBox<String> cmbEstado;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<Producto,String> colCodigo;

    @FXML
    private TableColumn<Producto,String> colNombre;

    @FXML
    private TableColumn<Producto,String> colCategoria;

    @FXML
    private TableColumn<Producto,Double> colPrecio;

    @FXML
    private TableColumn<Producto,Integer> colStock;

    @FXML
    private TableColumn<Producto,String> colEstado;

    private final ObservableList<Producto> productos =
            FXCollections.observableArrayList();

    private Producto productoSeleccionado;

    @FXML
    public void initialize() {

        cmbCategoria.getItems().addAll(
                "Electrónica",
                "Ropa",
                "Alimentos",
                "Hogar"
        );

        cmbEstado.getItems().addAll(
                "Activo",
                "Inactivo"
        );

        colCodigo.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("codigo"));

        colNombre.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("nombre"));

        colCategoria.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("categoria"));

        colPrecio.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("precio"));

        colStock.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("stock"));

        colEstado.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("estado"));

        tblProductos.setItems(productos);

        tblProductos.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, viejo, nuevo) -> {

                    if (nuevo != null) {
                        productoSeleccionado = nuevo;

                        txtCodigo.setText(nuevo.getCodigo());
                        txtNombre.setText(nuevo.getNombre());
                        cmbCategoria.setValue(nuevo.getCategoria());
                        txtPrecio.setText(String.valueOf(nuevo.getPrecio()));
                        txtStock.setText(String.valueOf(nuevo.getStock()));
                        cmbEstado.setValue(nuevo.getEstado());
                    }
                });
    }

    @FXML
    private void nuevo() {
        limpiar();
    }

    @FXML
    private void guardar() {

        try {

            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();

            if(codigo.isEmpty() || nombre.isEmpty()){
                lblMensaje.setText("Complete todos los campos");
                return;
            }

            Producto p = new Producto(
                    codigo,
                    nombre,
                    cmbCategoria.getValue(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtStock.getText()),
                    cmbEstado.getValue()
            );

            productos.add(p);

            lblMensaje.setText("Producto guardado");
            limpiar();

        } catch (Exception e) {
            lblMensaje.setText("Datos inválidos");
        }
    }

    @FXML
    private void actualizar() {

        if(productoSeleccionado == null){
            lblMensaje.setText("Seleccione un producto");
            return;
        }

        try {

            productoSeleccionado.setCodigo(txtCodigo.getText());
            productoSeleccionado.setNombre(txtNombre.getText());
            productoSeleccionado.setCategoria(cmbCategoria.getValue());
            productoSeleccionado.setPrecio(
                    Double.parseDouble(txtPrecio.getText()));
            productoSeleccionado.setStock(
                    Integer.parseInt(txtStock.getText()));
            productoSeleccionado.setEstado(cmbEstado.getValue());

            tblProductos.refresh();

            lblMensaje.setText("Producto actualizado");

        } catch (Exception e) {
            lblMensaje.setText("Datos inválidos");
        }
    }

    @FXML
    private void eliminar() {

        if(productoSeleccionado == null){
            lblMensaje.setText("Seleccione un producto");
            return;
        }

        productos.remove(productoSeleccionado);

        limpiar();

        lblMensaje.setText("Producto eliminado");
    }

    @FXML
    private void limpiar() {

        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();

        cmbCategoria.setValue(null);
        cmbEstado.setValue(null);

        productoSeleccionado = null;
    }

    @FXML
    private void cerrarSesion() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("hello-view.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();

            Stage actual =
                    (Stage) txtCodigo.getScene().getWindow();

            actual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}