package loginPayLoad;

import pojoClassLogin.Data_Login_Input;

public class Login_PayLoad {

    public Data_Login_Input addLoginDetails(String loginid, String logintype, String notificationtype) {

        Data_Login_Input data_login_input = new Data_Login_Input(loginid, logintype, notificationtype);
        return data_login_input;
    }
}
