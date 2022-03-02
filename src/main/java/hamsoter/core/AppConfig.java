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

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return  new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
