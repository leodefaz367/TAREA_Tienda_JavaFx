# MiTienda

## Descripción
MiTienda es un sistema de ventas desarrollado en JavaFX que permite el acceso mediante roles de usuario y la gestión de productos mediante operaciones CRUD 
(Crear, Leer, Actualizar y Eliminar).
## Dashboard
<img width="367" height="598" alt="image" src="https://github.com/user-attachments/assets/040251da-5179-4329-9ade-3c0fb168df28" />
<img width="1225" height="775" alt="image" src="https://github.com/user-attachments/assets/2d2a379a-3b15-462c-9ea0-e80310d06d42" />
## Tecnologías Utilizadas
Se utilizo estas herramientas, y es recomendable verificar que se compile en versiones 
de Java desde 21 en adelante puesto que el proyecto en versiones anteriores puede fallar: Java 21, JavaFX y CSS

## Funcionalidades Implementadas
Inicio de sesión con validaciones y selección de rol mediante ComboBox donde solo se maneja por el momento la pantalla del rol Administrador
se maneja un crud de registro, actualización, eliminación y limpieza de campos, todo esto visto desde una tabla, en la barra izquierda no estan activadas el resto de opciones
se manipulo la interfaz grafica mediante los fxml dando estilo con Css style y login.
## Estructura del Proyecto
MiTienda
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.mitienda
│   │   │       ├── AdministradorController.java
│   │   │       ├── HelloApplication.java
│   │   │       ├── HelloController.java
│   │   │       ├── Launcher.java
│   │   │       └── Producto.java
│   │   │
│   │   └── resources
│   │       └── com.example.mitienda
│   │       │    ├── Administrador.fxml
│   │       │    ├── hello-view.fxml
│   │       │    ├── login.css
│   │       │    ├── style.css
│   │       ├── images
│   │            └── imagen.png
│
├── pom.xml
└── README.md
## Ejecución

1. Descargar el zip del proyecto
2. Abrir el proyecto en IntelliJ IDEA
3. Descargar las dependencias de ser necesario y ejecutar la clase "HelloApplication.java"
4. Iniciar sesión con las credenciales configuradas en el sistema (usuario: admin; contraseña: 1234 & Rol: Administrador).
