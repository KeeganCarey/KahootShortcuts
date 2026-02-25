package types;

import java.awt.*;

public class RGB {
    private int red;
    private int green;
    private int blue;

    public RGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean isEqualRGB(RGB rgb) {
        return rgb.getRed() == this.red && rgb.getGreen() == this.green && rgb.getBlue() == this.blue;
    }
    public boolean isEqualRGB(Color pixcol) {
        return pixcol.getRed() == this.red && pixcol.getGreen() == this.green && pixcol.getBlue() == this.blue;
    }

    public boolean isBetween(RGB min, RGB max) {
        return getRed() >= min.getRed() && getGreen() >= min.getGreen() && getBlue() >= min.getBlue()
                && getRed() <= max.getRed() && getGreen() <= max.getGreen() && getBlue() <= max.getBlue();
    }

    public int getRed() {return red;}
    public int getGreen() {return green;}
    public int getBlue() {return blue;}
}
