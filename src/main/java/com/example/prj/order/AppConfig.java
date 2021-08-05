package com.example.prj.order;

import com.example.prj.Member.MemberService;
import com.example.prj.Member.MemberServiceImpl;
import com.example.prj.Member.MemoryMemberRepository;
import com.example.prj.discount.DiscountPolicy;
import com.example.prj.discount.FixDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//실데 동작에 필요한 구현객체를 생성한다.
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
