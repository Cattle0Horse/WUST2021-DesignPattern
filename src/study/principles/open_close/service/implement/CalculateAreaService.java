package study.principles.open_close.service.implement;

import study.principles.open_close.service.ICalculateAreaService;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:33
 * @description :
 */
public class CalculateAreaService implements ICalculateAreaService {
    private final static double PI = 3.14D;


    @Override
    public double rectangle(double x, double y) {
        return x * y;
    }

    @Override
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    @Override
    public double circular(double r) {
        return PI * r * r;
    }

}
