package app.model.usuarios;

public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private GuardadoPartida guardadoPartida;
    private EstadisticasUsuario estadisticasUsuario;

    public Usuario(String nombreUsuario, String correo, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.guardadoPartida = null;
        this.estadisticasUsuario = new EstadisticasUsuario(0,0,0,0,0);
    }

    public Usuario(){
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public GuardadoPartida getGuardadoPartida() {
        return guardadoPartida;
    }

    public void setGuardadoPartida(GuardadoPartida guardadoPartida) {
        this.guardadoPartida = guardadoPartida;
    }

    public EstadisticasUsuario getEstadisticasUsuario() {
        return estadisticasUsuario;
    }

    public void setEstadisticasUsuario(EstadisticasUsuario estadisticasUsuario) {
        this.estadisticasUsuario = estadisticasUsuario;
    }
}
