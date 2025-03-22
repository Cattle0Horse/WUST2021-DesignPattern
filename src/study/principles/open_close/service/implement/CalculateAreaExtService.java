package study.principles.open_close.service.implement;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:34
 * @description : 修改计算原型浮点数精度，对原类进行功能扩展，而不是直接修改
 */
public class CalculateAreaExtService extends CalculateAreaService {
    private final static double PI = 3.141592653D;

    @Override
    public double circular(double r) {
        return PI * r * r;
    }
}
