package payloadManager;

import loginPayLoad.Invalid_Login_Load;
import loginPayLoad.Login_PayLoad;

public class PayloadManager {

    public Login_PayLoad loginPayLoadPayload;
    public Invalid_Login_Load invalidLoginLoad;

    public Login_PayLoad getLoginPayLoadPayload() {
        return (loginPayLoadPayload == null) ? loginPayLoadPayload = new Login_PayLoad() : loginPayLoadPayload;
    }

    public Invalid_Login_Load getInvalidLoginPayLoad() {
        return (invalidLoginLoad == null) ? invalidLoginLoad = new Invalid_Login_Load() : invalidLoginLoad;
    }


}




