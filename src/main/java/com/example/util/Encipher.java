package com.example.util;

import javax.crypto.spec.IvParameterSpec;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Arrays;


public final class Encipher {
    private static final int KEY_LENGTH = 128;
    private static final String SEED = "manchesterunited";

    private Encipher() {
    }

    public static String decryptPwd(String pwdStr) {
        return AEScipher.decryptAES(pwdStr, AEScipher.generateAESKey(KEY_LENGTH, SEED));
    }

    public static String encryptPwd(String pwdStr) {
        return AEScipher.encryptAES(pwdStr, AEScipher.generateAESKey(KEY_LENGTH, SEED));
    }


    public static String decrypt(String encryptionText) {
       byte[] randomIV = Arrays.copyOf(TranscodeUtil.base64StrToByteArray(encryptionText), 16);
       String encryptionRealText = encryptionText.substring(TranscodeUtil.byteArrayToBase64Str(randomIV).length());
       return AEScipher.decryptAES(encryptionRealText, AEScipher.generateAESKey(KEY_LENGTH, SEED),new IvParameterSpec(randomIV, 0, AEScipher.AES_IV_LENGTH));
    }



    public static String encrypt(String plaintText) {
        byte[] randomIV = AEScipher.genereteRandomIV();
        return TranscodeUtil.byteArrayToBase64Str(randomIV) +  AEScipher.encryptAES(plaintText, AEScipher.generateAESKey(KEY_LENGTH, SEED),new IvParameterSpec(randomIV, 0, AEScipher.AES_IV_LENGTH));
    }


    public static void main(String[] args) throws Exception {
        PrintStream out = System.out; // make sonar comfortable
        if (args.length != 2) {
            printUsage(out);
            System.out.println(encryptPwd("docker"));
            System.out.println(decrypt("rAy7jqr5DfmjE8OTcAdfNA==p5EXq/DoU54EkVy1lmi2kg=="));
            System.exit(1);
        }
			String methodName = args[0];
			Method m = Encipher.class.getMethod(methodName, String.class);
			out.println(m.invoke(null,args[1]));
    }

    public static void printUsage(PrintStream out) {
        out.println("*******************Usage:Encipher $1 $2********************");
        out.println("***$1:optional:  the value should be one of the encrypt or decrypt or decryptPwd or encryptPwd");
        out.println("***$2:mandatory: password for encryption");
        out.println("***********************************************************");
    }
}