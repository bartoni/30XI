package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Plansze implements HierarchicalController<Plansze>{

    @FXML
    private Label label_login;
    @FXML
    private Label label_rola;
    @FXML
    private Pane plansza;

    protected DataContainer dataContainer;

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public Plansze() {
        dataContainer = new DataContainer();
        dataContainer.setZalogowany(false);
        dataContainer.setAdmin(false);
    }

    private void loadIntoPane(String fxml) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            final Node load = loader.load();
            if (fxml == "planszaDane.fxml" && !dataContainer.isAdmin()) {
                Button button = (Button)loader.getNamespace().get("button");
                button.setVisible(false);
            }
            plansza.getChildren().clear();
            plansza.getChildren().add(load);
            HierarchicalController<Plansze> daneController = loader.getController();
            daneController.setParentController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zmienPlanszaLogin(ActionEvent actionEvent) throws IOException {
        if (!dataContainer.isZalogowany()) {
            loadIntoPane("planszaLogin.fxml");
        } else {
            loadIntoPane("planszaLogout.fxml");
        }
    }

    public void zmienPlanszaDane(ActionEvent actionEvent) throws IOException {
        loadIntoPane("planszaDane.fxml");
    }
    public void zmienPlanszaStatystyki(ActionEvent actionEvent) throws IOException {
        loadIntoPane("planszaStatystyki.fxml");
    }

    public void setLabel_login(String nazwa){
        this.label_login.setText(nazwa);
    }

    public void setLabel_rola(String nazwa){
        this.label_rola.setText(nazwa);
    }

    @Override
    public Plansze getParentController() {
        return this;
    }

    @Override
    public void setParentController(Plansze parent) {

    }
}