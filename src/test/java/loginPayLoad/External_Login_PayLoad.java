package loginPayLoad;


import pojoClass_ExternalLogin.Data_ExternalLogin_Input;
import pojoClass_ExternalLogin.Root_ExternalLogin_Input;

public class External_Login_PayLoad {

    public Root_ExternalLogin_Input addLoginDetails(String loginid, String logintype, String notificationtype) {

        System.out.println(loginid);
        Data_ExternalLogin_Input dataExternalLoginInput = new Data_ExternalLogin_Input(loginid, logintype, notificationtype);
        Root_ExternalLogin_Input rootLoginInput = new Root_ExternalLogin_Input(dataExternalLoginInput);

        return rootLoginInput;
    }


}
