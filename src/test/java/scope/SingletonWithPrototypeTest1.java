package scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);

        prototypeBean1.addCount();

        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        prototypeBean2.addCount();

        assertThat(prototypeBean1.getCount()).isEqualTo(prototypeBean1.getCount());
        assertThat(prototypeBean1).isInstanceOf(prototypeBean2.getClass());

    }


    @Test
    void singletonClientUsePrototype() {
        // 클라이언트 빈(싱글톤), 프로토타입 빈 둘 다 가져오기
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);

        // 프로토타입 빈도 최초 1회 생성되기 때문에,
        // 둘은 같은 인스턴스를 공유하고 있다.
//        System.out.println("clientBean1.prototypebean = " + clientBean1.getPrototypeBean());
//        System.out.println("clientBean2.prototypebean = " + clientBean2.getPrototypeBean());



    }

    @Scope("singleton")
    static class ClientBean {
        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;



        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }


    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public int addCount() {
            return count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            // 참조값 확인
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
