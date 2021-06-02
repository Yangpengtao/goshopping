package com.oomall.lib_security.crypto;

import android.annotation.SuppressLint;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private SecretKey mKey;

    @SuppressLint("SecureRandom")
    public AES() {
        try {
            KeyGenerator keyGenerator = (KeyGenerator) KeyGenerator.getInstance("AES");

            //随机密码
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.setSeed(System.currentTimeMillis());


            //初始化密钥对象
            keyGenerator.init(128, secureRandom);
            //生成AES密钥
            mKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public AES(byte[] key){
        mKey=new SecretKeySpec(key,"AES");
    }

    public byte[] getmKey() {
        return mKey.getEncoded();
    }

    public void setmKey(byte[] key) {
        this.mKey = new SecretKeySpec(key,"AES");;
    }

    public byte[] encrypt(String content) {
        if (mKey == null) {
            return new byte[]{-1};
        }
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, mKey);
            return cipher.doFinal(content.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
            return new byte[]{-1};
        }
    }

    public String decrypt(byte[] content) {
        if (mKey == null) {
            return null;
        }

        try {
            @SuppressLint("GetInstance") Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, mKey);
            return new String(cipher.doFinal(content));
        } catch (NoSuchPaddingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        }
    }

}
