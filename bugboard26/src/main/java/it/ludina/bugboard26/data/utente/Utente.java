package it.ludina.bugboard26.data.utente;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import lombok.Getter;

public abstract class Utente {

    @Getter private String email;
    private String password;

    public abstract String getUserType();

    public String getPassword(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hashedPass = factory.generateSecret(spec).getEncoded();
            return hashedPass.toString();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }

    }
}