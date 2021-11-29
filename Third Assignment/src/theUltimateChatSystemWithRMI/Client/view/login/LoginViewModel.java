package theUltimateChatSystemWithRMI.Client.view.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import theUltimateChatSystemWithRMI.Client.core.ModelFactory;
import theUltimateChatSystemWithRMI.shared.User;

public class LoginViewModel {

    private StringProperty error,username,password;
    private ModelFactory modelFactory;

    public LoginViewModel(ModelFactory modelFactory){
        this.modelFactory=modelFactory;
        error= new SimpleStringProperty();
        username= new SimpleStringProperty();
        password= new SimpleStringProperty();
    }

    public StringProperty getError() {
        return error;
    }
    public StringProperty getUsername() {
        return username;
    }
    public StringProperty getPassword() {
        return password;
    }

    public boolean onLogin(String username,String password) {
        User user = new User(username,password);
       //System.out.println(user);
        if(!modelFactory.getLoginModel().isLoginPossible(user)) {
            error.set("Incorrect username or password");
            return false;
        }
        return true;
    }
}
