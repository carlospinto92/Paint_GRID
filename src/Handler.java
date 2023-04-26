import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.beans.EventHandler;

public class Handler implements KeyboardHandler {
    private Player player;
    private Keyboard keyboard;
    private boolean painted;

    public Handler(Player player) {
        this.player = player;
        keyboard = new Keyboard(this);
        createdKeyboardEvents();
    }

    public void createdKeyboardEvents() {

        //move Right-->
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        //move Left <--
        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        //move up
        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        //move Down
        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        //paint cel
        KeyboardEvent keyboardEventPaint = new KeyboardEvent();
        keyboardEventPaint.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventPaint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventPaint);

        //release
        KeyboardEvent keyboardEventRel = new KeyboardEvent();
        keyboardEventRel.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventRel.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEventRel);
    }

    public boolean isPainted() {
        return painted;
    }
    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                if (isPainted()) {
                    player.paintCel();
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                if (isPainted()) {
                    player.paintCel();
                }
                break;
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                if (isPainted()) {
                    player.paintCel();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                if (isPainted()) {
                    player.paintCel();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                setPainted(true);
                while (isPainted()) {
                    player.paintCel();
                    break;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            setPainted(false);
        }
    }
}

