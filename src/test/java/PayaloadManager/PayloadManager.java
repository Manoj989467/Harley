package PayaloadManager;

import LoginPayLoad.Login_PayLoad;

public class PayloadManager {

        private Login_PayLoad loginPayLoadPayload;

        public Login_PayLoad getLoginPayLoadPayload () {
            return (loginPayLoadPayload == null) ? loginPayLoadPayload = new Login_PayLoad () : loginPayLoadPayload;
        }

    }




