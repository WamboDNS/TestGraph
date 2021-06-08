package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Node extends Cell{
    private String id;

    public Node(String id) {
        super(id);
        Circle view = new Circle(1);
        view.setStroke(Color.BLACK);
        view.setFill(Color.AQUA);
        setView(view);
        setX(view.getCenterX());
        setY(view.getCenterY());
    }

}
