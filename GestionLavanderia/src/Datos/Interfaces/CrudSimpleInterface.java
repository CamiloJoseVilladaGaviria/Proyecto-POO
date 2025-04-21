package Datos.Interfaces;

import java.util.List;

public interface CrudSimpleInterface<T> {

    //Metodo para listar elementos
    public List<T> listar(String texto);

    //Metodo para insertar un nuevo objeto
    public boolean insertar(T obj);

    //Metodo para actualizar un objeto existente
    public boolean actualizar(T obj);
    //Metodo para desactivar un objeto existente

    public boolean desactivar(String d);

    public boolean activar(String id, String nId);

    //Metodo para contar el total de elementos registrados
    public int total();

    //Metodo para verificar la existencia de un elemento
    public boolean existe(String texto);
}
