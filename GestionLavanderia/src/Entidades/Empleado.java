package Entidades;

import Entidades.PersonaEmpleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Empleado extends PersonaEmpleado {

    private String claveIngreso;
    private double sueldo;
    private final ArrayList<Pedido> listaPedidos;

    public Empleado(String nombre, String apellido, String numIdentificacion, String email, String rol) {
        super(nombre, apellido, numIdentificacion, email, rol);
        this.claveIngreso = claveIngreso;
        this.sueldo = sueldo;
        this.listaPedidos = new ArrayList<>();
    }

    public String getClaveIngreso() {
        return claveIngreso;
    }

    public void setClaveIngreso(String claveIngreso) {
        this.claveIngreso = claveIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public void registrarPedido() {
        JOptionPane.showMessageDialog(null, "Registros de pedidos: ");
        for (Pedido p : listaPedidos) {
            JOptionPane.showMessageDialog(null, p);
        }
    }

    @Override
    public void actualizarPedido() {
        JOptionPane.showMessageDialog(null, "Actualizaciones de pedidos: ");
        for (Pedido p : listaPedidos) {
            JOptionPane.showMessageDialog(null, p);
        }
    }

    @Override
    public void consultarPedido() {
        JOptionPane.showMessageDialog(null, "Todos los pedidos: ");
        for (Pedido p : listaPedidos) {
            JOptionPane.showMessageDialog(null, p);
        }
    }

    public String mostrarInfoPersona() {
        return """
           Bienvenido a mostrar la informaci\u00f3n del empleado
           Nombre: """ + getNombre() + " ,\n"
                + "Apellido: " + getApellido() + " ,\n"
                + "Número de Identificación: " + getNumIdentificacion() + " ,\n"
                + "Email: " + getEmail() + " ,\n"
                + "Sueldo: " + getSueldo() + " ,\n"
                + "Rol: " + getRol();
    }

}
