package day03;

public class Enemy extends FlyObject{

    private int index;
    private int xStep;
    private int xindex;
    private int yStep;

    Enemy()
    {
        index=0;
        xindex=0;
        //yStep=(int)(Math.random()*2+1);
        yStep=2;
        this.img=MyGamePanel.enemy[index];
        this.width=this.img.getWidth();
        this.height=this.img.getHeight();
        this.x=(int)(Math.random()*(512-this.width));
        this.y=(int)(-Math.random()*768);
    }

    @Override
    public void step() {
        xindex++;
        if(xindex%200==0)
        {
            if(xStep>0)
                xStep=-(int)(Math.random()*3);
            else
                xStep=(int)(Math.random()*3);
        }
        if(this.x<=0||this.x>=512-this.width)
        {
            xStep=-xStep;
            xindex=0;
        }
        this.x+=xStep;
        this.y+=yStep;
        index++;
        this.img=MyGamePanel.enemy[index/10%MyGamePanel.enemy.length];
    }

    @Override
    public boolean OutOfBounds() {
        return false;
    }
}
