package sample;

public class PlanszaStatystyki implements HierarchicalController<Plansze> {

    private Plansze parentController;

    public void setParentController(Plansze parentController) {
        this.parentController = parentController;
    }

    public Plansze getParentController() {
        return parentController;
    }
}