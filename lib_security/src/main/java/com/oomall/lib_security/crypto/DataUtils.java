package com.oomall.lib_security.crypto;

import android.os.Build;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class DataUtils {

    //传入Base64编码后的字符串，返回解码后的byte[]
    @RequiresApi(api = Build.VERSION_CODES.O)
    static byte[] base64Decode(String data) {
        //java中的base64不好用 ，Android的简单易用
        //有限使用Android，找不到Android的 使用java的
        try {
            //安卓的
            return Base64.decode(data, Base64.NO_WRAP);
        } catch (Exception e) {
            //java的
            return java.util.Base64.getMimeDecoder().decode(data);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static String base64Encode(byte[] data) {
        try {
            return Base64.encodeToString(data, Base64.NO_WRAP);
        } catch (Exception e) {
            return java.util.Base64.getEncoder().encodeToString(data);
        }
    }

    //将int转换为byte数组，一个int对应4个byte
    public static byte[] int2Byte(int data) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.putInt(data);
        return byteBuffer.array();
    }

    //将byte转换为int数组，一个int对应4个byte
    public static int byte2Int(byte[] data) {
        System.out.println("-----byte2Int is :"+ Arrays.toString(data));
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        return byteBuffer.getInt();
    }
}
