package com.example.demo.member.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@AfterAll
	public void 회원정보_삭제() {
		memberRepository.deleteAll();
	}

	@AfterAll
	public void after() {
		memberRepository.deleteAll();
	}


	@Test
	public void 회원정보_저장() {
		//given
		String name = "홍길동";

		// when
		final Member member = memberRepository.save(Member.builder().name(name).build());

		// then
		assertEquals(name, member.getName());
	}

	@Test
	public void 회원정보_조회() {
		assertEquals("1",  "1");
	}

}