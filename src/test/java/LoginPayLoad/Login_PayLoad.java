package LoginPayLoad;

import PojoClassLogin.Data_Login_Output;

public class Login_PayLoad {

    public Data_Login_Output addLoginDetails(String login_id, Boolean registeruserid){

        Data_Login_Output dataLoginOutput =new Data_Login_Output(login_id,registeruserid);
        return dataLoginOutput;

    }
}
