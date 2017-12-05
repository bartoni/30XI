package sample;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainer {

    protected ObservableList<Person> people;

    protected boolean zalogowany;

    protected boolean admin;

    public ObservableList<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = FXCollections.observableArrayList(people);
    }

    public DataContainer() {
        people = FXCollections.observableArrayList();
    }

    public boolean isZalogowany() {
        return zalogowany;
    }

    public void setZalogowany(boolean zalogowany) {
        this.zalogowany = zalogowany;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
