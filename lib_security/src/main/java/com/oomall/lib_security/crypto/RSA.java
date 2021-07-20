package com.oomall.lib_security.crypto;

import android.os.Build;


import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {

    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";

    //加密函数，传入明文，公钥；返回密文Base64
    public static String encrypt(int data, String key) {
        //由于DH参数均为int类型，这里设计成int加密
        String message = String.valueOf(data);
        //base64解密公钥
        byte[] decodedPubKey = DataUtils.base64Decode(key);
        byte[] result = new byte[]{0};
        try {
            RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
                    .generatePublic(new X509EncodedKeySpec(decodedPubKey));
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                result = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
            }
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return DataUtils.base64Encode(result);
    }


    //传入密文和密钥，返回明文
    public static String decypt(String encrypted, String key) {
        byte[] decodedKey = DataUtils.base64Decode(key);
        byte[] content = DataUtils.base64Decode(encrypted);

        byte[] result = new byte[]{0};

        try {
            RSAPrivateKey privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
                    .generatePrivate(new PKCS8EncodedKeySpec(decodedKey));
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            result = cipher.doFinal(content);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return new String(result);
    }
}
