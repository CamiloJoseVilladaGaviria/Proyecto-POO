package Negocio;

import Entidades.Pedido;
import Entidades.Empleado;
import Entidades.Administrador;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Menu {

    static Empleado empleado = new Empleado("Ramon", "Valdez", "9876543210", "RamonValdez@outlook.com", "Empleado");
    static Administrador administrador = new Administrador("Carlos", "Villagran", "0123456789", "CarlosVillagran@outlook.com", "Administrador");
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    static String verificarNombreCliente;
    static String verificarApellidoCliente;
    static String verificarTelefonoCliente;
    static int verificarNumeroIdentificadorPedido;
    static String verificarNombrePedido;
    static String verificarDescripcionPedido;
    static double verificarCostoPedido;
    static int verificarDiaPedidoDejado, verificarMesPedidoDejado, verificarAnioPedidoDejado;

    public static void menu() {
        try {
            boolean flag = true;
            while (flag) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO AL MENU DEL EMPLEADO");
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                  1. PARA REGISTRAR UN PEDIDO 
                                                                  2. PARA ACTUALIZAR UN PEDIDO 
                                                                  3. PARA CONSULTAR UN PEDIDO
                                                                  4. PARA SALIR DEL PROGRAMA"""));

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "BIENVENIDO A REGISTRAR UN PEDIDO");
                        verificarNombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                        verificarApellidoCliente = JOptionPane.showInputDialog("Ingrese el apellido del cliente: ");
                        verificarTelefonoCliente = JOptionPane.showInputDialog("Ingrese el telefono del cliente: ");
                        verificarNumeroIdentificadorPedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero identificador para el pedido: "));
                        verificarNombrePedido = JOptionPane.showInputDialog("Ingrese el nombre del pedido: ");
                        verificarDescripcionPedido = JOptionPane.showInputDialog("Ingrese la descripcion del pedido: ");
                        verificarCostoPedido = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo del pedido: "));
                        verificarDiaPedidoDejado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia del pedido recibido: "));
                        verificarMesPedidoDejado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes del pedido recibido: "));
                        verificarAnioPedidoDejado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio del pedido recibido: "));
                        Pedido nuevoPedido = new Pedido(verificarNombreCliente, verificarApellidoCliente, verificarTelefonoCliente, verificarNumeroIdentificadorPedido, verificarNombrePedido, verificarDescripcionPedido, verificarCostoPedido, verificarDiaPedidoDejado, verificarMesPedidoDejado, verificarAnioPedidoDejado);
                        listaPedidos.add(nuevoPedido);
                        break;

                    case 2:
                        if (listaPedidos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Lista vacía");
                            break;
                        }

                        JOptionPane.showMessageDialog(null, "Bienvenido a actualizar un pedido");
                        int idActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de identificación del pedido a actualizar: "));

                        boolean encontrado = false;
                        for (Pedido pedido : listaPedidos) {
                            if (pedido.getNumeroIdentificadorPedido() == idActualizar) {
                                encontrado = true;
                                JOptionPane.showMessageDialog(null, pedido.mostrarInfoPedido());

                                int opcionModificar = Integer.parseInt(JOptionPane.showInputDialog("""
                        ¿Qué desea modificar?
                        1. Nombre del cliente
                        2. Apellido del cliente
                        3. Teléfono del cliente
                        4. Nombre del pedido
                        5. Descripción del pedido
                        6. Costo del pedido
                        7. Día recibido
                        8. Mes recibido
                        9. Año recibido
                        10. ID del pedido"""));

                                switch (opcionModificar) {
                                    case 1:
                                        pedido.setNombreCliente(JOptionPane.showInputDialog("Nuevo nombre del cliente:"));
                                        break;
                                    case 2:
                                        pedido.setApellidoCliente(JOptionPane.showInputDialog("Nuevo apellido del cliente:"));
                                        break;
                                    case 3:
                                        pedido.setTelefonoCliente(JOptionPane.showInputDialog("Nuevo teléfono del cliente:"));
                                        break;
                                    case 4:
                                        pedido.setNombrePedido(JOptionPane.showInputDialog("Nuevo nombre del pedido:"));
                                        break;
                                    case 5:
                                        pedido.setDescripcionPedido(JOptionPane.showInputDialog("Nueva descripción del pedido:"));
                                        break;
                                    case 6:
                                        pedido.setCostoPedido(Double.parseDouble(JOptionPane.showInputDialog("Nuevo costo del pedido:")));
                                        break;
                                    case 7:
                                        pedido.setDiaPedidoDejado(Integer.parseInt(JOptionPane.showInputDialog("Nuevo día del pedido:")));
                                        break;
                                    case 8:
                                        pedido.setMesPedidoDejado(Integer.parseInt(JOptionPane.showInputDialog("Nuevo mes del pedido:")));
                                        break;
                                    case 9:
                                        pedido.setAnioPedidoDejado(Integer.parseInt(JOptionPane.showInputDialog("Nuevo año del pedido:")));
                                        break;
                                    case 10:
                                        pedido.setNumeroIdentificadorPedido(Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID del pedido:")));
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opción inválida");
                                }

                                JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito.");
                                break;
                            }
                        }

                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "Pedido no encontrado");
                        }

                        break;

                    case 3:
                        if (listaPedidos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Lista vacia");
                        }
                        JOptionPane.showMessageDialog(null, "Bienvenido a consultar un pedido");
                        int numeroIdentificacionPedidoConsulta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion del pedido: "));
                        for (int i = 0; i < listaPedidos.size(); i++) {
                            Pedido pedido = listaPedidos.get(i);
                            boolean pedidoEncontrado;
                            if (pedido.getNumeroIdentificadorPedido() == numeroIdentificacionPedidoConsulta) {
                                pedidoEncontrado = true;
                                JOptionPane.showMessageDialog(null, pedido.mostrarInfoPedido());
                                break;
                            } else {
                                pedidoEncontrado = false;
                                JOptionPane.showMessageDialog(null, "Pedido no encontrado");
                                break;
                            }
                        }
                        break;

                    case 4:
                        flag = false;
                        JOptionPane.showMessageDialog(null, "HASTA LUEGO, VUELVA PRONTO");
                        break;

                    default:
                        throw new Error("ERROR");
                }
            }

        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            JOptionPane.showMessageDialog(null, "PROGRAMA EJECUTADO SATISFACTORIAMENTE");
        }
    }

    public static void menuGestor() {
        try {
            boolean flag = true;
            while (flag) {
                JOptionPane.showMessageDialog(null, "BIENEVENIDO AL MENU DEL ADMINISTRADOR");
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                          1. PARA IR A GESTOR DE PEDIDOS 
                                                                          2. PARA IR A GESTOR DE EMPLEADOS 
                                                                          3. PARA MOSTRAR LA INFORMACION DEL ADMINISTRADOR 
                                                                          4. PARA SALIR DEL PROGRAMA"""));

                switch (opcion) {
                    case 1:
                        if (listaPedidos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Bienvenido al gestor de pedidos");
                            for (Pedido pedido : listaPedidos) {
                                JOptionPane.showMessageDialog(null, pedido.mostrarInfoPedido());
                            }
                        }
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Bienvenido al gestor de empleados");
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Informacion del administrador");
                        infoAdministrador();
                        break;

                    case 4:
                        flag = false;
                        JOptionPane.showMessageDialog(null, "HASTA LUEGO, VUELVA PRONTO");
                        break;

                    default:
                        throw new Error("ERROR");
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            JOptionPane.showMessageDialog(null, "PROGRAMA EJECUTADO SATISFACTORIAMENTE");
        }
    }

    public static void infoAdministrador() {
        JOptionPane.showMessageDialog(null, administrador.mostrarInfoPersona());
    }

    public static void main(String[] args) {
        String bienvenida = JOptionPane.showInputDialog("BIENVENIDO, INGRESE SU ROL: ");
        if (bienvenida.equalsIgnoreCase(empleado.getRol())) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO SR@: " + empleado.getNombre() + " " + empleado.getApellido());
            menu();
        }

        if (bienvenida.equalsIgnoreCase(administrador.getRol())) {
            JOptionPane.showMessageDialog(null, "BIENVENIDO SR@: " + administrador.getNombre() + " " + administrador.getApellido());
            menuGestor();
        }
    }
}
