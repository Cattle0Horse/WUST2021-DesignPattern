package classroom.structural.composite.two;


import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/3 14:52
 * @description : 组合模式课堂练习2
 * TODO: 2023/11/3
 **/
public class Client {
    public static void main(String[] args) {
        Component university = new Compostite("清华大学");

    }
}

abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    protected abstract void operator();
}

class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    protected void operator() {
        System.out.println(name);
    }
}

class Compostite extends Component {
    private List<Component> components = new ArrayList<>();

    public Compostite(String name) {
        super(name);
    }

    @Override
    protected void operator() {
        System.out.println(name);
        for (Component component : components) {
            component.operator();
        }
    }
}