package theUltimateChatSystemWithRMI.Client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import theUltimateChatSystemWithRMI.Client.view.ViewController;

import java.io.IOException;

public class ViewHandler {
    private Scene loginAsGuest;
    private Scene chatScene, createAccountScene, loginScene,privateChatScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openLogin();
    }
    
    public void openLoginAsGuest() {
        if (loginAsGuest == null) {
            try {
                Parent root = loadFXML("../view/loginAsGuest/username.fxml");
                stage.setTitle("Login as a guest");
                loginAsGuest = new Scene(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginAsGuest);
        stage.show();
    }

    public void openChat() {
        if (chatScene == null) {
            try {
                Parent root = loadFXML("../view/chat/Chat.fxml");
                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(chatScene);
        stage.show();

    }


    public void openCreateAccount() {
        if (createAccountScene == null) {
            try {
                Parent root = loadFXML("../view/createAccount/createAccount.fxml");
                stage.setTitle("Create Account");
                createAccountScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(createAccountScene);
        stage.show();
    }

    public void openLogin() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("../view/login/login.fxml");
                loginScene = new Scene(root);
                stage.setTitle("Login");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();
    }

//    public void openPrivateChat(){
//        if (privateChatScene==null){
//            try {
//                Parent root = loadFXML("../view/privateChat/PrivateChat.fxml");
//                privateChatScene= new Scene(root);
//                stage.setTitle("Private Chat");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        stage.setScene(privateChatScene);
//        stage.show();
//    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }
}
