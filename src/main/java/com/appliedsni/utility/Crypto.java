/* ====================================== */
/* Copyright (c) 2012 Unisys Corporation. */
/*          All rights reserved.          */
/*          UNISYS CONFIDENTIAL           */
/* ====================================== */
package com.appliedsni.utility;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public final class Crypto {
	
	/**
	 * Utility class - Not for instantiation.
	 */
	private Crypto() {
		
		
	}	

    private static final String INITVECTOR = "UnisysLMSNGCargo";
    
    private static final String UTF_WORD= ("UTF-8");

    public static String encrypt(final String pValue) {
        try {
            SecretKeySpec skeySpec = null;
            {
                String key = "829629-" +"gauri" + "-654173";
                skeySpec = new SecretKeySpec(key.getBytes(UTF_WORD), "AES");

            }
            IvParameterSpec iv = new IvParameterSpec(INITVECTOR.getBytes(UTF_WORD));

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(pValue.getBytes());

            return new String(Base64.encodeBase64(encrypted));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String decrypt(final String pEncrypted) {
        try {
            SecretKeySpec skeySpec = null;
            {
                String key = "829629-" +"gauri" + "-654173";
                skeySpec = new SecretKeySpec(key.getBytes(UTF_WORD), "AES");
            }
            IvParameterSpec iv = new IvParameterSpec(INITVECTOR.getBytes(UTF_WORD));

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(pEncrypted.getBytes()));

            return new String(original);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        return "";
    }
}
