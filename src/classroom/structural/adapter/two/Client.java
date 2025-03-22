package classroom.structural.adapter.two;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/28 12:02
 * @description :
 */
public class Client {
}

interface Shape {
    void display();
}

class XCircle {
    public void displayIt() {
        System.out.println("Circle");
    }
}

class Circle extends XCircle implements Shape {
    @Override
    public void display() {
        displayIt();
    }
}
