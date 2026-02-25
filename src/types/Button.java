package types;


import utils.Utils;

import java.awt.*;
import java.awt.event.InputEvent;

import static utils.Utils.getScreenColor;


public class Button {
    private final RGB[] colors;
    private final Pair pos;

    public Button(Pair pos, RGB[] colors) {
        this.pos = pos;
        this.colors = colors;
    }

    public Pair getPos(){return pos;}
    public RGB[] getRGB(){return colors;}

    public int getX() {return pos.getX();}
    public int getY() {return pos.getY();}

    public boolean isOnScreen(Robot bot) {
        for (RGB color : getRGB()) {
            if (color.isEqualRGB(getScreenColor(pos, bot))) {
                return true;
            }
        }
        return false;
    }
    public void click(Robot bot) {
        bot.mouseMove(getX(), getY());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public void click(Robot bot, boolean waitIsOnScreen) {

        if (waitIsOnScreen) {
            while(!isOnScreen(bot) && !Thread.currentThread().isInterrupted()) {
                Utils.wait(1);
            }
        }

        bot.mouseMove(this.getX(), this.getY());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

}
