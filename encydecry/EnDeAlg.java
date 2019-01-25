package natalbio.com.natalbio.utils.encydecry;

import android.util.Base64;
import android.util.Log;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class EnDeAlg {


    public static void encryAlg(String data){
        // Set up secret key spec for 128-bit AES encryption and decryption
        SecretKeySpec sks = null;
        try

        {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed("any data used as random seed".getBytes());
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128, sr);
            sks = new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
        } catch(Exception e)

        {
            Log.e("ENCRYP_DECRIP", "AES secret key spec error");
        }

        // Encode the original data with AES
        byte[] encodedBytes = null;
        try

        {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, sks);
            encodedBytes = c.doFinal(data.getBytes());
        } catch(
                Exception e)

        {
            Log.e("ENCRYP_DECRIP", "AES encryption error");
        }

        Log.v("ENCRYP_DECRIP", "ENCRYPTEDDATA "+encodedBytes);
        Log.v("ENCRYP_DECRIP", "ENCRYPTEDDATA BASE64 "+Base64.encodeToString(encodedBytes,Base64.DEFAULT));
    }



    public static void decrypAlg(){
        // Decode the encoded data with AES

        // Encode the original data with AES
        byte[] encodedBytes = null;

        // Set up secret key spec for 128-bit AES encryption and decryption
        SecretKeySpec sks = null;
        try

        {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed("any data used as random seed".getBytes());
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128, sr);
            sks = new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
        } catch(Exception e)

        {
            Log.e("ENCRYP_DECRIP", "AES secret key spec error");
        }
        byte[] decodedBytes = null;
        try

        {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, sks);
            decodedBytes = c.doFinal(encodedBytes);
        } catch(
                Exception e)

        {
            Log.e("ENCRYP_DECRIP", "AES decryption error");
        }
    }



    /*TextView tvdecoded = (TextView) findViewById(R.id.tvdecoded);
        tvdecoded.setText("[DECODED]:\n"+new

    String(decodedBytes) +"\n");*/
}
