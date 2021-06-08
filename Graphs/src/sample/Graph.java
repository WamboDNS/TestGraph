package sample;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class Graph {

    private Model model;
    private Group canvas;
    private ZoomableScrollPane scrollPane;
    private Dragger dragger;
    private CellLayer cellLayer;

    public Graph() {

        this.model = new Model();

        canvas = new Group();
        cellLayer = new CellLayer();

        canvas.getChildren().add(cellLayer);

        dragger = new Dragger(this);

        scrollPane = new ZoomableScrollPane(canvas);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

    }

    public ScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public Pane getCellLayer() {
        return this.cellLayer;
    }

    public Model getModel() {
        return model;
    }

    public void beginUpdate() {
    }

    public void endUpdate() {
        cellLayer.getChildren().addAll(model.getAddedEdges());
        cellLayer.getChildren().addAll(model.getAddedCells());

        cellLayer.getChildren().removeAll(model.getRemovedEdges());
        cellLayer.getChildren().removeAll(model.getRemovedCells());

        for(Cell cell : model.getAddedCells()) {
            dragger.makeDraggable(cell);
        }

        getModel().attachOrphansToGraphParent(model.getAddedCells());
        getModel().disconnectFromGraphParent(model.getRemovedCells());
        getModel().merge();
    }

    public double getScale() {
        return this.scrollPane.getScaleValue();
    }
}
