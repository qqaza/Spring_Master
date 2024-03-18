package com.example.demo.emp;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo { //등록VO
	 int employeeId;
	 String firstName;
	 String lastName;
	 String email;
	 @DateTimeFormat(pattern = "yyyy-MM-dd") //입력받을때 String -> Dare
	 @JsonFormat(pattern = "yyyy-MM-dd") // 출력 Date -> String
	 Date hireDate;
	 Integer salary;
	 String jobId;
	 @JsonProperty(value="deptId") String departmentId; //이름 바꾸기
	 @JsonIgnore String managerId; // 안보이게 하기
	 @JsonIgnore String phone;     // 안보이게 하기
	 
}
