
import javafx.scene.layout.Pane;

public class Star {

    private Point p1, p2;
    private javafx.scene.shape.Line line;

    public Star(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public javafx.scene.shape.Line show(Pane root1) {
        if (line == null) {
            line = new javafx.scene.shape.Line();
            root1.getChildren().add(line);
        }
        line.setStartX(p1.getX());
        line.setStartY(p1.getY());
        line.setEndX(p2.getX());
        line.setEndY(p2.getY());
        return line;
    }
}