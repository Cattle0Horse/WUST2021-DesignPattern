package classroom.creational.singleton;

/**
 * 单例模式(Singleton Pattern)：<p>
 * 单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。
 *
 * @author : Cattle_Horse
 * @date : 2023/11/8 12:01
 * @description : 单例模式
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("checkSingleton1() = " + checkSingleton1());
        System.out.println("checkSingleton2() = " + checkSingleton2());
        System.out.println("checkSingleton3() = " + checkSingleton3());
        System.out.println("checkSingleton4() = " + checkSingleton4());
    }

    private static boolean checkSingleton1() {
        return Singleton1.getInstance() == Singleton1.getInstance();
    }

    private static boolean checkSingleton2() {
        return Singleton2.getInstance() == Singleton2.getInstance();
    }

    private static boolean checkSingleton3() {
        return Singleton3.getInstance() == Singleton3.getInstance();
    }

    private static boolean checkSingleton4() {
        return Singleton4.getInstance() == Singleton4.getInstance();
    }
}

/**
 * 饿汉式单例类：在定义私有静态属性时就已经实例化。
 * <ol>
 *  <li>优点：这种写法比较简单，就是在类加载的时候就完成实例化。避免了线程同步问题。</li>
 *  <li>缺点：在类加载的时候就完成实例化，没有达到懒加载的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。</li>
 * </ol>
 */
class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}

/**
 * 懒汉式单例类：在第一次调用{@link Singleton2#getInstance()}时实例化内部静态对象<p>
 * 如果在首次调用 {@link Singleton2#getInstance()} 时，是由多个线程同时调用的：<p>
 * 一个线程进入 {@code if} 判断语句后但还没有实例化 {@link Singleton2} 时，其他线程到达，此时 {@code instance} 还是为 {@code null}，
 * 这样的话，多个线程进入 {@link Singleton2#getInstance()}，因为有多个线程，所以会创建多个实例。
 */
class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 解决{@link Singleton2}线程不安全的方案：为方法添加同步锁，锁定线程，待当前线程完成后在执行另一个线程
 * <ol>
 *     <li>优点：解决了线程不安全问题</li>
 *     <li>缺点：效率太低了，每个线程在想获得类的实例时候，执行{@link Singleton3#getInstance()}方法都要进行同步。</li>
 * </ol>
 */
class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {}

    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * 解决 {@link Singleton3} 效率问题：双重检查锁<p>
 * Double-Check 概念是多线程开发中常使用到的，如代码中所示，我们进行了两次 {@code if (instance == null)} 检查，这样就可以保证线程安全了。<p>
 * 这样，实例化代码只用执行一次，后面再次访问时，判断 {@code if (instance == null)}，直接{@code return} 实例化对象，也避免反复的进行方法同步.<p>
 * 优点：线程安全；延迟加载；效率较高<p>
 * 双重检查锁定 {@code volatile} 关键词
 */
class Singleton4 {
    private static volatile Singleton4 instance = null;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类实现单例模式。所有通过私有化方法的方式实现单例都有可能被反射破坏单例<p>
 */
class Singleton5 {
    private Singleton5() {}

    public static class Singleton5Holder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Singleton5Holder.INSTANCE;
    }
}

/**
 * 枚举方式实现单例模式，不会被反射破坏单例性<p>
 * 缺点：与饿汉式单例模式相同，在类加载的时候就完成实例化，没有达到懒加载的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
enum Singleton6 {
    /**
     *
     */
    INSTANCE;
}