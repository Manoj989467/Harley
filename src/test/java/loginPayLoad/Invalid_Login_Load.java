package loginPayLoad;

import pojoClass_Invalid_logintype.Data_Input_Invalid;

public class Invalid_Login_Load {

    public Data_Input_Invalid addInvalidLoginDetails(String loginid, String logintype, String notificationtype) {

        Data_Input_Invalid data_input_invalid = new Data_Input_Invalid(loginid, logintype, notificationtype);
        //Root_Input rootLoginInput = new Root_Input(data_input_invalid);

        return data_input_invalid;

    }


}
