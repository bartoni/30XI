package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class PlanszaDane implements HierarchicalController<Plansze>{

    @FXML
    private TableView<Person> table;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField age;
    @FXML
    private TextField pesel;
    @FXML
    private TextField height;
    @FXML
    private TableColumn nameCol;
    @FXML
    private TableColumn surnameCol;
    @FXML
    private TableColumn ageCol;
    @FXML
    private TableColumn peselCol;
    @FXML
    private TableColumn heightCol;

    private Plansze parentController;

    public void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        peselCol.setCellValueFactory(new PropertyValueFactory<Person, String>("pesel"));
        heightCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("height"));
    }

    public void handleClick(ActionEvent actionEvent) {

        Person submit = new Person(name.getText(), surname.getText(), Integer.parseInt(age.getText()),
                pesel.getText(), Integer.parseInt(height.getText()));

        table.getItems().add(submit);
    }

    @Override
    public Plansze getParentController() {
        return parentController;
    }

    public void setParentController(Plansze parentController) {
        this.parentController = parentController;
        table.setItems(parentController.getDataContainer().getPeople());
    }

    public void onDeleteItem(ActionEvent actionEvent) {
    }

    public void wylicz(ActionEvent actionEvent) {

    }
}