package hamsoter.core.order;

import hamsoter.core.discount.DiscountPolicy;
import hamsoter.core.discount.FixDiscountPolicy;
import hamsoter.core.member.Member;
import hamsoter.core.member.MemberRepository;
import hamsoter.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member, itemPrice);

            return new Order(memberId, itemName, itemPrice, discountPrice);
        }
}
