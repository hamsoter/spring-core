package hamsoter.core;

import hamsoter.core.discount.DiscountPolicy;
import hamsoter.core.discount.FixDiscountPolicy;
import hamsoter.core.discount.RateDiscountPolicy;
import hamsoter.core.member.MemberRepository;
import hamsoter.core.member.MemberService;
import hamsoter.core.member.MemberServiceImpl;
import hamsoter.core.member.MemoryMemberRepository;
import hamsoter.core.order.OrderService;
import hamsoter.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        // return new OrderServiceImpl(memberRepository(), discountPolicy());

        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
