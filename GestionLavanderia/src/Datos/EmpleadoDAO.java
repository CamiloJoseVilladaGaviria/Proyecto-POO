package Datos;

import Database.Conexion;
import java.sql.PreparedStatement; //Importar la clase PreparedStatement, nos permite ejecutar consultas SQL con 
import java.sql.ResultSet; //Importamos la clase ResultSet para manejar los resultados de las consultas SQL
import java.sql.SQLException; //Para manejar excepciones relacionadas con SQL
import Datos.Interfaces.CrudSimpleInterface;
import Entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoDAO implements CrudSimpleInterface<Empleado> {

    private final Conexion CON; //Atributo que mantiene la conexión a la base de datos 
    private PreparedStatement ps; //Objeto que se utiliza para preparar y ejecutar sentencias SQL
    private ResultSet rs; //Objeto que almacena los resultados de las consultas SQL
    private boolean resp; //Variable que almacena si una operacion fue existosa o no

    public EmpleadoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Empleado> listar(String texto) {

        List<Empleado> registro = new ArrayList<>();
        try {
            //Preparar la consulta SQL con un parámetro de búsqueda
            ps = CON.conectar().prepareStatement("SELECT * FROM empleado WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "&"); //Asignamos el parámetro de búsqueda (comodín) a la consulta

            rs = ps.executeQuery();

            //Iteramos sobre los resultados y los agrega a la lista
            while (rs.next()) {
                registro.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }
            ps.close(); //Cerrar la consulta SQL
            rs.close(); //Cerrar el conjunto de resultados
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registro;
    }

    @Override
    public boolean insertar(Empleado obj) {

        resp = false; //Inicializar la respuesta en false (operacion fallida por defecto)
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO empleado (nombre, apellido, numIdentificacion, email, rol) VALUES = (?, ?, ?, ? ,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getNumIdentificacion());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getRol());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

        }
        return resp;
    }

    @Override
    public boolean actualizar(Empleado obj) {
        boolean resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE empleado SET nombre =?, apellido =?, email =?, rol =? WHERE numIdentificacion=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getRol());
            ps.setString(5, obj.getNumIdentificacion());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }

        return resp;
    }

    @Override
    public boolean desactivar(String numIdentificacion) {
        boolean resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE empleado SET numIdentificacion = NULL WHERE numIdentificacion=?");
            ps.setString(1, numIdentificacion);

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;

    }

    @Override
    public boolean activar(String numIdentificacion, String nuevoNumIdentificacion) {
        boolean resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE empleado SET numIdentificacion = ? WHERE numIdentificacion IS NULL");
            ps.setString(1, nuevoNumIdentificacion);

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistro = 0;

        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(*) FROM empleado"); // Corrección de la consulta
            rs = ps.executeQuery();

            if (rs.next()) {
                totalRegistro = rs.getInt(1);
            }

            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }

        return totalRegistro;
    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("SELECT nombre FROM empleado WHERE nombre =? ");
            ps.setString(1, texto);
            rs = ps.executeQuery();

            if (rs.next()) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }

        return resp;
    }

}
