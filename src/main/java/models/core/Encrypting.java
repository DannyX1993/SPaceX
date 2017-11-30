package models.core;

import org.apache.logging.log4j.LogManager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class Encrypting {

    public static byte[] encrypt(EncryptingAlgorithm algorithm, String message) {
        byte[] digest = null;
        byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getName());
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException nsae) {
            LogManager.getLogger("Encrypting").error("Error: " + nsae);
        }
        return digest;
    }

    public static String stringEncrypt(EncryptingAlgorithm algorithm, String message) {
        byte[] digest = Encrypting.encrypt(algorithm, message);
        String hash = "";
        for (byte digito : digest) {
            int b = digito & 0xff; // 0..255
            if (b < 16) {
                hash += "0";
            } else
                hash += (Integer.toHexString(b));
        }
        return hash.toString();
    }

    public static String base64Encrypt(EncryptingAlgorithm algorithm, String message) {
        byte[] digest = Encrypting.encrypt(algorithm, message);
        return Base64.getEncoder().encodeToString(digest);
    }

    public static String base64UrlSafeEncrypt(EncryptingAlgorithm algorithm, String message) {
        byte[] digest = Encrypting.encrypt(algorithm, message);
        String code64Url = Base64.getUrlEncoder().encodeToString(digest);
        return code64Url.substring(0, code64Url.indexOf("="));
    }
}