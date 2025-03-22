package classroom.structural.bridge;

/**
 * @author : Cattle_Horse
 * @date : 2023/10/31 8:40
 * @description : 课堂作业
 * 桥接模式与适配器模式相结合
 */
public interface Drawing {
    void drawLine(double x1, double y1, double x2, double y2);

    void drawCircle(double x, double y, double r);
}

class DP1 {
    static public void drawALine(double x1, double y1, double x2, double y2) {
        System.out.printf("Line: Point(%f,%f), Point(%f,%f)\n", x1, y1, x2, y2);
    }

    static public void drawACircle(double x, double y, double r) {
        System.out.printf("Circle: Point(%f,%f), Radios(%f)\n", x, y, r);
    }
}

class DP2 {
    static public void drawLine(double x1, double y1, double x2, double y2) {
        System.out.printf("Line: Point(%f,%f), Point(%f,%f)\n", x1, y1, x2, y2);
    }

    static public void drawCircle(double x, double y, double r) {
        System.out.printf("Circle: Point(%f,%f), Radios(%f)\n", x, y, r);
    }
}

class V1Drawing implements Drawing {
    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        DP1.drawALine(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(double x, double y, double r) {
        DP1.drawACircle(x, y, r);
    }
}

class V2Drawing implements Drawing {
    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        DP2.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(double x, double y, double r) {
        DP2.drawCircle(x, y, r);
    }
}

abstract class Shape {
    private Drawing dp;

    public abstract void draw();

    Shape(Drawing dp) {this.dp = dp;}

    public void drawLine(double x1, double y1, double x2, double y2) {
        dp.drawLine(x1, y1, x2, y2);
    }

    public void drawCircle(double x, double y, double r) {
        dp.drawCircle(x, y, r);
    }
}

class Line extends Shape {
    private double x1, y1, x2, y2;

    public Line(Drawing dp, double x1, double y1, double x2, double y2) {
        super(dp);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        drawLine(x1, y1, x2, y2);
    }
}

class Circle extends Shape {
    private double x, y, r;

    public Circle(Drawing dp, double x, double y, double r) {
        super(dp);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void draw() {
        drawCircle(x, y, r);
    }
}
