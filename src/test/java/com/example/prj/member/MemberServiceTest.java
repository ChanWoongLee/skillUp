package com.example.prj.member;

import com.example.prj.Member.Grade;
import com.example.prj.Member.Member;
import com.example.prj.Member.MemberService;
import com.example.prj.Member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member finMember1 = memberService.finMember(1L);

        //then
        Assertions.assertEquals(member,finMember1);

    }

}
