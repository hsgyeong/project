package com.project.boardback.dto.request.auth;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {

    // NotBlank, NotEmpty -> 문자열에서만 사용 가능 / NotNull -> 참조형 변수에서 모두 사용 가능
    
    @NotBlank // 문자열에서 null이 아니고, 빈 문자열이 아니어야 하고, 공백으로만 이루어 진 것이 아니어야 함.
    @Email
    private String email;

    @NotBlank
    @Size(min=8, max=20)
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank
    @Pattern(regexp="^[0-9]{11,13}$") // 0-9의 숫자, 11~13의 길이
    private String telNumber;

    @NotBlank
    private String address;

    private String addressDetail;

    @NotNull
    @AssertTrue // 반드시 true인 상태만 받음. true가 아니면 받지 않음.
    private Boolean agreedPersonal;
}
