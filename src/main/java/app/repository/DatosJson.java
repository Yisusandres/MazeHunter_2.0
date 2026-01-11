package app.repository;

import app.model.GestionUsuario;
import app.model.usuarios.Usuario;
import app.service.Encriptacion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatosJson extends AlmacenDatos{
    static ObjectMapper mapper = new ObjectMapper();
    static String direccionArchivo = "src/main/resources/JSON/usuarios.json";


    public ArrayList<Usuario> cargarDatos() {
        File archivoUsuarios = new File(direccionArchivo);

        Encriptacion desencriptador = new Encriptacion();

        if (!archivoUsuarios.exists() || archivoUsuarios.length() == 0) {
            System.out.println("El archivo de usuarios no existe o está vacío. Se ha creado una nueva lista de usuarios.");
            return new ArrayList<>();
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            if (archivoUsuarios.exists() && archivoUsuarios.length() > 0) {
                listaUsuarios = (ArrayList<Usuario>) mapper.readValue(archivoUsuarios, new TypeReference<List<Usuario>>() {});
                for(Usuario u : listaUsuarios) {
                    u.setCorreo(desencriptador.desencriptar(u.getCorreo()));
                    u.setContrasena(desencriptador.desencriptar(u.getContrasena()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
            listaUsuarios = null;
        }
        if (listaUsuarios == null) {
            System.out.println("TEMP está vacía");;
        } else{
            System.out.println("Usuarios cargados de manera correcta");
        }
        return listaUsuarios;
    }

    public void actualizarDatos(ArrayList<Usuario> listaUsuarios) {
        ArrayList<Usuario> usuariosNuevos;
        usuariosNuevos = listaUsuarios;
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File archivoUsuarios = new File(direccionArchivo);
        Encriptacion encriptacion = new Encriptacion();

        for (Usuario user : usuariosNuevos){
            user.setCorreo(encriptacion.encriptar(user.getCorreo()));
            user.setContrasena(encriptacion.encriptar(user.getContrasena()));
        }
        try {
            mapper.writeValue(archivoUsuarios, usuariosNuevos);
        } catch (IOException e) {
            System.out.println("Error al actualizar usuarios: " + e.getMessage());
        }
        for (Usuario user : usuariosNuevos){
            user.setCorreo(encriptacion.desencriptar(user.getCorreo()));
            user.setContrasena(encriptacion.desencriptar(user.getContrasena()));
        }
        GestionUsuario.setListaUsuarios(usuariosNuevos);
    }

    public void nuevosUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jesus", "jasifontes@gmail.com", "12345"));
        usuarios.add(new Usuario("Darwin", "dbmarcano@gmail.com", "54321"));
        GestionUsuario.setListaUsuarios(usuarios);
        actualizarDatos(GestionUsuario.getListaUsuarios());
        GestionUsuario.printUsuarios();

    }

}
