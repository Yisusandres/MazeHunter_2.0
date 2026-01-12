package app.model.usuarios;

/**
 * Clase que representa el perfil de un usuario.
 * Contiene información de autenticación, estadísticas acumuladas
 * y la referencia a su partida guardada.
 * * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
 */
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


    /**
     * Constructor para la creación de un nuevo usuario con valores iniciales en cero.
     * @author Jesus Sifontes
     * @param nombreUsuario Nombre elegido por el usuario.
     * @param correo Dirección de correo electrónico (identificador único).
     * @param contrasena Clave de acceso.
     */
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

    /**
     * Constructor detallado para cargar un perfil completo con todas sus estadísticas desde el JSON.
     * @author Jesus Sifontes
     * @param nombreUsuario Nombre de perfil.
     * @param laberintosJugados Total de laberintos iniciados.
     * @param cristalesObtenidos Total histórico de cristales.
     * @param trampasActivadas Número de veces que ha caído en trampas.
     * @param bombasRecolectadas Total de bombas obtenidas.
     * @param partidasPerdidas Contador de derrotas.
     * @param partidasGanadas Contador de victorias.
     * @param guardadoPartida Objeto con el estado de la partida actual.
     * @param contrasena Clave de acceso.
     * @param correo Correo electrónico.
     */
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

    /**
     * Obtiene el nombre del usuario.
     * @author Jesus Sifontes
     * @return String con el nombre.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
     * @author Jesus Sifontes
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la clave del usuario.
     * @author Jesus Sifontes
     * @return String con la clave.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la clave del usuario.
     * @author Jesus Sifontes
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el correo del usuario.
     * @author Jesus Sifontes
     * @return String con el correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del usuario.
     * @author Jesus Sifontes
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Recupera el objeto de guardado de partida asociado al usuario.
     * @author Jesus Sifontes
     * @return Objeto GuardadoPartida.
     */
    public GuardadoPartida getGuardadoPartida() {
        return guardadoPartida;
    }

    /**
     * Establece la ultima partida guardada por el usuario
     * @author Jesus Sifontes
     * @return String con el nombre.
     */
    public void setGuardadoPartida(GuardadoPartida guardadoPartida) {
        this.guardadoPartida = guardadoPartida;
    }

    /**
     * Obtiene las partidas ganadas por el usuario.
     * @author Jesus Sifontes
     * @return int con el numero.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Establece el numero de partidas ganadas del usuario.
     * @author Jesus Sifontes
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Obtiene las partidas perdidas por el usuario.
     * @author Jesus Sifontes
     * @return int con el numero.
     */
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    /**
     * Establece el numero de partidas perdidas del usuario.
     * @author Jesus Sifontes
     */
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    /**
     * Obtiene el numero de bombas recolectadas del usuario.
     * @author Jesus Sifontes
     * @return int con el numero.
     */
    public int getBombasRecolectadas() {
        return bombasRecolectadas;
    }

    /**
     * Establece el numero de bombas recolectadas del usuario.
     * @author Jesus Sifontes
     */
    public void setBombasRecolectadas(int bombasRecolectadas) {
        this.bombasRecolectadas = bombasRecolectadas;
    }

    /**
     * Obtiene el numero de trampas activadas del usuario.
     * @author Jesus Sifontes
     * @return int con el numero.
     */
    public int getTrampasActivadas() {
        return trampasActivadas;
    }

    /**
     * Establece el numero de trampas activadas del usuario.
     * @author Jesus Sifontes
     */
    public void setTrampasActivadas(int trampasActivadas) {
        this.trampasActivadas = trampasActivadas;
    }

    /**
     * Obtiene el total de cristales recolectados a lo largo del tiempo.
     * @author Jesus Sifontes
     * @return Cantidad de cristales.
     */
    public int getCristalesObtenidos() {
        return cristalesObtenidos;
    }

    /**
     * Establece el numero de cristales obtenidos del usuario.
     * @author Jesus Sifontes
     */
    public void setCristalesObtenidos(int cristalesObtenidos) {
        this.cristalesObtenidos = cristalesObtenidos;
    }

    /**
     * Obtiene el numero de laberintos jugados del usuario.
     * @author Jesus Sifontes
     * @return int con el numero.
     */
    public int getLaberintosJugados() {
        return laberintosJugados;
    }

    /**
     * Asigna el numero de laberintos jugados del usuario.
     * @author Jesus Sifontes
     * @return int con el numero.
     */
    public void setLaberintosJugados(int laberintosJugados) {
        this.laberintosJugados = laberintosJugados;
    }
}
