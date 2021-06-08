package sample;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Edge extends Group {
    private Cell start, end;
    private Line line;

    public Edge(Cell start, Cell end){
        this.start = start;
        this.end = end;

        start.addChild(end);
        end.addParent(start);

        line = new Line();
        line.startXProperty().bind(start.layoutXProperty().add(start.getCenterX()));
        line.startYProperty().bind(start.layoutYProperty().add(start.getCenterY()));

        line.endXProperty().bind(end.layoutXProperty().add(end.getCenterX()));
        line.endYProperty().bind( end.layoutYProperty().add(end.getCenterY()));

        getChildren().add(line);
    }

    public Cell getStart() {
        return this.start;
    }

    public Cell getEnd() {
        return this.getEnd();
    }
}
