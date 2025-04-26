package Entidades;

import Negocio.ServicioLavanderiaEmpleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Empleado implements ServicioLavanderiaEmpleado {

    private String nombre;
    private String apellido;
    private String numIdentificacion;
    private String email;
    private String rol;
    private String claveIngreso;
    private double sueldo;
    private ArrayList<Pedido> listaPedidos;

    public Empleado() {

    }

    public Empleado(String nombre, String apellido, String numIdentificacion, String email, String rol, String claveIngreso) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.numIdentificacion = numIdentificacion;
        this.email = email;
        this.rol = rol;
        this.claveIngreso = claveIngreso;
        this.listaPedidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
           Bienvenido a mostrar la informacion del empleado
           Nombre: """ + getNombre() + " ,\n"
                + "Apellido: " + getApellido() + " ,\n"
                + "Número de Identificación: " + getNumIdentificacion() + " ,\n"
                + "Email: " + getEmail() + " ,\n"
                + "Sueldo: " + getSueldo() + " ,\n"
                + "Rol: " + getRol();
    }

}
