package classroom.creational.simple_factory;

/**
 * 简单工厂模式（又称为静态工厂方法）：它属于类创建型模式。在简单工厂模式中，根据参数的不同返回不同类的实例。<p>
 * 简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 17:06
 * @description : 简单工厂模式
 */
public class Client {
    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart(ChartFactory.Type.Histogram);
        chart.display();
    }
}

/**
 * 图标抽象类
 */
interface Chart {
    /**
     * 绘图
     */
    void display();
}

/**
 * 柱状图
 */
class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("create HistogramChart");
    }

    @Override
    public void display() {
        System.out.println("display HistogramChart");
    }
}

/**
 * 折线图
 */
class LineChart implements Chart {
    public LineChart() {
        System.out.println("create LineChart");
    }

    @Override
    public void display() {
        System.out.println("display LineChart");
    }
}

/**
 * 饼状图
 */
class PieChart implements Chart {
    public PieChart() {
        System.out.println("create PieChart");
    }

    @Override
    public void display() {
        System.out.println("display PieChart");
    }
}

class ChartFactory {
    public enum Type {
        /**
         * 图标类型：
         * Histogram：柱状图
         * Line：折线图
         * Pie：饼状图
         */
        Histogram, Line, Pie
    }

    public static Chart getChart(Type type) {
        Chart chart = null;
        switch (type) {
            case Histogram -> {
                chart = new HistogramChart();
                System.out.println("initialize HistogramChart");
            }
            case Line -> {
                chart = new LineChart();
                System.out.println("initialize LineChart");
            }
            case Pie -> {
                chart = new PieChart();
                System.out.println("initialize PieChart");
            }
            default -> System.out.println("initialization failed");
        }
        return chart;
    }
}