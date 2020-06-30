package edu.agic.itblog.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.*;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 0:08
 */
public class RsaUtil {
    private static final String ALGORITHM = "RSA";
    private static final String publicKeyPath = "src/main/resources/edu/agic/itblog/rsa/public.key";
    private static final String privateKeyPath = "src/main/resources/edu/agic/itblog/rsa/private.key";

    private static Key privateKey = null;
    private static Key publicKey = null;

    static {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(privateKeyPath));
            privateKey = (Key) (objectInputStream.readObject());
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(publicKeyPath));
            publicKey = (Key) (objectInputStream.readObject());
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypt_bytes = cipher.doFinal(input.getBytes());
        return new BASE64Encoder().encode(encrypt_bytes);
    }

    public static String decrypt(String input_encrypt) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = new BASE64Decoder().decodeBuffer(input_encrypt);
        byte[] decrypt_bytes = cipher.doFinal(bytes);
        return new String(decrypt_bytes);
    }

    private void generateRsaKey() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }

}
