
import javafx.scene.control.Button;

/**
 *
 * @author Naseem Ali
 */
public class MButton extends Button {

    int position = 0;

    public MButton(int i) {
        position = i;
    }

    public int getPlayerIndex() {
        return position;
    }
}
