package hamsoter.core.singleton;

import hamsoter.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10_000);
        //ThreadB: B 사용자가 냅다 껴들어서 20000원 주문
        int userBPrice = statefulService2.order("userB", 20_000);

        // ThreadA: 사용자 A가 주문 금액을 조회
        System.out.println(userAPrice);
        assertThat(userAPrice).isNotEqualTo(userBPrice);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}