package day03;

public class Hero extends FlyObject{

    private int index;

    public Hero()
    {
        index=0;
        this.img=MyGamePanel.ws[index];
        this.width=this.img.getWidth();
        this.height=this.img.getHeight();
        this.x=200;
        this.y=500;
    }

    @Override
    public void step()
    {
        index++;
        this.img=MyGamePanel.ws[index/10%MyGamePanel.ws.length];
    }

    @Override
    public boolean OutOfBounds() {
        return false;
    }

    void Move(int xx, int yy)
    {
        //this.x=x-this.width/2;
        //this.y=y-this.height/2;
        this.x=xx-this.width/2;
        this.y=yy-this.height/2;
    }
}
