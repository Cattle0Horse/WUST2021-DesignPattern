package classroom.structural.adapter.one;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/3 14:42
 * @description : 适配器模式课堂练习
 **/
public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.setCat(new ConcreteCat());
        adapter.setDog(new ConcreteDog());
        System.out.println("猫学狗");
        adapter.catchMouse();
        System.out.println("--------------");
        System.out.println("狗学猫");
        adapter.gnawBone();
    }
}

interface Cat {
    /**
     * 抓老鼠
     */
    void catchMouse();
}

class ConcreteCat implements Cat {

    @Override
    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}

interface Dog {
    /**
     * 啃骨头
     */
    void gnawBone();
}

class ConcreteDog implements Dog {
    @Override
    public void gnawBone() {
        System.out.println("啃骨头");
    }
}

/**
 * 双向适配器，并聚合Cat和Dog
 */
class Adapter implements Cat, Dog {
    private Cat cat;
    private Dog dog;

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    /**
     * Cat接口方法
     * 实现：调用Dog方法
     */
    @Override
    public void catchMouse() {
        dog.gnawBone();
    }
    /**
     * Dog接口方法
     * 实现：调用Cat方法
     */
    @Override
    public void gnawBone() {
        cat.catchMouse();
    }
}