package org.fxapplications;

import javafx.scene.control.TextArea;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SystemInfo {
    //todo: passwort konsole mit boxblur -> je öfter mans versucht desto eher sieht man das passwort
    //todo Idee: always on top knopf!

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }



    //dump:
    static TextArea ergebnistext = new TextArea();

    /**
     * Using Blowfish, Params are Strings, still doesnt work
     *
     * @param type 0==, 1==versch, 2 = entsch
     * @return String
     * Passwort kann gewählt werden
     * Geburtsort ist immer gleich
     */
    public static String buttonhandler2(String ttext1,String ttextfeld1,String ttextfeld2,int type) throws Exception {
        String geburtpluspasswort = ttextfeld1 + ttextfeld2;
        System.out.println(geburtpluspasswort);
        //verschlüsseln
        if (type == 1) {
            ergebnistext.setText(encryptBlowfish(ttext1,geburtpluspasswort));

            System.out.println(encryptBlowfish(ttext1,geburtpluspasswort));
        }
        //entschlüsseln
        if (type == 2) {
            ergebnistext.setText(decryptBlowfish(ttext1,geburtpluspasswort));
            System.out.println(decryptBlowfish(ttext1,geburtpluspasswort));
        }

        return null;
    }

    //todo Blowfish
    public static String encryptBlowfish(String strClearText,String strKey) throws Exception {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(StandardCharsets.UTF_8),"Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,skeyspec);
//            byte[] encrypted=Base64.getDecoder().decode(strClearText);
            byte[] encrypted = cipher.doFinal(strClearText.getBytes(StandardCharsets.UTF_8));

            strData = new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }


    public static String decryptBlowfish(String strEncrypted,String strKey) throws Exception {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(StandardCharsets.UTF_8),"Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,skeyspec);
            byte[] decrypted = cipher.doFinal(strEncrypted.getBytes(StandardCharsets.UTF_8));
//            byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(strEncrypted));
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

    //todo: end of blowfish


    public static String buttonhandlerfailed(String ttext1,String ttextfeld,String ttextfeld2,int type) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //total:32 Zeichen oder error
        String geburtpluspasswort = ttextfeld + ttextfeld2 + "aaaaaaaaaaaaaaaaaaaaaa";
        if (type == 1) {

            byte[] keyBytes = geburtpluspasswort.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey secretKey = new SecretKeySpec(keyBytes,"AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            ergebnistext.setText(Arrays.toString((cipher.doFinal(ttext1.getBytes(StandardCharsets.UTF_8)))));
            return cipher.doFinal(ttext1.getBytes(StandardCharsets.UTF_8)).toString();
        }

        if (type == 2) {
            //todo: byte array einlesen
            byte[] keyBytes = geburtpluspasswort.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey secretKey = new SecretKeySpec(keyBytes,"AES");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
//            ergebnistext.setText(Arrays.toString(cipher.doFinal(ttext1.getBytes(StandardCharsets.UTF_8))));
//            byte[] out = Base64.getDecoder().decode(ttext1);
            byte[] out = ttext1.getBytes();
            ergebnistext.setText(Arrays.toString(cipher.doFinal(out)));
//            return Arrays.toString(cipher.doFinal(ttext1));
        }
        return null;
    }


    static String algorithm = "DESede";

    public static String buttonhandler20(String ttext1,String ttextfeld,String ttextfeld2, int type) throws Exception {
        Key symKey = KeyGenerator.getInstance(algorithm).generateKey();

        Cipher c = Cipher.getInstance(algorithm);

        byte[] encryptionBytes = encryptF("texttoencrypt",symKey,c);

        System.out.println("Decrypted: " + decryptF(encryptionBytes,symKey,c));
        return null;
    }

    private static byte[] encryptF(String input,Key pkey,Cipher c) throws InvalidKeyException, BadPaddingException,

            IllegalBlockSizeException {

        c.init(Cipher.ENCRYPT_MODE, pkey);

        byte[] inputBytes = input.getBytes();

        return c.doFinal(inputBytes);
    }

    private static String decryptF(byte[] encryptionBytes,Key pkey,Cipher c) throws InvalidKeyException,

            BadPaddingException, IllegalBlockSizeException {

        c.init(Cipher.DECRYPT_MODE, pkey);

        byte[] decrypt = c.doFinal(encryptionBytes);

        String decrypted = new String(decrypt);

        return decrypted;
    }


}