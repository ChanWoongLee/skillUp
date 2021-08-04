package com.example.prj.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
