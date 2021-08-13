package com.example.demo.user.dto.req;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.user.constant.GenderType;
import com.example.demo.user.constant.UserStatus;
import com.example.demo.user.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel(value = "회원정보", description = "아아디, 이름, 이메일, 휴대폰, 주소, 성별, 생일을 가진 Domain Class")
@Builder
@Getter
public class UserUpdateRequestDto {

	@ApiModelProperty(value = "사용자 고유 아이디", required = true)
	@NotBlank(message = "아이디값은 필수입니다.")
	private long id;

	@ApiModelProperty(value = "이메일", required = true)
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

	@ApiModelProperty(value = "사용자 상태")
	private UserStatus status;

	public User toEntity() {
		return User.builder()
			.id(id)
			.email(email)
			.phoneNumber(phoneNumber)
			.address(address)
			.gender(gender)
			.birthday(birthday)
			.status(status)
			.build();
	}
}
