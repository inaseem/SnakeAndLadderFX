
import java.util.Random;

/**
 *
 * @author Naseem Ali
 */
public class Player {

    MButton controller;
    int i = 0, j = 0;
    Random r = new Random();
    int number, laststep = 0;
    Board board;
    boolean locked = true, completed = false;
    int turn = 0;

    public Player(Board b) {
        this.board = b;
    }

    public void setController(MButton bt) {
        this.controller = bt;
    }

    public void rollDice() {
        number = (1 + r.nextInt(6));
        turn++;
    }

    public void reset() {
        turn = 0;
        locked = true;
        setLaststep(0);
        reachedEnd(false);
    }

    public int getDiceNumber() {
        return number;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getLaststep() {
        return laststep;
    }

    public void setLaststep(int laststep) {
        this.laststep = laststep;
    }

    public int getTurn() {
        return turn;
    }

    /**
     * Unlocks The Player On 6 And 1
     */
    public void unlock() {
        locked = false;
    }

    /**
     * Locks A Player
     */
    public void lock() {
        locked = true;
    }

    /**
     *
     * @return true If Player Is Locked,false If The Player Is Unlocked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     *
     * @return true If The Player Has Crossed 100 Successfully,false If Not
     */
    public boolean hasReachedEnd() {
        return completed;
    }

    /**
     *
     * @param b specifies If The Player Has Reached End
     */
    public void reachedEnd(boolean b) {
        completed = b;
    }

}
