package hamsoter.core.scan;

import hamsoter.core.AutoAppConfig;
import hamsoter.core.member.MemberRepository;
import hamsoter.core.member.MemberService;
import hamsoter.core.order.OrderService;
import hamsoter.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);

        MemberRepository memberRepository = bean.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);

    }
}
