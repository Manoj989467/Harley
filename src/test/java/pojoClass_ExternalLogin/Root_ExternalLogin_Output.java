package pojoClass_ExternalLogin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Root_ExternalLogin_Output {


    public boolean success;
    public String message;
    public Data_ExternalLogin_Output data;

}
