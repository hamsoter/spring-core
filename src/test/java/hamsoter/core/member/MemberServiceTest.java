package hamsoter.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member1 = new Member(1L, "냐무", Grade.VIP);

        // when
        memberService.join(member1);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member1).isEqualTo(findMember);
    }
}
