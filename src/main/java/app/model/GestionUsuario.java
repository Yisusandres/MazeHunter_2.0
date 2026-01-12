package app.model;

import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import app.service.Encriptacion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la administración global de los usuarios en el sistema.
 * Proporciona métodos para la autenticación, búsqueda, registro y recuperación de credenciales.
 * * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
 */
public class GestionUsuario {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    /**
     * Constructor por defecto que inicializa la lista de usuarios.
     * @author Jesus Sifontes
     */
    public GestionUsuario() {
        listaUsuarios = new ArrayList<>();
    }


    /**
     * Imprime por consola el nombre y correo de todos los usuarios registrados.
     * @author Jesus Sifontes
     */
    public static void printUsuarios(){
        for (Usuario u: listaUsuarios) {
            System.out.println("Nombre: " + u.getNombreUsuario() + ", Correo: " + u.getCorreo());
        }
    }


    /**
     * Obtiene la lista completa de usuarios almacenados en memoria.
     * @author Jesus Sifontes
     * @return ArrayList con los objetos Usuario.
     */
    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }


    /**
     * Establece la lista de usuarios del sistema.
     * @author Jesus Sifontes
     * @param listaUsuarios Nueva lista de usuarios.
     */
    public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        GestionUsuario.listaUsuarios = listaUsuarios;
    }


    /**
     * Valida las credenciales de acceso de un usuario.
     * @author Jesus Sifontes
     * @param correo Correo electrónico a verificar.
     * @param contrasena Contraseña asociada.
     * @param listaUsuarios Lista donde se realizará la búsqueda.
     * @return String indicando el resultado del proceso ("Autenticación exitosa", "Contraseña incorrecta" o "Usuario no existe").
     */
    public static String autenticarCorreo(String correo, String contrasena, ArrayList<Usuario> listaUsuarios) {
        Usuario user = null;
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equals(correo)) {
                System.out.println("Usuario encontrado: " + u.getNombreUsuario());
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("El usuario no existe");
            return "Usuario no existe";
        } else if (contrasena.equals(user.getContrasena())) {
            System.out.println("Autenticación exitosa");
            return "Autenticación exitosa";
        } else{
            System.out.println("Contraseña incorrecta");
            return "Contraseña incorrecta";
        }
    }

    /**
     * Busca un usuario específico dentro de la lista utilizando su correo electrónico.
     * @author Jesus Sifontes
     * @param correo Correo del usuario buscado.
     * @param listaUsuarios Lista en la cual buscar.
     * @return El objeto Usuario si se encuentra, null en caso contrario.
     */
    public static Usuario buscarUsuarioPorCorreo(String correo, ArrayList<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equals(correo)) {
                return u;
            }
        }
        return null;
    }


    /**
     * Registra un nuevo usuario en la lista.
     * @author Jesus Sifontes
     * @param usuario Objeto Usuario a agregar.
     */
    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }


    /**
     * Recupera la contraseña de un usuario a partir de su correo electrónico.
     * @author Jesus Sifontes
     * @param correo Correo del usuario.
     * @param listaUsuarios Lista en la cual buscar.
     * @return La contraseña si el usuario existe, o un mensaje de error.
     */
    public static String recuperarContrasena(String correo, ArrayList<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equals(correo)) {
                System.out.println("Usuario encontrado: ");
                return u.getContrasena();
            }
        }
        System.out.println("El usuario no existe");
        return "Usuario no existe";
    }

    /**
     * Reemplaza la información de un usuario existente por una versión actualizada.
     * @author Jesus Sifontes
     * @param usuario Objeto Usuario con los datos nuevos (debe coincidir el correo).
     */
    public static void actualizarUsuario(Usuario usuario){
        for (Usuario user : listaUsuarios){
            if (user.getCorreo().equals(usuario.getCorreo())){
                listaUsuarios.remove(user);
                listaUsuarios.add(usuario);
                return;
            }
        }
    }
}
