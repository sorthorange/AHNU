package day03;

public class Heart extends FlyObject{
    private int index;
    private int xStep;
    private int xindex;
    private int yStep;

    Heart()
    {
        index=0;
        xindex=0;
        //yStep=(int)(Math.random()*2+1);
        yStep=2;
        this.img=MyGamePanel.heart[index];
        this.width=this.img.getWidth();
        this.height=this.img.getHeight();
        this.x=(int)(Math.random()*(512-this.width));
        this.y=(int)(-Math.random()*768);
    }

    @Override
    public void step() {

       if(xindex%100==0)
        {
            if(xStep>=0)
                xStep=-(int)(Math.random()*2);
            else
                xStep=(int)(Math.random()*2);
        }
        if(this.x<=10||this.x>=512-this.width)
        {
            xStep=-xStep;
        }
        xindex++;
        this.x+=xStep;
        this.y+=yStep;
        index++;
        this.img=MyGamePanel.heart[index/10%MyGamePanel.heart.length];
    }

    @Override
    public boolean OutOfBounds() {
        return false;
    }
}
