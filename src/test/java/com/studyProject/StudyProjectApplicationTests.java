package com.studyProject;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SpringBootTest
class StudyProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getPassword() {
        String salt="yaWCqfCA1T8r0OpmUcflbfLEhjn0qExEpVyF071L5GZgWbSoQYxkQgcXJWJHApxV";

    }
    public static String pbkdf2(String plain, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        PBEKeySpec spec = new PBEKeySpec(plain.toCharArray(), salt.getBytes(), 1000, 32 * 8);
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return Hex.encodeHexString(hash);
    }
}
