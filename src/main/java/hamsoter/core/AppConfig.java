package hamsoter.core;

import hamsoter.core.discount.DiscountPolicy;
import hamsoter.core.discount.FixDiscountPolicy;
import hamsoter.core.member.MemberRepository;
import hamsoter.core.member.MemberService;
import hamsoter.core.member.MemberServiceImpl;
import hamsoter.core.member.MemoryMemberRepository;
import hamsoter.core.order.OrderService;
import hamsoter.core.order.OrderServiceImpl;

public class AppConfig {

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return  new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
