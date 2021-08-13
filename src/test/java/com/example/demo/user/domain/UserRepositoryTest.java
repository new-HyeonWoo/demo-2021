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

import com.example.demo.user.constant.GenderType;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;


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

		User user = userRepository.save(User.builder()
			.userId(userId)
			.name(name)
			.email(email)
			.phoneNumber(phoneNumber)
			.address(address)
			.gender(gender)
			.birthday(birthday)
			.build());

		String changeName = "최현우";
		User user2 = userRepository.save(User.builder()
			.id(user.getId())
			.name(changeName)
			.build());

		List<User> userList = userRepository.findAll();

		assertEquals(1, userList.size());
		assertEquals(changeName, userList.get(0).getName());

	}



}