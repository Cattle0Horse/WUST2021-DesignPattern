package study.principles.richter_replacement;

import java.math.BigDecimal;

/**
 * <ol>
 *     里氏代换原则：
 *     <li>所有引用基类的地方必须能透明地使用其子类对象。</li>
 *     <li>一个可以接受基类对象的地方必然可以接受一个子类对象。</li>
 * </ol>
 *
 * @author : Cattle_Horse
 * @date : 2023/11/6 15:37
 * @description : 里氏代换原则
 */
public class Client {
    public static void main(String[] args) {
        testBankCard();
        // testCreditCard();
    }

    public static void testBankCard() {
        System.out.println("里氏替换前，CashCard类：");

        CashCard bankCard = new CashCard("6214567800989876", "2022-03-05");
        // 提现
        bankCard.withdrawal("100001", new BigDecimal(100));
        // 储蓄
        bankCard.recharge("100001", new BigDecimal(100));

        System.out.println("\n里氏替换后，CashCard子类 -> CreditCard类：");
        CashCard creditCard = new CreditCard("6214567800989876", "2022-03-05");
        // 提现
        creditCard.withdrawal("100001", new BigDecimal(1000000));
        // 储蓄
        creditCard.recharge("100001", new BigDecimal(100));
    }

    public static void testCreditCard() {
        CreditCard creditCard = new CreditCard("6214567800989876", "2022-03-05");
        // 支付，贷款
        creditCard.loan("100001", new BigDecimal(100));
        // 还款
        creditCard.repayment("100001", new BigDecimal(100));
    }
}
