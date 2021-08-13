package com.example.demo.user.dto.req;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.user.constant.GenderType;
import com.example.demo.user.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(value = "회원정보", description = "아아디, 이름, 이메일, 휴대폰, 주소, 성별, 생일을 가진 Domain Class")
@Builder
@Getter
public class UserSaveRequestDto {

	@ApiModelProperty(value = "사용자 아이디", required = true)
	@NotBlank(message = "아이디를 작성해주세요.")
	private String userId;

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
	// @DateTimeFormat(pattern = "yyyyMMdd")
	// @PastOrPresent
	@JsonFormat(pattern = "yyyyMMdd")
	private String birthday;

	public User toEntity() {
		return User.builder()
			.userId(userId)
			.name(name)
			.email(email)
			.phoneNumber(phoneNumber)
			.address(address)
			.gender(gender)
			.birthday(birthday)
			.build();
	}
}
