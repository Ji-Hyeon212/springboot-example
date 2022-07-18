package com.example.springboot.domain;

import com.example.springboot.domain.member.Member;
import com.example.springboot.domain.member.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanup(){
        memberRepository.deleteAll();
    }

    @Test
    public void setMemberRepository(){
        String memberName = "ㅇㅇㅇ";
        String memberNickName = "ddd";

        memberRepository.save(Member.builder()
                .memberName(memberName)
                .memberNickName(memberNickName)
                .build());
        List<Member> memberList = memberRepository.findAll();

        //assertEquals

    }
}
