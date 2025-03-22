package study.principles.richter_replacement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:43
 * @description : 银行卡
 **/
public abstract class BankCard {
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 开卡时间
     */
    private String cardDate;

    public BankCard(String cardNo, String cardDate) {
        this.cardNo = cardNo;
        this.cardDate = cardDate;
    }

    abstract boolean rule(BigDecimal amount);

    // 正向入账，+ 钱
    public String positive(String orderId, BigDecimal amount) {
        // 入款成功，存款、还款
        System.out.printf("卡号%s 入款成功，单号：%s 金额：%s", cardNo, orderId, amount);
        return "0000";
    }

    // 逆向入账，- 钱
    public String negative(String orderId, BigDecimal amount) {
        // 入款成功，存款、还款
        System.out.printf("卡号%s 出款成功，单号：%s 金额：%s\n", cardNo, orderId, amount);
        return "0000";
    }

    /**
     * 交易流水查询
     *
     * @return 交易流水
     */
    public List<String> tradeFlow() {
        System.out.println("交易流水查询成功");
        List<String> tradeList = new ArrayList<>();
        tradeList.add("100001,100.00");
        tradeList.add("100001,80.00");
        tradeList.add("100001,76.50");
        tradeList.add("100001,126.00");
        return tradeList;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getCardDate() {
        return cardDate;
    }
}
