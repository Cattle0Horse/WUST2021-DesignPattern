package classroom.behavioral.state.one;

public class Client {
    public static void main(String[] args) {

    }
}

abstract class CState {
    public int flyMiles;    // 里程数

    public abstract double travel(int miles, CFrequentFlyer context);  // 根据累积里程数调整会员等级
}

class CNoCustomer extends CState {  // 非会员
    @Override
    public double travel(int miles, CFrequentFlyer context) {
        System.out.println("Your travel will not account for points");
        return miles;    // 不累积里程数
    }
}

class CBasic extends CState {  // 普卡会员
    @Override
    public double travel(int miles, CFrequentFlyer context) {
        if (context.flyMiles >= 25000 && context.flyMiles < 50000) {
            context.setState(new CSilver());
        }
        if (context.flyMiles >= 50000) {
            context.setState(new CGold());
        }
        return miles;
    }
}

class CGold extends CState {  // 金卡会员
    @Override
    public double travel(int miles, CFrequentFlyer context) {
        if (context.flyMiles >= 25000 && context.flyMiles < 50000) {
            context.setState(new CSilver());
        }
        if (context.flyMiles < 25000) {
            context.setState(new CBasic());
        }
        return miles + 0.5 * miles;    // 累积里程数
    }
}

class CSilver extends CState {  // 银卡会员
    @Override
    public double travel(int miles, CFrequentFlyer context) {
        if (context.flyMiles < 25000) {
            context.setState(new CBasic());
        }
        if (context.flyMiles >= 50000) {
            context.setState(new CGold());
        }
        return miles + 0.25 * miles;    // 累积里程数
    }
}

class CFrequentFlyer {
    CState state;
    double flyMiles;

    public CFrequentFlyer() {
        state = new CNoCustomer();
        flyMiles = 0;
        setState(state);
    }

    public void setState(CState state) {this.state = state;}

    public void travel(int miles) {
        double bonusMiles = state.travel(miles, this);
        flyMiles = flyMiles + bonusMiles;
    }
}
