package com.example.demo.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByEmail(String email);

	Member findByUserId(String userId);

}
