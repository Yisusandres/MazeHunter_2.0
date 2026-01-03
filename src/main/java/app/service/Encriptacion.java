package app.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

/**
 * Herramienta para el cifrado de correo y contrasena
 * @author Darwin Marcano
 * @version 22.0.2
 * @since 15-11-2025
 */
public class Encriptacion {
    String LLAVE = "Hola";
    /**
     * Genera una clave AES de 128 bits a partir de una cadena aplicando SHA-1
     * y tomando los primeros 16 bytes.
     * @param llave Cadena de texto para derivar la clave
     * @return SecretKeySpec para AES o null si hay error
     */
    public SecretKeySpec crearClave(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            return new SecretKeySpec(cadena, "AES");
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Encripta el string con el algoritmo AES
     *
     * @param cadena_a_encriptar String que se encriptará
     * @return variable String encriptada
     */
    public String encriptar(String cadena_a_encriptar) {
        try {
            SecretKeySpec secretKeySpec = crearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encriptada = cipher.doFinal(cadena_a_encriptar.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encode(encriptada));
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Desencripta el String codificado en AES
     *
     * @param cadena_a_desencriptar String que será desencriptado
     * @return variable String desencriptada
     */

    public String desencriptar(String cadena_a_desencriptar) {
        try {
            SecretKeySpec secretKeySpec = crearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] desencriptada = cipher.doFinal(Base64.getDecoder().decode(cadena_a_desencriptar));
            return new String(desencriptada);
        } catch (Exception e) {
            return "";
        }
    }
}
