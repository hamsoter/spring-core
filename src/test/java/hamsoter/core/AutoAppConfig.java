package hamsoter.core;

import hamsoter.core.member.MemberRepository;
import hamsoter.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 탐색 위치, 기본 스캔 대상
        basePackages = "hamsoter.core.member", // 멤버만 컴포넌트 스캔의 대상이 된다,
        // annotaion 중, Configuration 인 컴포넌트는 필터로 걸러버리고 스캔하지 않는다는 의미
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    };
}
