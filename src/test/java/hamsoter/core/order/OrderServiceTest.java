package hamsoter.core.order;

import hamsoter.core.member.Grade;
import hamsoter.core.member.Member;
import hamsoter.core.member.MemberService;
import hamsoter.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void 주문생성() {
        Member member1 = new Member(1L,"후타바 안즈", Grade.VIP);

        memberService.join(member1);

        Order order1 = orderService.createOrder(1L, "파르페", 10000);

        assertThat(order1.getDiscountPrice()).isEqualTo(1000);

    }
}
