package com.example.prj.dto;

import com.example.prj.annotation.Birthday;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data // hascode 나 toString까지 해줌
@Getter
@Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 인자 받는 전체 생성자
public class User {
    private String id;
    private String pw;

    @Email
    private String email;

    @Min(value = 0)
    private String age;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식과 맞지 않습니다.")
    private String phoneNumber;

    //@Birthday()
    private String birthDay;

    @AssertTrue // Custom validation을 위한 어노테이션
    // 이런식으로 하면 이런 검증하는 코드를 위해서 중복이 발생함 따라서 따로 어노테이션을 만드는게 좋음
    public boolean isReqBirthday(){
        try {
            LocalDate localDate = LocalDate.parse(this.birthDay, DateTimeFormatter.ofPattern("yyyyyMMDD"));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
