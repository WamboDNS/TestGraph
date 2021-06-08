package sample;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Cell extends Pane {

    private String cellId;

    private List<Cell> children = new ArrayList<>();
    private List<Cell> parents = new ArrayList<>();

    private Node view;
    private double centerX;
    private double centerY;

    public Cell(String cellId) {
        centerY = 0;
        centerX = 0;
        this.cellId = cellId;
    }

    public void addChild(Cell cell) {
        children.add(cell);
    }

    public List<Cell> getChildrenList() {
        return this.children;
    }

    public void addParent(Cell cell) {
        parents.add(cell);
    }

    public List<Cell> getParentsList() {
        return parents;
    }

    public void removeChild(Cell cell) {
        children.remove(cell);
    }

    public void setView(Node view) {
        this.view = view;
        getChildren().add(view);
    }

    public Node getView() {
        return this.view;
    }

    public String getCellId() {
        return cellId;
    }

    public double getCenterX() {
        return this.centerX;
    }

    public double getCenterY() {
        return this.centerY;
    }

    public void setX(double value) {
        centerX = value;
    }
    public void setY(double value) {
        centerY = value;
    }
}