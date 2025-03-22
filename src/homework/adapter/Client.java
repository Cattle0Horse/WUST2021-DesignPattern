package homework.adapter;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/11 20:38
 * @description : 适配器模式作业
 **/
public class Client {
    public static void main(String[] args) {
        View line = new Line();
        line.draw();
        View circle = new Circle();
        circle.draw();
        View angle = new AngleAdapter(new Angle());
        angle.draw();
    }
}

interface View {
    void draw();
}

class Rectangle implements View {
    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Line implements View {
    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Circle implements View {
    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Angle {
    void drawAngle() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class AngleAdapter extends Angle implements View {
    private Angle angle;

    public AngleAdapter(Angle angle) {
        this.angle = angle;
    }

    @Override
    public void draw() {
        angle.drawAngle();
    }
}
