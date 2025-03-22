package homework.decorator;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/11 21:04
 * @description :
 **/
public class Client {
    public static void main(String[] args) {
        Sheep xi = new Sheep();
        GreenBuff greenBuff = new GreenBuff();
        greenBuff.setComponent(xi);
        RedBuff redBuff = new RedBuff();
        redBuff.setComponent(greenBuff);
        YellowBuff yellowBuff = new YellowBuff();
        yellowBuff.setComponent(redBuff);
        yellowBuff.operation();
    }
}

interface Component {
    void operation();
}

class Sheep implements Component {
    @Override
    public void operation() {
        System.out.println("喜羊羊");
    }
}

abstract class Buff implements Component {
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }
}

class GreenBuff extends Buff {
    @Override
    public void operation() {
        System.out.print("奔跑速度的 ");
        component.operation();
    }
}

class RedBuff extends Buff {
    @Override
    public void operation() {
        System.out.print("加上保护罩的 ");
        component.operation();
    }
}

class YellowBuff extends Buff {
    @Override
    public void operation() {
        System.out.print("趟着水跑的 ");
        component.operation();
    }
}

