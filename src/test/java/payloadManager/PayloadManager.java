package payloadManager;

import loginPayLoad.External_Login_PayLoad;
import loginPayLoad.Login_PayLoad;

public class PayloadManager {

    public Login_PayLoad loginPayLoadPayload;
    public External_Login_PayLoad externalLoginPayLoad;

    public Login_PayLoad getLoginPayLoadPayload() {
        return (loginPayLoadPayload == null) ? loginPayLoadPayload = new Login_PayLoad() : loginPayLoadPayload;
    }


    public External_Login_PayLoad getExternalLoginPayLoad() {
        return (externalLoginPayLoad == null) ? externalLoginPayLoad = new External_Login_PayLoad() : externalLoginPayLoad;
    }


}




