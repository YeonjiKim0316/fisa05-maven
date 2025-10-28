package org.example.dbConn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept { // 테이블명과 같은 이름으로 클래스명을 작성합니다. 클래스명이므로 앞글자는 대문자
    int deptno; // 컬렴명과 일치하는 필드명 작성
    String dname;
    String loc; 
}
