package app.model.usuarios;

public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private GuardadoPartida guardadoPartida;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int bombasRecolectadas;
    private int trampasActivadas;
    private int cristalesObtenidos;
    private int laberintosJugados;

    // Nuevo usuario


    public Usuario(String nombreUsuario, String correo, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.laberintosJugados = 0;
        this.bombasRecolectadas = 0;
        this.cristalesObtenidos = 0;
        this.trampasActivadas = 0;
    }

    public Usuario(String nombreUsuario, int laberintosJugados, int cristalesObtenidos, int trampasActivadas, int bombasRecolectadas, int partidasPerdidas, int partidasGanadas, GuardadoPartida guardadoPartida, String contrasena, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.laberintosJugados = laberintosJugados;
        this.cristalesObtenidos = cristalesObtenidos;
        this.trampasActivadas = trampasActivadas;
        this.bombasRecolectadas = bombasRecolectadas;
        this.partidasPerdidas = partidasPerdidas;
        this.partidasGanadas = partidasGanadas;
        this.guardadoPartida = guardadoPartida;
        this.contrasena = contrasena;
        this.correo = correo;
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

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getBombasRecolectadas() {
        return bombasRecolectadas;
    }

    public void setBombasRecolectadas(int bombasRecolectadas) {
        this.bombasRecolectadas = bombasRecolectadas;
    }

    public int getTrampasActivadas() {
        return trampasActivadas;
    }

    public void setTrampasActivadas(int trampasActivadas) {
        this.trampasActivadas = trampasActivadas;
    }

    public int getCristalesObtenidos() {
        return cristalesObtenidos;
    }

    public void setCristalesObtenidos(int cristalesObtenidos) {
        this.cristalesObtenidos = cristalesObtenidos;
    }

    public int getLaberintosJugados() {
        return laberintosJugados;
    }

    public void setLaberintosJugados(int laberintosJugados) {
        this.laberintosJugados = laberintosJugados;
    }
}
