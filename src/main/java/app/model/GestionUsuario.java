package app.model;

import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionUsuario {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public GestionUsuario() {
        listaUsuarios = new ArrayList<>();
    }
    public static Usuario usuarioActivo;

    public static void printUsuarios(){
        for (Usuario u: listaUsuarios) {
            System.out.println("Nombre: " + u.getNombreUsuario() + ", Correo: " + u.getCorreo());
        }
    }

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario usuarioActivo) {
        GestionUsuario.usuarioActivo = usuarioActivo;
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        GestionUsuario.listaUsuarios = listaUsuarios;
    }

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

    public static Usuario buscarUsuarioPorCorreo(String correo, ArrayList<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equals(correo)) {
                return u;
            }
        }
        return null;
    }

    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }


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

    public static void guardarEnJSON(){
        DatosJson datosJson = new DatosJson();
        datosJson.actualizarDatos(listaUsuarios);
    }
}
