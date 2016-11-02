package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpButton implements Placeable{
    
    private Button help;
    
    public HelpButton(){
        help = new Button("Help");
        help.setOnAction(ae -> displayHelp());
        help.setMaxWidth(Double.MAX_VALUE);
    }
    
    private void displayHelp(){
        String path = System.getProperty("user.dir");
        path += "/src/help.html";
        WebView web = new WebView();
        web.getEngine().load("file:///" + path);
        Stage s = new Stage();
        Scene scene = new Scene(web);
        scene.setRoot(web);
        s.setScene(scene);
        s.show();
    }
    
    public Node getView(){
        return help;
    }

}
