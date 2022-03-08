package hamsoter.core.autowired;

import hamsoter.core.AutoAppConfig;
import hamsoter.core.discount.DiscountPolicy;
import hamsoter.core.member.Grade;
import hamsoter.core.member.Member;
import hamsoter.core.order.OrderService;
import hamsoter.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class ,DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "소이", Grade.VIP);
        int fixPrice = discountService.discount(member, 10_000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(fixPrice).isEqualTo(1_000);

        int ratePrice = discountService.discount(member, 12_000, "rateDiscountPolicy");

        assertThat(ratePrice).isEqualTo(1_200);
    }

    static class DiscountService {
        // Key = 빈 이름,    Value = 빈 객체
        private final Map<String,DiscountPolicy> policyMap;

        // 빈 객체가 모인 List??
        private final List<DiscountPolicy> policies;


        // 생성자주입
        DiscountService(
                Map<String, DiscountPolicy> policyMap, // policyMap = ac.getBeansOfType(DiscountPolicy.clss)
                List<DiscountPolicy> policies // 위와 같으나 value(객체)값만 있음
        ) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {

            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            return discountPolicy.discount(member, price);

        }
    }
}
