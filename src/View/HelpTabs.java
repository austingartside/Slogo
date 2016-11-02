package View;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

public class HelpTabs implements Placeable{

    private CommandHistory commandHistory;
    private CurrentCommands currCommands;
    private CurrentVariables currVariables;
    private CurrentState currState;
    private TabPane tabs;
    
    public HelpTabs(){
        commandHistory = new CommandHistory();
        currCommands = new CurrentCommands();
        currVariables = new CurrentVariables();
        currState = new CurrentState();
        tabs = new TabPane();
        tabs.getTabs().add(makeTab(commandHistory.getView(),"Command History"));
        tabs.getTabs().add(makeTab(currCommands.getView(),"Current Commands"));
        tabs.getTabs().add(makeTab(currVariables.getView(),"Current Variables"));
        tabs.getTabs().add(makeTab(currState.getView(),"Current State"));
    }
    
    private Tab makeTab(Node n,String name){
        Tab tab = new Tab();
        tab.setText(name);
        tab.setContent(n);
        return tab;
    }

    public void setCurrCommAction(EventHandler<MouseEvent> a){
        currCommands.setOnAction(a);
    }
    
    public void setCurrVarAction(EventHandler<MouseEvent> a){
        currVariables.setOnAction(a);
    }
    
    public void setCommHistAction(EventHandler<MouseEvent> a){
        commandHistory.setOnAction(a);
    }

    public void setCurrStateAction(EventHandler<MouseEvent> a){
        currState.setOnAction(a);
    }
    public Node getView(){
        return tabs;
    }
    
    public CommandHistory getCommHist(){
        return commandHistory;
    }
    
    public CurrentCommands getCurrComm(){
        return currCommands;
    }
    
    public CurrentVariables getCurrVar(){
        return currVariables;
    }

    public CurrentState getCurrState(){
        return currState;
    }
}
