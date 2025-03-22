package classroom.structural.decorator.one;

/**
 * <ol>
 * 一般有两种方式可以实现给一个类或对象增加行为
 * <li>继承机制，但是这种方法是静态的，用户不饿能控制增加行为的方式和时机</li>
 * <li>关联机制，将一个类的对象嵌入另一个对象中，由另一个对象来决定是否调用嵌入对象的行为以便扩展自己的行为</li>
 * </ol>
 * <p>
 * 装饰模式：<b>动态</b>地给一个对象增加一些额外的职责<p>
 * <p>
 * 合成复用原则 ：在实现功能复用时，多用关联，少用继承<p>
 *
 * @author : Cattle_Horse
 * @date : 2023/10/31 8:45
 * @description : 装饰模式课堂练习1
 */
public class Client {
    public static void main(String[] args) {
        Component scrollBarWindow = new ScrollBarDecorator(new Window());
        System.out.println(scrollBarWindow.display());

        Component blackBorderWindow = new BlackBorderDecorator(new Window());
        System.out.println(blackBorderWindow.display());

        Component scrollBarAndBlackBorderWindow = new ScrollBarAndBlackBorderDecorator(new Window());
        System.out.println(scrollBarAndBlackBorderWindow.display());


        System.out.println("--------------------------------");


        Component scrollBarTextBox = new ScrollBarDecorator(new TextBox());
        System.out.println(scrollBarTextBox.display());

        Component blackBorderTextBox = new BlackBorderDecorator(new TextBox());
        System.out.println(blackBorderTextBox.display());

        Component scrollBarAndBlackBorderTextBox = new ScrollBarAndBlackBorderDecorator(new TextBox());
        System.out.println(scrollBarAndBlackBorderTextBox.display());


        System.out.println("--------------------------------");


        Component scrollBarListBox = new ScrollBarDecorator(new ListBox());
        System.out.println(scrollBarListBox.display());

        Component blackBorderListBox = new BlackBorderDecorator(new ListBox());
        System.out.println(blackBorderListBox.display());

        Component scrollBarAndBlackBorderListBox = new ScrollBarAndBlackBorderDecorator(new ListBox());
        System.out.println(scrollBarAndBlackBorderListBox.display());
    }
}

/**
 * @author : Cattle_Horse
 * @date : 2023/10/31 8:53
 * @description : 组件基类
 **/
abstract class Component {
    /**
     * 显示
     *
     * @return String 组件名
     */
    public abstract String display();
}


class Window extends Component {
    @Override
    public String display() {
        return "Window";
    }
}

class TextBox extends Component {
    @Override
    public String display() {
        return "TextBox";
    }
}

class ListBox extends Component {
    @Override
    public String display() {
        return "ListBox";
    }
}

/**
 * @author : Cattle_Horse
 * @date : 2023/10/31 9:20
 * @description : 装饰抽象类
 **/
abstract class EnhancedDecorator extends Component {
    protected Component component;

    /**
     * 聚合
     */
    public EnhancedDecorator(Component component) {
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }
}

class ScrollBarDecorator extends EnhancedDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public String display() {
        return component.display() + " with ScrollBar";
    }
}

class BlackBorderDecorator extends EnhancedDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public String display() {
        return component.display() + " with BlackBorder";
    }
}

class ScrollBarAndBlackBorderDecorator extends EnhancedDecorator {
    public ScrollBarAndBlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public String display() {
        return component.display() + " with ScrollBarAndBlackBorder";
    }
}