package Negocio;

import Datos.EmpleadoDAO;
import Entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EmpleadoControl {

    private final EmpleadoDAO DATOS; // Manejo de operaciones con la base de datos
    private Empleado obj;  // Objeto temporal de tipo Empleado
    private DefaultTableModel modeloTabla; // Modelo de tabla para la interfaz gráfica
    public int registrosMostrados; // Contador de registros mostrados en la tabla

    // Constructor de la clase EmpleadoControl
    public EmpleadoControl() {
        this.DATOS = new EmpleadoDAO();
        this.obj = new Empleado();
        this.registrosMostrados = 0;
    }

    // Método para listar empleados
    public DefaultTableModel listar(String texto) {
        List<Empleado> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto)); // Llena la lista con los resultados de la consulta

        String[] titulos = {"Nombre", "Apellido", "Número de Identificación", "Email", "Rol", "Clave Ingreso", "Sueldo"}; // Encabezado de la tabla
        this.modeloTabla = new DefaultTableModel(null, titulos); // Inicializa el modelo de la tabla con los encabezados

        String[] registro = new String[7]; // Arreglo para almacenar los datos de cada fila
        this.registrosMostrados = 0; // Reinicia el contador de registros mostrados

        for (Empleado item : lista) {
            // Llena el arreglo `registro` con los valores de los atributos de `Empleado`
            registro[0] = item.getNombre(); // Nombre
            registro[1] = item.getApellido(); // Apellido
            registro[2] = item.getNumIdentificacion(); // Número de Identificación
            registro[3] = item.getEmail(); // Email
            registro[4] = item.getRol(); // Rol
            registro[5] = item.getClaveIngreso(); // Clave Ingreso
            registro[6] = Double.toString(item.getSueldo()); // Sueldo

            // Añade la fila al modelo de la tabla
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++; // Incrementa el contador de registros mostrados
        }

        return this.modeloTabla;
    }

    // Método para insertar un nuevo empleado
    public String insertar(String nombre, String apellido, String numIdentificacion, String email, String rol, String claveIngreso, double sueldo) {
        obj = new Empleado(nombre, apellido, numIdentificacion, email, rol, claveIngreso);
        obj.setSueldo(sueldo); // Establece el sueldo del empleado

        if (DATOS.insertar(obj)) {
            return "El empleado fue registrado correctamente.";
        } else {
            return "Error al registrar el empleado.";
        }
    }

    // Método para actualizar un empleado existente
    public String actualizar(String nombre, String apellido, String numIdentificacion, String email, String rol, double sueldo) {
        obj = new Empleado(nombre, apellido, numIdentificacion, email, rol, null);
        obj.setSueldo(sueldo); // Actualiza el sueldo del empleado

        if (DATOS.actualizar(obj)) {
            return "El empleado fue actualizado correctamente.";
        } else {
            return "Error al actualizar el empleado.";
        }
    }

    // Método para desactivar un empleado
    public String desactivar(String numIdentificacion) {
        if (DATOS.desactivar(numIdentificacion)) {
            return "El empleado fue desactivado correctamente.";
        } else {
            return "Error al desactivar el empleado.";
        }
    }

    // Método para activar un empleado
    public String activar(String numIdentificacion, String nuevoNumIdentificacion) {
        if (DATOS.activar(numIdentificacion, nuevoNumIdentificacion)) {
            return "El empleado fue activado correctamente.";
        } else {
            return "Error al activar el empleado.";
        }
    }

    // Método para verificar si existe un empleado con un texto específico
    public boolean existe(String texto) {
        return DATOS.existe(texto);
    }

    // Método para contar el total de empleados registrados
    public int total() {
        return DATOS.total();
    }
}
