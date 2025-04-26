package Datos;

import Database.Conexion;
import java.sql.PreparedStatement; //Importar la clase PreparedStatement, nos permite ejecutar consultas SQL con 
import java.sql.ResultSet; //Importamos la clase ResultSet para manejar los resultados de las consultas SQL
import java.sql.SQLException; //Para manejar excepciones relacionadas con SQL
import Datos.Interfaces.CrudSimpleInterface;

import Entidades.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDAO {

    public class AdministradorDAO implements CrudSimpleInterface<Pedido> {

        private final Conexion CON; //Atributo que mantiene la conexión a la base de datos 
        private PreparedStatement ps; //Objeto que se utiliza para preparar y ejecutar sentencias SQL
        private ResultSet rs; //Objeto que almacena los resultados de las consultas SQL
        private boolean resp; //Variable que almacena si una opeeracion fue existosa o no

        public AdministradorDAO() {
            CON = Conexion.getInstancia();
        }

        @Override
        public List<Pedido> listar(String texto) {
            List<Pedido> registro = new ArrayList<>();
            try {
                //Preparar la consulta SQL con un parámetro de búsqueda
                ps = CON.conectar().prepareStatement("SELECT * FROM pedido WHERE nombre LIKE ?");
                ps.setString(1, "%" + texto + "&"); //Asignamos el parámetro de búsqueda (comodín) a la consulta

                rs = ps.executeQuery();

                //Iteramos sobre los resultados y los agrega a la lista
                while (rs.next()) {
                    registro.add(new Pedido(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));

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
        public boolean insertar(Pedido obj) {
            resp = false; //Inicializar la respuesta en false (operacion fallida por defecto)
            try {
                ps = CON.conectar().prepareStatement("INSERT INTO pedido (nombreCliente, apellidoCliente, telefonoCliente, numeroIdentificadorPedido, nombrePedido, descripcionPedido, costoPedido, diaPedidoDejado, mesPedidoDejado, anioPedidoDejado) VALUES = (?, ?, ?, ? , ?, ?, ?, ?, ?, ?)");
                ps.setString(1, obj.getNombreCliente());
                ps.setString(2, obj.getApellidoCliente());
                ps.setString(3, obj.getTelefonoCliente());
                ps.setInt(4, obj.getNumeroIdentificadorPedido());
                ps.setString(5, obj.getNombrePedido());
                ps.setString(6, obj.getDescripcionPedido());
                ps.setDouble(7, obj.getCostoPedido());
                ps.setInt(8, obj.getDiaPedidoDejado());
                ps.setInt(9, obj.getMesPedidoDejado());
                ps.setInt(10, obj.getAnioPedidoDejado());
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
        public boolean actualizar(Pedido obj) {
            boolean resp = false;

            try {
                ps = CON.conectar().prepareStatement("UPDATE pedido SET nombreCliente =?, apellidoCliente =?, telefonoCliente =?, numeroIdentificadorPedido =?, nombrePedido =?, descripcionPedido =?, costoPedido =?, diaPedidoDejado =?, mesPedidoDejado =?, WHERE anioPedidoDejado =?");
                ps.setString(1, obj.getNombreCliente());
                ps.setString(2, obj.getApellidoCliente());
                ps.setString(3, obj.getTelefonoCliente());
                ps.setInt(4, obj.getNumeroIdentificadorPedido());
                ps.setString(5, obj.getNombrePedido());
                ps.setString(6, obj.getDescripcionPedido());
                ps.setDouble(7, obj.getCostoPedido());
                ps.setInt(8, obj.getDiaPedidoDejado());
                ps.setInt(9, obj.getMesPedidoDejado());
                ps.setInt(10, obj.getAnioPedidoDejado());

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

        public boolean desactivar(String numeroIdentificadorPedido) {
            boolean resp = false;

            try {
                // Preparar la consulta SQL con múltiples columnas
                ps = CON.conectar().prepareStatement(
                        "UPDATE pedidos SET "
                        + "nombreCliente = NULL, "
                        + "apellidoCliente = NULL, "
                        + "telefonoCliente = NULL, "
                        + "numeroIdentificadorPedido = NULL, "
                        + "nombrePedido = NULL, "
                        + "descripcionPedido = NULL, "
                        + "costoPedido = NULL, "
                        + "diaPedidoDejado = NULL, "
                        + "mesPedidoDejado = NULL, "
                        + "anioPedidoDejado = NULL "
                        + "WHERE numeroIdentificadorPedido = ?"
                );
                ps.setString(1, numeroIdentificadorPedido);

                // Ejecutar la consulta
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

        public boolean activar(String numeroIdentificadorPedido, String nuevoNumeroIdentificadorPedido) {
            boolean resp = false;

            try {
                // Preparar la consulta SQL para activar los atributos
                ps = CON.conectar().prepareStatement(
                        "UPDATE pedidos SET "
                        + "nombreCliente = ?, "
                        + "apellidoCliente = ?, "
                        + "telefonoCliente = ?, "
                        + "numeroIdentificadorPedido = ?, "
                        + "nombrePedido = ?, "
                        + "descripcionPedido = ?, "
                        + "costoPedido = ?, "
                        + "diaPedidoDejado = ?, "
                        + "mesPedidoDejado = ?, "
                        + "anioPedidoDejado = ? "
                        + "WHERE numeroIdentificadorPedido IS NULL"
                );

                // Asignar valores a los parámetros
                ps.setString(1, "nuevoNombreCliente"); // Aquí puedes personalizar el valor
                ps.setString(2, "nuevoApellidoCliente");
                ps.setString(3, "nuevoTelefonoCliente");
                ps.setString(4, nuevoNumeroIdentificadorPedido);
                ps.setString(5, "nuevoNombrePedido");
                ps.setString(6, "nuevaDescripcionPedido");
                ps.setDouble(7, 0.0); // Ejemplo para costoPedido
                ps.setInt(8, 1); // día (puedes reemplazar por el valor deseado)
                ps.setInt(9, 1); // mes
                ps.setInt(10, 2025); // año (o cualquier otro valor deseado)

                // Ejecutar la consulta
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
                ps = CON.conectar().prepareStatement("SELECT COUNT(*) FROM pedido"); // Corrección de la consulta
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
            boolean resp = false;

            try {
                // Preparar la consulta SQL para verificar si existe un registro con el texto especificado
                ps = CON.conectar().prepareStatement(
                        "SELECT nombreCliente, apellidoCliente, telefonoCliente, numeroIdentificadorPedido, "
                        + "nombrePedido, descripcionPedido, costoPedido, diaPedidoDejado, mesPedidoDejado, anioPedidoDejado "
                        + "FROM pedidos WHERE nombreCliente = ? OR apellidoCliente = ? OR telefonoCliente = ? OR "
                        + "numeroIdentificadorPedido = ? OR nombrePedido = ? OR descripcionPedido = ?"
                );

                // Establecer el mismo texto como parámetro para todas las columnas relevantes
                ps.setString(1, texto);
                ps.setString(2, texto);
                ps.setString(3, texto);
                ps.setString(4, texto);
                ps.setString(5, texto);
                ps.setString(6, texto);

                // Ejecutar la consulta y verificar si se encontraron resultados
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
}
