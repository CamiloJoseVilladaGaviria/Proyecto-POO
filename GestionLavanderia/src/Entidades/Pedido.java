package Entidades;

import javax.swing.JOptionPane;

public class Pedido {

    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
    private int numeroIdentificadorPedido;
    private String nombrePedido;
    private String descripcionPedido;
    private double costoPedido;
    private int diaPedidoDejado, mesPedidoDejado, anioPedidoDejado;

    public Pedido(String nombreCliente, String apellidoCliente, String telefonoCliente, int numeroIdentificadorPedido, String nombrePedido, String descripcionPedido, double costoPedido, int diaPedidoDejado, int mesPedidoDejado, int anioPedidoDejado) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.numeroIdentificadorPedido = numeroIdentificadorPedido;
        this.nombrePedido = nombrePedido;
        this.descripcionPedido = descripcionPedido;
        this.costoPedido = costoPedido;
        this.diaPedidoDejado = diaPedidoDejado;
        this.mesPedidoDejado = mesPedidoDejado;
        this.anioPedidoDejado = anioPedidoDejado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public int getNumeroIdentificadorPedido() {
        return numeroIdentificadorPedido;
    }

    public void setNumeroIdentificadorPedido(int numeroIdentificadorPedido) {
        this.numeroIdentificadorPedido = numeroIdentificadorPedido;
    }

    public String getNombrePedido() {
        return nombrePedido;
    }

    public void setNombrePedido(String nombrePedido) {
        this.nombrePedido = nombrePedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public double getCostoPedido() {
        return costoPedido;
    }

    public void setCostoPedido(double costoPedido) {
        this.costoPedido = costoPedido;
    }

    public int getDiaPedidoDejado() {
        return diaPedidoDejado;
    }

    public void setDiaPedidoDejado(int diaPedidoDejado) {
        this.diaPedidoDejado = diaPedidoDejado;
    }

    public int getMesPedidoDejado() {
        return mesPedidoDejado;
    }

    public void setMesPedidoDejado(int mesPedidoDejado) {
        this.mesPedidoDejado = mesPedidoDejado;
    }

    public int getAnioPedidoDejado() {
        return anioPedidoDejado;
    }

    public void setAnioPedidoDejado(int anioPedidoDejado) {
        this.anioPedidoDejado = anioPedidoDejado;
    }

    public String mostrarInfoPedido() {
        String info = "NOMBRE CLIENTE: " + nombreCliente + ", \n"
                + "APELLIDO CLIENTE: " + apellidoCliente + ", \n"
                + "TELEFONO CLIENTE: " + telefonoCliente + ", \n"
                + "ID PEDIDO: " + numeroIdentificadorPedido + "\n"
                + "NOMBRE PEDIDO: " + nombrePedido + "\n"
                + "DESCRIPCION PEDIDO: " + descripcionPedido + "\n"
                + "COSTO PEDIDO: " + costoPedido + "\n"
                + "DIA PEDIDO DEJADO: " + diaPedidoDejado + "\n"
                + "MES PEDIDO DEJADO: " + mesPedidoDejado + "\n"
                + "AÑO PEDIDO DEJADO: " + anioPedidoDejado;

        JOptionPane.showMessageDialog(null, "Informacion del pedido:\n\n" + info);

        return info;
    }

}
