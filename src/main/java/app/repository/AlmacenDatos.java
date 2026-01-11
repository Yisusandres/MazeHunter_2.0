package app.repository;

import app.model.usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

public abstract class AlmacenDatos{
    public void actualizarDatos(ArrayList<Usuario> listaUsuarios) {

    }

    public ArrayList<Usuario> cargarDatos() {
        return new ArrayList<>();
    }

    public void nuevosUsuarios(){
        System.out.println("x");
    }
}
