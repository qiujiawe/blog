package pers.qjw.admin.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptionUtil {

    public final static BasicTextEncryptor basicTextEncryptor;

    static {
        basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("6D231C94EB34E2DDE2BCF6200B4863D7");
    }

    public static String encryption(String password) {
        return basicTextEncryptor.encrypt(password);
    }

    public static String decryption(String text) {
        return basicTextEncryptor.decrypt(text);
    }

}
