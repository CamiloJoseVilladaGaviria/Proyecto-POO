package Datos;

import Database.Conexion;
import java.sql.PreparedStatement; //Importar la clase PreparedStatement, nos permite ejecutar consultas SQL con 
import java.sql.ResultSet; //Importamos la clase ResultSet para manejar los resultados de las consultas SQL
import java.sql.SQLException; //Para manejar excepciones relacionadas con SQL
import Datos.Interfaces.CrudSimpleInterface;
import Entidades.Administrador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AdministradorDAO implements CrudSimpleInterface<Administrador> {

    private final Conexion CON; //Atributo que mantiene la conexión a la base de datos 
    private PreparedStatement ps; //Objeto que se utiliza para preparar y ejecutar sentencias SQL
    private ResultSet rs; //Objeto que almacena los resultados de las consultas SQL
    private boolean resp; //Variable que almacena si una opeeracion fue existosa o no

    public AdministradorDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Administrador> listar(String texto) {
        List<Administrador> registro = new ArrayList<>();
        try {
            //Preparar la consulta SQL con un parámetro de búsqueda
            ps = CON.conectar().prepareStatement("SELECT * FROM administrador WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "&"); //Asignamos el parámetro de búsqueda (comodín) a la consulta

            rs = ps.executeQuery();

            //Iteramos sobre los resultados y los agrega a la lista
            while (rs.next()) {
                registro.add(new Administrador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

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
    public boolean insertar(Administrador obj) {
        resp = false; //Inicializar la respuesta en false (operacion fallida por defecto)
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO administrador (nombre, apellido, numIdentificacion, email, rol) VALUES = (?, ?, ?, ? ,?)");
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
    public boolean actualizar(Administrador obj) {
        boolean resp = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE administrador SET nombre =?, apellido =?, email =?, rol =? WHERE numIdentificacion=?");
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
            ps = CON.conectar().prepareStatement("UPDATE administrador SET numIdentificacion = NULL WHERE numIdentificacion=?");
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
            ps = CON.conectar().prepareStatement("UPDATE administrador SET numIdentificacion = ? WHERE numIdentificacion IS NULL");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(*) FROM administrador"); // Corrección de la consulta
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
            ps = CON.conectar().prepareStatement("SELECT nombre FROM administrador WHERE nombre =? ");
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
