package pojoClassLogin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Data_Login_Output {

    public boolean success;
    public int errorCode;
    public String errorDescription;
    public String message;

}
