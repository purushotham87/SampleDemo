package natalbio.com.natalbio.utils.encydecry;

import android.util.Log;

import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class SecreatKeyGenrator
{
    public static SecretKeySpec generateKey(){
        SecretKeySpec sks = null;
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed("any data used as random seed".getBytes());
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128, sr);
            sks = new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
            Log.v("ENCRYP_DECRIP", "---> getEncoded "+sks.getEncoded());
            Log.v("ENCRYP_DECRIP", "---> getAlgorithm "+sks.getAlgorithm());
            Log.v("ENCRYP_DECRIP", "---> getFormat "+sks.getFormat());


        } catch (Exception e) {
            Log.v("ENCRYP_DECRIP", "AES secret key spec error");
        }
        return sks;
    }
}
