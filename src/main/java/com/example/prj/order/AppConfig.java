package com.example.prj.order;

import com.example.prj.Member.MemberService;
import com.example.prj.Member.MemberServiceImpl;
import com.example.prj.Member.MemoryMemberRepository;
import com.example.prj.discount.FixDiscountPolicy;

//실데 동작에 필요한 구현객체를 생성한다.
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
