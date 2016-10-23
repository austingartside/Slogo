package View;
import javafx.scene.control.ListView;

/**
 * Created by Bill Xiong on 10/19/16.
 *
 */
public class CommandHistory extends ButtonGenerator{
    private ListView<String> listView;
    public CommandHistory(){
        listView = new ListView<>();
    }
    @Override
    public ListView<String> create(){
        control = listView;
        return listView;
    }
    public void execute(){

    }
    public ListView<String> getListView(){
        return listView;
    }
}
