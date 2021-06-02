package com.oomall.lib_security.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class DH {
    private static final int dhP = 23;
    private static final int dhG = 5;


    private int mPriKey;

    //在构造器中初始化好需要的参数
    public DH() {
        Random r = new Random();
        mPriKey = r.nextInt(10);
        System.out.println("dh priKey is:" + mPriKey);
    }

    public int getPublicKey() {
        //使用公钥计算公式，计算出自己的公钥，用以交换
        return (int) (Math.pow(dhG, mPriKey) % dhP);
    }


    public byte[] getSecretKey(byte[] publicKey) {
        int key =DataUtils.byte2Int(publicKey);
        //使用密钥计算公式，计算出自己的密钥，用以交换
        return sha256((int) (Math.pow(key, mPriKey) % dhP));
    }
    public byte[] getSecretKey(int publicKey) {
        //使用密钥计算公式，计算出自己的密钥，用以交换
        return sha256((int) (Math.pow(publicKey, mPriKey) % dhP));
    }

    //将DH交换相同密钥（int)做hash转换
    //目的是转换成byte[128]类型，用作AES密钥
    private byte[] sha256(int data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(DataUtils.int2Byte(data));
            System.out.println("data is:" + data + "-----byte array is:" + Arrays.toString(DataUtils.int2Byte(data)));
            return messageDigest.digest();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[]{-1};
        }
    }

}
