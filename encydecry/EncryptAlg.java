package natalbio.com.natalbio.utils.encydecry;

import android.util.Base64;
import android.util.Log;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAlg
{

    public static String encywithBase64(String original_data, SecretKeySpec sks) {
        // Set up secret key spec for 128-bit AES encryption and decryption

        // Encode the original data with AES
        byte[] encodedBytes = null;
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, sks);
            encodedBytes = c.doFinal(original_data.getBytes());
        } catch (Exception e) {
            Log.v("ENCRYP_DECRIP", "AES encryption error");
        }
        return Base64.encodeToString(encodedBytes, Base64.DEFAULT);
    }



}
