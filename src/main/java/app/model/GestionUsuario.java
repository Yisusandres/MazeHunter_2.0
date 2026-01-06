package app.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionUsuario {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();
    public GestionUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    public static ArrayList<Usuario> cargarUsuarios(String direccionArchivo) {
        File archivoUsuarios = new File(direccionArchivo);
        if (!archivoUsuarios.exists() || archivoUsuarios.length() == 0) {
            System.out.println("El archivo de usuarios no existe o está vacío. Se ha creado una nueva lista de usuarios.");
            return new ArrayList<>();
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        ArrayList<Usuario> temp = new ArrayList<>();
        try {
            if (archivoUsuarios.exists() && archivoUsuarios.length() > 0) {
                temp = (ArrayList<Usuario>) mapper.readValue(archivoUsuarios, new TypeReference<List<Usuario>>() {});
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
            temp = null;
        }
        if (temp == null) {
            System.out.println("TEMP está vacía");;
        } else{
            System.out.println("Usuarios cargados de manera correcta");
        }
        return temp;
    }

    public static void printUsuarios(){
        for (Usuario u: listaUsuarios) {
            System.out.println("Nombre: " + u.getNombreUsuario() + ", Correo: " + u.getCorreo());
        }
    }

    public static void actualizarUsuarios(ArrayList<Usuario> listaP, String direccionArchivo) {
        File prueba = new File(direccionArchivo);
        try {
            mapper.writeValue(prueba, listaP);
        } catch (IOException e) {
            System.out.println("Error al actualizar usuarios: " + e.getMessage());
        }
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

}
