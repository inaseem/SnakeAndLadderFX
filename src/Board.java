
import java.awt.Rectangle;
import java.util.Random;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Naseem Ali
 */
public class Board extends Pane {

    Rectangle box[][] = new Rectangle[10][10];
    GraphicsContext g;
    Random r = new Random();
    Color cl[] = new Color[100];
    DropShadow effect = new DropShadow(2, Color.BLACK);
    Canvas c = new Canvas();

    /**
     *
     * @param width The Width Of The Board
     * @param height The Height Of The Board
     */
    public Board(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        c.widthProperty().bind(widthProperty());
        c.heightProperty().bind(heightProperty());
        this.getChildren().add(c);
        g = c.getGraphicsContext2D();
        for (int i = 0; i < cl.length; ++i) {
            cl[i] = getRandomColor(Color.GREENYELLOW);
        }
        draw();
    }

    public void draw() {
        int index = 1;
        double a = getWidth() / 10;
        double b = getHeight() / 10;
        double dx, dy = (b * 10) - b;
        g.setTextAlign(TextAlignment.CENTER);
        g.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.NORMAL, 20));
        g.setLineWidth(0.5d);
        for (int i = 0, ii = (int) a; i < 10; i++, ii += a) {
            dx = 0;
            for (int j = 0, jj = (int) b; j < 10; j++, jj += b) {
                double md = dx;
                if (i % 2 == 1) {
                    md = a * 10 - (a + dx);
                }
                box[i][j] = new Rectangle();
                box[i][j].setRect(md, dy, a, b);
                g.setEffect(effect);
                g.setFill(cl[index - 1]);
                g.fillText(String.valueOf(index), md + a / 2, dy + b / 2);
                dx += a;
                index++;
                g.setGlobalAlpha(1.0d);
                g.setStroke(Color.web("#E91E63"));
                g.setEffect(null);
                if (i == 0 && j < 9) {
                    g.strokeLine(0, jj, a * 10, jj);
                }
            }
            if (i < 9) {
                g.strokeLine(ii, 0, ii, b * 10);
            }
            dy -= b;
        }
        //g.strokeLine(0, getHeight(), getWidth(), getHeight());
        //g.strokeLine(getWidth(), 0, getWidth(), getHeight());
        g.setEffect(effect);
    }

    public Color getRandomColor(Color background) {
        Color c = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        while (isEqual(c, background)) {
            c = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        }
        return c;
    }

    public boolean isEqual(Color c1, Color c) {
        Color c2 = c;
        boolean equal = false;
        if (Math.abs(c1.getRed() - c2.getRed()) * 256 <= 20) {
            equal = true;
        }
        if (Math.abs(c1.getBlue() - c2.getBlue()) * 256 <= 20) {
            equal = true;
        }
        if (Math.abs(c1.getGreen() - c2.getGreen()) * 256 <= 20) {
            equal = true;
        }
        return equal;
    }
}
