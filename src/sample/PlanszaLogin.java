package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.io.IOException;

public class PlanszaLogin implements HierarchicalController<Plansze>{

    public TextField login;
    public TextField password;
    private Plansze parentController;

    public void handleZaloguj(ActionEvent actionEvent) throws IOException {
        parentController.setLabel_login(login.getText());
        if (login.getText().equals("admin")) {
            parentController.setLabel_rola("admin");
            parentController.getDataContainer().setAdmin(true);
        } else {
            parentController.setLabel_rola("user");
        }
        parentController.getDataContainer().setZalogowany(true);
        parentController.zmienPlanszaLogin(actionEvent);
    }

    public void handleWyloguj(ActionEvent actionEvent) throws IOException {
        parentController.setLabel_rola("");
        parentController.setLabel_login("");
        parentController.getDataContainer().setZalogowany(false);
        parentController.getDataContainer().setAdmin(false);
        parentController.zmienPlanszaLogin(actionEvent);

    }

    @Override
    public Plansze getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(Plansze parentController) {
        this.parentController = parentController;

    }
}