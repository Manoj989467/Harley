package loginPayLoad;


import pojoClassLogin.Data_Login_Input;
import pojoClassLogin.Root_Login_Input;

public class Login_PayLoad {

    public Root_Login_Input addLoginDetails(String loginid, String logintype, String notificationtype) {

        Data_Login_Input data_login_input = new Data_Login_Input(loginid, logintype, notificationtype);
        Root_Login_Input rootLoginInput = new Root_Login_Input(data_login_input);

        return rootLoginInput;

    }
}
