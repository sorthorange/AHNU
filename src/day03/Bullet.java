package day03;

public class Bullet extends FlyObject{

    Bullet(int heroX, int heroY)
    {
        this.img=MyGamePanel.bullets;
        this.width=this.img.getWidth();
        this.height=this.img.getHeight();
        this.x=heroX;
        this.y=heroY;
    }

    @Override
    public void step() {

    }

    @Override
    public boolean OutOfBounds() {
        return false;
    }
}
