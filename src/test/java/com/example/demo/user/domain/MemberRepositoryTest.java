package com.example.demo.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.member.constant.GenderType;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;


	@AfterAll
	public void 회원정보_삭제() {
		// userRepository.deleteAll();
	}

	@Test
	public void 회원정보_수정() {
		String userId = "test";
		String name = "홍길동";
		String email = "chlgusdn3@naver.com";
		String phoneNumber = "010-1111-2222";
		String address = "서울시";
		GenderType gender =  GenderType.MALE;
		String birthday = "19901015";

		Member member = memberRepository.save(Member.builder()
			.userId(userId)
			.name(name)
			.email(email)
			.phoneNumber(phoneNumber)
			.address(address)
			.gender(gender)
			.birthday(birthday)
			.build());

		String changeName = "최현우";
		Member member2 = memberRepository.save(Member.builder()
			.id(member.getId())
			.name(changeName)
			.build());

		List<Member> memberList = memberRepository.findAll();

		assertEquals(1, memberList.size());
		assertEquals(changeName, memberList.get(0).getName());
	}
}