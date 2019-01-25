package natalbio.com.natalbio.utils.encydecry;

import android.util.Base64;
import android.util.Log;

import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class DeCryptAlg
{
    public static String decodeWithBase64(String database64, SecretKeySpec sks){



        byte[] database64_byte_array = database64.getBytes();
        byte[] decodedBytes = null;
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, sks);
            decodedBytes = c.doFinal(database64_byte_array);
        } catch (Exception e) {
            Log.e("ENCRYP_DECRIP", "AES decryption error "+e.getMessage());
        }

        return new String(decodedBytes);


    }


}
