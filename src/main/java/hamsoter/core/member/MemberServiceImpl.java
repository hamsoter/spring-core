package hamsoter.core.member;

public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        Member result = memberRepository.findById(memberId);
        return result;
    }
}
