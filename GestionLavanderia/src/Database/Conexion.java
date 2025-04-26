package Database;

//importamos la clase connection para manejar conexiones a la base de datos
import java.sql.Connection;
//Importamos la clase  driver manager para gestionar la conexion
import java.sql.DriverManager;
//Importamos la clase SQLException para manejar errorses de sql
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    //Instanciamos nuestro driver
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //URL de conexion al servidor mysql en el puerto 3306(Puerto por defecto)
    private final String URL = "jdbc:mysql://localhost:3306/";
    //Nombre de la base de datos a la que nos conectamos
    private final String DB = "dbsistema";
    //Usuario por defecto para conectarse a la base de datos
    private final String USER = "root";
    //Contrasena usuario, en este caso vacia
    private final String PASSWORD = " ";

    //Creamos un objeto que almacene la conexion establecida a la base de datos}
    public Connection cadena;

    //Creamos instancia de la clase conexion para implementar el patron singleton
    public static Conexion instancia;

    //Constructor privado para evitar instanciacion externa, debe ser null
    private Conexion() {
        this.cadena = null;
    }

    //Metodo para establecer la conexion en la base de datos
    public Connection conectar() {
        try {
            //Cargar la clase del driver jdbc de mysql
            Class.forName(DRIVER);
            //Instancia para establecer la conexion combinando la url y el nombre de la base de datos
            //Y presentamos el usuario y contrasena
            this.cadena = DriverManager.getConnection(URL + DB + USER + PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            //si ocurre una excepcion (no se encuentra el driver o falla la conexion
            //se muestra un mensaje de error en un cuadro de dialogo y termina el programa
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }

    //Metodo para cerrar la conexion a la base de datos
    public void desconectar() {
        try {
            //Intentamos cerrar la conexion almacenada en cadena
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Metodo para obtener la instancia unica de la clase
    public synchronized static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
