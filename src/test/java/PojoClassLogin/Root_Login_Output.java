package PojoClassLogin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root_Login_Output {

        public String message;
        public Data_Login_Output data;
        public boolean success;

}
