package hamsoter.core.order;

import hamsoter.core.discount.FixDiscountPolicy;
import hamsoter.core.member.Grade;
import hamsoter.core.member.Member;
import hamsoter.core.member.MemberRepository;
import hamsoter.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {

        MemberRepository memberRepository = new MemoryMemberRepository();
        Member member1 = new Member(1L,"냐무냐", Grade.VIP);
        memberRepository.save(member1);
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

        Order order = orderService.createOrder(1L, "itemA", 10_000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}