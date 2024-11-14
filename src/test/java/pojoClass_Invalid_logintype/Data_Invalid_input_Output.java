package pojoClass_Invalid_logintype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Data_Invalid_input_Output {

    public boolean success;
    public int errorCode;
    public String errorDescription;
    public String message;


}
