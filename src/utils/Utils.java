package utils;

import types.Pair;
import types.RGB;

import java.awt.*;

import static java.lang.Thread.sleep;

public class Utils {

    public static RGB getScreenColor(Pair pos, Robot bot) {
        Color col = bot.getPixelColor(10, 10);
        return new RGB(col.getRed(), col.getGreen(), col.getBlue());
    }
    public static void wait(int ms) {
        try {
            sleep(ms);
        }
        catch(InterruptedException ex)  {
            Thread.currentThread().interrupt();
        }
    }
}
