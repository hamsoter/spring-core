package hamsoter.core;

import hamsoter.core.member.Grade;
import hamsoter.core.member.Member;
import hamsoter.core.member.MemberService;
import hamsoter.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "냐무", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }
}
