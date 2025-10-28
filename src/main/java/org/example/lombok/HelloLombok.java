package org.example.lombok;

import lombok.*;


//@Getter
//@Setter
//@ToString // 특정 객체를 조회할 때 모든 변수에 대해 ToString으로 출력
////@NoArgsConstructor // 빈 생성자를 하나 만들어서 넣어줍니다.
//@RequiredArgsConstructor // NoArgs와 위배되므로 둘 중에서 하나만 사용 가능
//@AllArgsConstructor // 모든 필드를 채워넣으며 객체를 만드는 생성자
@NoArgsConstructor
@AllArgsConstructor
@Data // Getter, Setter, ToString, RequiredArgConstructor, equals, hashcode를 모두 만들어주는 생성자
public class HelloLombok {

    int num;
    String name;
    
    @ToString.Exclude // ToString에서 제외
    String ssn; // 상수처럼 처음 넣은 값을 절대 바꾸지 않는 변수 - 초기값으로 무조건 받고, 변경을 하지 않을 변수

//    public HelloLombok(int num, String name, String ssn) {
//        this.num = num;
//        this.name = name;
//        this.ssn = ssn;
//    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
