package hamsoter.core.discount;

import hamsoter.core.member.Grade;
import hamsoter.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int doscountPercent = 10;

    /**
     * 할인되는 금액 리턴
     */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * doscountPercent / 100;
        } else {
            return 0;
        }
    }
}