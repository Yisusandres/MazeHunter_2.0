package app.service;

import java.util.regex.Pattern;
/**
 * Clase para validar correo y contrasenas con expresiones regulares
 *
 * @author Jesus Sifontes
 * @version 22.0.2
 * @since 07-11-2025
 */
public class ValidarRegex {
    // Formato en expresiones regulares
    private static final String regexCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final String regexContrasena = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$";

    // Objeto Pattern que cumple con las condiciones de los formatos
    private static final Pattern patronCorreo = Pattern.compile(regexCorreo);
    private static final Pattern patronContrasena = Pattern.compile(regexContrasena);

    /**
     * Valida el correo ingresado por el usuario utilizando
     * expresiones regulares
     *
     * @param correo String ingresado por el usuario
     * @return Boolean resultante del match con el patrón en patronCorreo
     */
    public static boolean validarCorreo(String correo) {


        if (correo == null) {
            return false;
        }
        return patronCorreo.matcher(correo).matches();

    }

    /**
     * Valida la contrasena ingresada por el usuario utilizando
     * expresiones regulares
     *
     * @param contrasena string ingresado por el usuario
     * @return boolean resultante del match con el patrón en patronContrasena
     */
    public static boolean validarContrasena(String contrasena) {
        if (contrasena == null) {
            return false;
        }
        return patronContrasena.matcher(contrasena).matches();
    }

}
