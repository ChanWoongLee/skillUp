package com.example.prj.discount;

import com.example.prj.Member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
