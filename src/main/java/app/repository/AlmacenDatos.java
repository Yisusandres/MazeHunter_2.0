package app.repository;

import app.model.usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que define la estructura y el contrato para el almacenamiento
 * y recuperación de información persistente en la aplicación.
 * * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
 */
public abstract class AlmacenDatos{
    /**
     * Define el método para actualizar o guardar la lista completa de usuarios.
     * @author Jesus Sifontes
     * @param listaUsuarios Lista de objetos Usuario a persistir.
     */
    public void actualizarDatos(ArrayList<Usuario> listaUsuarios) {

    }

    /**
     * Define el método para recuperar la lista de usuarios desde el soporte físico.
     * @author Jesus Sifontes
     * @return ArrayList con los usuarios cargados.
     */
    public ArrayList<Usuario> cargarDatos() {
        return new ArrayList<>();
    }

    /**
     * Define el método para inicializar el almacén con usuarios por defecto.
     * @author Jesus Sifontes
     */
    public void nuevosUsuarios(){
        System.out.println("x");
    }
}
