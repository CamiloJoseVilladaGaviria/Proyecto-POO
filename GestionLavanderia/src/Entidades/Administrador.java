package Entidades;

import Negocio.ServicioLavanderiaAdministrador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Administrador implements ServicioLavanderiaAdministrador {

    private String nombre;
    private String apellido;
    private String numIdentificacion;
    private String email;
    private String rol;
    private String claveIngreso;
    private double sueldo;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Empleado> listaEmpleados;

    public Administrador() {

    }

    public Administrador(String nombre, String apellido, String numIdentificacion, String email, String rol, String claveIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numIdentificacion = numIdentificacion;
        this.email = email;
        this.rol = rol;
        this.claveIngreso = claveIngreso;
        this.listaPedidos = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
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

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
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
           Bienvenido a mostrar la informacion del empleado
           Nombre: """ + getNombre() + " ,\n"
                + "Apellido: " + getApellido() + " ,\n"
                + "Número de Identificación: " + getNumIdentificacion() + " ,\n"
                + "Email: " + getEmail() + " ,\n"
                + "Sueldo: " + getSueldo() + " ,\n"
                + "Rol: " + getRol();
    }
}
