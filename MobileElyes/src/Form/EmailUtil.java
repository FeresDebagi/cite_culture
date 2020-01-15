package Form;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Form;
import static com.mycompany.myapp.Config.*;

public class EmailUtil {
    
    /*String test1;
    public String getF(String test) {
        return test1;
    }*/

    public static void sendEmail(String content) {

        ConnectionRequest r = new ConnectionRequest();
        r.setUrl(MAIL_API_URL);
        r.setPost(true);
        
        

        //r.addRequestHeader("x-apikey", "bcb8c66bd822cc8a807b574c5f4a20e54da07");
        r.addRequestHeader("x-apikey", "c03ce06a5e2fe3bdb31ccb8e351c9d005d919");

        r.addArgument("to", "elyes.fakhar@esprit.tn");
        r.addArgument("subject", "Foire");
        r.addArgument("html", "Votre Foire a ete crée");
        r.addArgument("sendername", "root");
        r.addArgument("company", "root");

        NetworkManager.getInstance().addToQueueAndWait(r);

    }
}
