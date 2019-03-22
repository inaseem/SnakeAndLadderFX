
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

/**
 *
 * @author Naseem Ali
 */
public class Dice extends Canvas {

    boolean show = false;
    InnerShadow effect = new InnerShadow(5, Color.BLACK);
    GraphicsContext g;

    public Dice(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        effect.setBlurType(BlurType.THREE_PASS_BOX);
        g = getGraphicsContext2D();
        g.setEffect(effect);
    }

    /**
     * Makes The Dice Visible Or Vice Versa
     *
     * @param b Specifies If The Dice Should Be Made Visible Or Not
     */
    public void setShow(boolean b) {
        show = b;
    }

    public void update(int number) {
        if (show == true) {
            g.setFill(Color.web("#ffffff"));
            double a = getWidth();
            double b = getHeight();
            double c = Math.min(a, b);
            g.fillRoundRect(0, 0, a, b, c / 4, c / 4);
            g.setFill(Color.web("#303030"));

            ///////////////////////////////////////////
            switch (number) {
                case 1:
                    g.fillOval(a / 2 - a / 6, b / 2 - b / 6, a / 3, b / 3);
                    break;
                case 2:
                    g.fillOval(a / 4 - a / 6, b / 4 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 4 + a / 2 - a / 6, b / 4 + b / 2 - b / 6, a / 3, b / 3);
                    break;
                case 3:
                    g.fillOval(a / 6 - a / 6, b / 6 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + a / 3 - a / 6, b / 6 + b / 3 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + (2 * a) / 3 - a / 6, b / 6 + (2 * b / 3) - b / 6, a / 3, b / 3);
                    break;
                case 4:
                    g.fillOval(a / 4 - a / 6, b / 4 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 4 + a / 2 - a / 6, b / 4 + b / 2 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 4 - a / 6, b / 4 + b / 2 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 4 + a / 2 - a / 6, b / 4 - b / 6, a / 3, b / 3);
                    break;
                case 5:
                    g.fillOval(a / 6 - a / 6, b / 6 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + a / 3 - a / 6, b / 6 + b / 3 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + (2 * a) / 3 - a / 6, b / 6 + (2 * b / 3) - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 - a / 6, b / 6 + (2 * b / 3) - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + (2 * a) / 3 - a / 6, b / 6 - b / 6, a / 3, b / 3);
                    break;
                case 6:
                    g.fillOval(a / 6 - a / 6, b / 4 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + a / 3 - a / 6, b / 4 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + (2 * a) / 3 - a / 6, b / 4 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 - a / 6, b / 4 + b / 2 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + a / 3 - a / 6, b / 4 + b / 2 - b / 6, a / 3, b / 3);
                    g.fillOval(a / 6 + (2 * a) / 3 - a / 6, b / 4 + b / 2 - b / 6, a / 3, b / 3);
                    break;
                default:
                    break;
            }
        }
    }

}
