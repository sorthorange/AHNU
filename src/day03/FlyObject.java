package day03;

import java.awt.image.BufferedImage;

public abstract class FlyObject {
    public BufferedImage img;
    public int x,y,width,height;

    public abstract void step();

    public abstract boolean OutOfBounds();
}
