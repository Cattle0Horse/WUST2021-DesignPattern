package classroom.structural.composite.one;

import java.util.ArrayList;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/3 14:49
 * @description : 组合模式课堂练习1
 */
public class Client {

    public static void display(ArrayList<Graphic> root) {
        for (Object x : root) {
            if (x.getClass().equals(Line.class)) {
                ((Line) x).draw();
            } else if (x.getClass().equals(Circle.class)) {
                ((Circle) x).draw();
            } else if (x.getClass().equals(Rectangle.class)) {
                ((Rectangle) x).draw();
            } else if (x.getClass().equals(Picture.class)) {
                display(((Picture) x).getGraphics());
            }
        }
    }

    public static void main(String[] args) {
        Picture root = new Picture();
        Picture branch1 = new Picture();
        Picture branch2 = new Picture();

        Line line1 = new Line();
        Circle circle1 = new Circle();
        Rectangle rect1 = new Rectangle();

        Line line2 = new Line();
        Circle circle2 = new Circle();
        Rectangle rect2 = new Rectangle();

        root.add(line1);
        root.add(circle1);
        root.add(branch1);
        branch1.add(line2);
        branch1.add(branch2);
        branch2.add(circle2);
        branch2.add(rect2);
        root.add(rect1);

        // Picture.display(root.getGraphics());
        root.draw();
    }
}

abstract class Graphic {
    /**
     * 画图
     */
    public abstract void draw();
}

class Circle extends Graphic {
    @Override
    public void draw() {
        System.out.println("Draw a Circle");
    }
}

class Line extends Graphic {
    @Override
    public void draw() {
        System.out.println("Draw a Line");
    }
}


class Rectangle extends Graphic {
    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}

class Picture extends Graphic {
    protected ArrayList<Graphic> graphics = new ArrayList<>();

    public void add(Graphic pic) {
        graphics.add(pic);
    }

    public void remove(Graphic pic) {
        graphics.remove(pic);
    }

    public ArrayList<Graphic> getGraphics() {
        return graphics;
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}
