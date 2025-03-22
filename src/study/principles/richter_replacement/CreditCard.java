package study.principles.richter_replacement;

import java.math.BigDecimal;

/**
 * @author : Cattle_Horse
 * @date   : 2023/11/6 15:40
 * @description : 信用卡
 **/
public class CreditCard extends CashCard {
    public CreditCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    boolean rule2(BigDecimal amount) {
        return amount.compareTo(new BigDecimal(1000)) <= 0;
    }

    /**
     * 提现，信用卡贷款
     *
     * @param orderId 单号
     * @param amount  金额
     * @return 状态码
     */
    public String loan(String orderId, BigDecimal amount) {
        boolean rule = rule2(amount);
        if (!rule) {
            System.out.printf("生成贷款单失败，金额超限。单号：%s 金额：%s\n", orderId, amount);
            return "0001";
        }
        // 模拟生成贷款单
        System.out.printf("生成贷款单，单号：%s 金额：%s\n", orderId, amount);
        // 模拟支付成功
        System.out.printf("贷款成功，单号：%s 金额：%s\n", orderId, amount);
        return super.negative(orderId, amount);

    }

    /**
     * 还款，信用卡还款
     *
     * @param orderId 单号
     * @param amount  金额
     * @return 状态码
     */
    public String repayment(String orderId, BigDecimal amount) {
        // 模拟生成还款单
        System.out.printf("生成还款单，单号：%s 金额：%s\n", orderId, amount);
        // 模拟还款成功
        System.out.printf("还款成功，单号：%s 金额：%s\n", orderId, amount);
        return super.positive(orderId, amount);
    }

}
