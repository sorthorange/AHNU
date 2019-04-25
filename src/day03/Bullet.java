package day03;

public class Bullet extends FlyObject{

    Bullet(int heroX, int heroY)
    {
        this.img=MyGamePanel.bullets;
        this.width=this.img.getWidth();
        this.height=this.img.getHeight();
        this.x=heroX-this.width/2;
        this.y=heroY-this.height/2;
    }

    @Override
    public void step() {
        this.y--;
    }

    @Override
    public boolean OutOfBounds() {
        return false;
    }
}
