
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

/**
 *
 * @author Naseem Ali
 */
public class Snake {

    Rectangle box1, box2;
    double width;
    Paint color = Color.WHITE;
    Path path = new Path();
    int i1, i2, j1, j2;

    /**
     *
     * @param box1 The First(Top) Box In Which Snakes Head Lies
     * @param box2 The Second Box In Which Snakes Tail Lies
     * @param width The Thickness Of The Snake
     */
    public Snake(Rectangle box1, Rectangle box2, double width) {
        this.box1 = box1;
        this.box2 = box2;
        this.width = width;
        path.setStrokeLineCap(StrokeLineCap.ROUND);
        path.setStrokeLineJoin(StrokeLineJoin.ROUND);
        path.setStrokeWidth(width / 4);
    }

    /**
     *
     * @param root Used To Draw The Snake On Board
     */
    public void drawOn(Board root) {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        List<Point> p = new ArrayList<Point>();
        double slope = (y2 - y1) / (x2 - x1);
        double yy = Math.abs(y2 - y1) / 10;
        for (double i = y1; i <= y2; i += yy) {
            Point pt = new Point();
            pt.setLocation((((i - y1) / slope) + x1), i);
            p.add(pt);
        }
        path.getElements().add(new MoveTo(p.get(0).getX(), p.get(0).getY()));
        Point p1, p2;
        for (int i = 1; i < p.size(); ++i) {
            p1 = p.get(i - 1);
            p2 = p.get(i);
            if (x2 < x1) {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 - ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            } else {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 + ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            }
        }
        path.setStroke(color);
        //path.getStrokeDashArray().addAll(10d, 10d);
        DropShadow drop = new DropShadow();
        drop.setRadius(width / 4);
        drop.setColor(Color.BLACK);
        drop.setBlurType(BlurType.THREE_PASS_BOX);
        path.setEffect(drop);
        root.getChildren().add(path);
        double wd = width / 3;
        root.g.setFill(Color.RED);
        root.g.fillOval(getHead().getX() - wd / 2, getHead().getY() - wd / 2, wd, wd);
    }

    /**
     *
     * @return The Point At Which The Snake Has Its Tail
     */
    public Point getTail() {
        Point p = new Point();
        p.setLocation(box2.getCenterX(), box2.getCenterY());
        return p;
    }

    /**
     *
     * @return The Point At Which The Snake Has Its Head
     */
    public Point getHead() {
        Point p = new Point();
        p.setLocation(box1.getCenterX(), box1.getCenterY());
        return p;
    }

    /**
     *
     * @param c The Color Of The Snake
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     *
     * @return The Color Of The Snake
     */
    public Paint getColor() {
        return color;
    }

    /**
     *
     * @return The Path Traced By The Body Of The Snake
     */
    public Path getPath() {
        return path;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public int getJ1() {
        return j1;
    }

    public void setJ1(int j1) {
        this.j1 = j1;
    }

    public int getJ2() {
        return j2;
    }

    public void setJ2(int j2) {
        this.j2 = j2;
    }

}
