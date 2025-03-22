package classroom.behavioral.strategy.two;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/10 15:10
 * @description : 策略模式课堂作业
 */
public class Client {
}

enum TYPE {NORMAL, CASH_DISCOUNT, CASH_RETURN};

interface CashSuper {
    public double acceptCash(double money);
}

class CashNormal implements CashSuper {    // 正常收费子类
    @Override
    public double acceptCash(double money) {
        return money;
    }
}

class CashDiscount implements CashSuper {
    private double moneyDiscount;    // 折扣率

    public CashDiscount(double moneyDiscount) {
        this.moneyDiscount = moneyDiscount;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyDiscount;
    }
}

class CashReturn implements CashSuper {    // 满额返利
    private double moneyCondition;
    private double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;        // 满额数额
        this.moneyReturn = moneyReturn;            // 返利数额
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition) {
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}

class CashContext {
    private CashSuper cs;
    private TYPE t;

    public CashContext(TYPE t) {
        switch (t) {
            case NORMAL:                // 正常收费
                cs = new CashNormal();
                break;
            case CASH_DISCOUNT:    // 打8折
                cs = new CashDiscount(0.8);
                break;
            case CASH_RETURN:        // 满300返100
                cs = new CashReturn(300, 100);
                break;
        }
    }

    public double GetResult(double money) {
        return cs.acceptCash(money);
    }
    // 此处略去main()函数
}


