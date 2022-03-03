package hamsoter.core;

import hamsoter.core.member.Grade;
import hamsoter.core.member.Member;
import hamsoter.core.member.MemberService;
import hamsoter.core.order.Order;
import hamsoter.core.order.OrderService;
import hamsoter.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        /*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        OrderService orderService = appConfig.orderService();

        */
        Long memberId = 1L;
        Member member1 = new Member(memberId, "소이", Grade.BASIC);
        Member member2 = new Member(2L, "후타바안즈", Grade.VIP);


        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(1L, "피규어", 100_000);

        Order order2 = orderService.createOrder(2L, "파르페", 10_000);


        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order2.calculatePrice());

    }
}
