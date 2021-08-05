package com.example.prj.order;

import com.example.prj.Member.Member;
import com.example.prj.Member.MemberRepository;
import com.example.prj.Member.MemoryMemberRepository;
import com.example.prj.discount.DiscountPolicy;
import com.example.prj.discount.FixDiscountPolicy;
import com.example.prj.discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 구현객체의 연결과 설정을 위한 다른 설정을 만들ㅈ다!!

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
