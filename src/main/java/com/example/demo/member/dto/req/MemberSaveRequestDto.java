package com.example.demo.member.dto.req;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.member.constant.GenderType;
import com.example.demo.member.constant.MemberStatus;
import com.example.demo.member.domain.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel(value = "회원 정보 저장 dto", description = "아아디, 이름, 이메일, 휴대폰, 주소, 성별, 생일을 가진 Domain Class")
@Builder
@Getter
public class MemberSaveRequestDto {

	@ApiModelProperty(value = "사용자 아이디", required = true)
	@NotBlank(message = "아이디를 작성해주세요.")
	private String userId;

	@ApiModelProperty(value = "사용자 비밀번호", required = true)
	@NotBlank(message = "비밀번호를 작성해주세요.")
	private String password;

	@ApiModelProperty(value = "이름", required = true)
	@NotBlank(message = "이름을 작성해주세요.")
	private String name;

	@ApiModelProperty(value = "이메일", required = true)
	@NotBlank(message = "이메일을 작성해주세요.")
	@Email(message = "메일의 양식을 지켜주세요.")
	private String email;

	@ApiModelProperty(value = "휴대폰 번호", required = true)
	@NotBlank(message = "휴대폰번호를 작성해주세요.")
	// @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
	private String phoneNumber;

	@ApiModelProperty(value = "주소", required = true)
	@NotBlank(message = "주소를 작성해주세요.")
	private String address;

	@ApiModelProperty(value = "성별", required = true)
	@NotNull(message = "성별을 선택해주세요.")
	private GenderType gender;

	@ApiModelProperty(value = "생일")
	@JsonFormat(pattern = "yyyyMMdd")
	private String birthday;

	public Member toEntity() {
		return Member.builder()
			.userId(userId)
			.name(name)
			.password(password)
			.email(email)
			.phoneNumber(phoneNumber)
			.address(address)
			.gender(gender)
			.birthday(birthday)
			.status(MemberStatus.ACTIVE)
			.build();
	}
}
