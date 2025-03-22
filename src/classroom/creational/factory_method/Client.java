package classroom.creational.factory_method;

/**
 * 工厂方法模式（Factory Method Pattern）定义：<p>
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 17:46
 * @description : 工厂方法模式
 */
public class Client {
    public static void main(String[] args) {
        Chart chart = new HistogramChartFactory().getChart();
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

interface ChartFactory {
    /**
     * 创建图表抽象方法
     *
     * @return 一种图表
     */
    Chart getChart();
}

class HistogramChartFactory implements ChartFactory {
    @Override
    public Chart getChart() {
        return new HistogramChart();
    }
}

class LineChartFactory implements ChartFactory {
    @Override
    public Chart getChart() {
        return new LineChart();
    }
}

class PieChartFactory implements ChartFactory {
    @Override
    public Chart getChart() {
        return new PieChart();
    }
}