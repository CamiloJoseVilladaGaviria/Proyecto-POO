package Negocio;

import Datos.PedidoDAO;
import Entidades.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PedidoControl {

    private final PedidoDAO DATOS; //creamos el objeto que maneja las operaciones con la base de datos
    private Pedido obj;  //objeto de tipo categoria que se utiliza para manipular los datos temporalmente
    private DefaultTableModel modeloTabla; //modelo de tabla utilizado para mostrar datos de la interfaz grafica
    public int registrosMostrados; //variable que almacena el numero de registros que se muestran en la tabla

    //constructor de la clase PedidoControl
    public PedidoControl() {
        this.DATOS = new PedidoDAO();
        this.obj = new Pedido();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Pedido> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));//Llena la lista con los resultados de la consulta

        String[] titulos = {"Nombre Cliente", "Apellido Cliente", "Telefono Cliente", "Numero Identificador Pedido", "Nombre Pedido", "Descripcion Pedido", "Costo Pedido", "Dia Pedido Dejado", "Mes Pedido Dejado", "Anio Pedido Dejado"}; //encabezado de las columnas de la tabla
        this.modeloTabla = new DefaultTableModel(null, titulos); //se inicializa el modelo de la tabla con los encabezados

        String estado; //variable temporal para almacenar el estado de cada pedido
        String[] registro = new String[10];//creamos un arreglo de string para almacenar los datos de cada fila de la tabla
        this.registrosMostrados = 0;//se reinicia el contador de registros mostrados

        for (Pedido item : lista) {
            // Llenamos el arreglo `registro` con los valores de los atributos de `Pedido`
            registro[0] = item.getNombreCliente(); // Nombre Cliente
            registro[1] = item.getApellidoCliente(); // Apellido Cliente
            registro[2] = item.getTelefonoCliente(); // Teléfono Cliente
            registro[3] = Integer.toString(item.getNumeroIdentificadorPedido()); // Número Identificador Pedido
            registro[4] = item.getNombrePedido(); // Nombre Pedido
            registro[5] = item.getDescripcionPedido(); // Descripción Pedido
            registro[6] = Double.toString(item.getCostoPedido()); // Costo Pedido
            registro[7] = Integer.toString(item.getDiaPedidoDejado()); // Día Pedido Dejado
            registro[8] = Integer.toString(item.getMesPedidoDejado()); // Mes Pedido Dejado
            registro[9] = Integer.toString(item.getAnioPedidoDejado()); // Año Pedido Dejado

            // Añadimos la fila al modelo de la tabla
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++; // Incrementamos el contador de registros mostrados
            return this.modeloTabla;
        }

    
