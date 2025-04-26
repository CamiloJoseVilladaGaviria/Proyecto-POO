package Negocio;

import Datos.AdministradorDAO;
import Entidades.Administrador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AdministradorControl {

    private final AdministradorDAO DATOS; // Manejo de operaciones con la base de datos
    private Administrador obj;  // Objeto temporal de tipo Administrador
    private DefaultTableModel modeloTabla; // Modelo de tabla para la interfaz gráfica
    public int registrosMostrados; // Contador de registros mostrados en la tabla

    // Constructor de la clase AdministradorControl
    public AdministradorControl() {
        this.DATOS = new AdministradorDAO();
        this.obj = new Administrador();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Administrador> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto)); // Llena la lista con los resultados de la consulta

        String[] titulos = {"Nombre", "Apellido", "Número de Identificación", "Email", "Rol", "Clave Ingreso", "Sueldo"}; // Encabezado de la tabla
        this.modeloTabla = new DefaultTableModel(null, titulos); // Inicializa el modelo de la tabla con los encabezados

        String[] registro = new String[7]; // Arreglo para almacenar los datos de cada fila
        this.registrosMostrados = 0; // Reinicia el contador de registros mostrados

        for (Administrador item : lista) {
            // Llena el arreglo `registro` con los valores de los atributos de `Administrador`
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

    public String insertar(String nombre, String apellido, String numIdentificacion, String email, String rol, String claveIngreso, double sueldo) {
        obj = new Administrador(nombre, apellido, numIdentificacion, email, rol, claveIngreso);
        obj.setSueldo(sueldo); // Establece el sueldo del administrador

        if (DATOS.insertar(obj)) {
            return "El administrador fue registrado correctamente.";
        } else {
            return "Error al registrar el administrador.";
        }
    }

    public String actualizar(String nombre, String apellido, String numIdentificacion, String email, String rol, double sueldo) {
        obj = new Administrador(nombre, apellido, numIdentificacion, email, rol, null);
        obj.setSueldo(sueldo); // Actualiza el sueldo del administrador

        if (DATOS.actualizar(obj)) {
            return "El administrador fue actualizado correctamente.";
        } else {
            return "Error al actualizar el administrador.";
        }
    }

    public String desactivar(String numIdentificacion) {
        if (DATOS.desactivar(numIdentificacion)) {
            return "El administrador fue desactivado correctamente.";
        } else {
            return "Error al desactivar el administrador.";
        }
    }

    public String activar(String numIdentificacion, String nuevoNumIdentificacion) {
        if (DATOS.activar(numIdentificacion, nuevoNumIdentificacion)) {
            return "El administrador fue activado correctamente.";
        } else {
            return "Error al activar el administrador.";
        }
    }

    public int total() {
        return DATOS.total(); // Retorna el total de registros
    }
}
