package Gestion;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Administrador extends PersonaAdministrador {

    private String claveIngreso;
    private double sueldo;
    private final ArrayList<Pedido> listaPedidos;
    private final ArrayList<Empleado> listaEmpleados;

    public Administrador(String nombre, String apellido, String numIdentificacion, String email, String rol) {
        super(nombre, apellido, numIdentificacion, email, rol);
        this.claveIngreso = claveIngreso;
        this.sueldo = sueldo;
        this.listaPedidos = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
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
    public void gestorPedido() {
        for (Pedido p : listaPedidos) {
            JOptionPane.showMessageDialog(null, p.mostrarInfoPedido());
        }
    }

    @Override
    public void gestorEmpleado() {
        for (Empleado e : listaEmpleados) {
            JOptionPane.showMessageDialog(null, e.mostrarInfoPersona());
        }
    }

    @Override
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
