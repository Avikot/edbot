package com.diploma.edbot.bot;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;

public class Signature {

    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    private SecretKeySpec cryptoKey;

    private Signature (){}

    public static Signature getInstance(String secretKey) {
        Signature signature = new Signature();
        signature.cryptoKey = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA256_ALGORITHM);
        return signature;
    }

    public String calculateRFC2104HMAC(String data) throws SignatureException {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(cryptoKey);
            byte[] encrypted = mac.doFinal(data.getBytes());

            return new String(Base64.encodeBase64(encrypted));
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC: " + e.getMessage());
        }
    }
}
