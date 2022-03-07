package hamsoter.core.autowired;

import hamsoter.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // 스프링 빈이 아닌
    static class TestBean {

        // 메서드 호출 자체가 씹힘
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);

        }

        //
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member = " + member);

        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("member = " + noBean3);

        }
    }
}
