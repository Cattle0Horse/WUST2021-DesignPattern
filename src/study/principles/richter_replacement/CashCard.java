package study.principles.richter_replacement;


import java.math.BigDecimal;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/6 15:46
 * @description : 模拟储蓄卡功能
 **/
public class CashCard extends BankCard {

    public CashCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    @Override
    boolean rule(BigDecimal amount) {
        return true;
    }

    /**
     * 提现
     *
     * @param orderId 单号
     * @param amount  金额
     * @return 状态码 0000成功、0001失败、0002重复
     */
    public String withdrawal(String orderId, BigDecimal amount) {
        // 模拟支付成功
        System.out.printf("提现成功，单号：%s 金额：%s\n", orderId, amount);
        return super.negative(orderId, amount);
    }

    /**
     * 储蓄
     *
     * @param orderId 单号
     * @param amount  金额
     */
    public String recharge(String orderId, BigDecimal amount) {
        // 模拟充值成功
        System.out.printf("储蓄成功，单号：%s 金额：%s\n", orderId, amount);
        return super.positive(orderId, amount);
    }

    /**
     * 风险校验
     *
     * @param cardNo  卡号
     * @param orderId 单号
     * @param amount  金额
     * @return 状态
     */
    public boolean checkRisk(String cardNo, String orderId, BigDecimal amount) {
        // 模拟风控校验
        System.out.printf("风控校验，卡号：%s 单号：%s 金额：%s\n", cardNo, orderId, amount);
        return true;
    }

}
