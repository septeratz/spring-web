package edu.fisa.ce.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Emp2 { // ? table이 소문자명으로 자동으로 만들어지는지 확인 - 확인됨. 소문자로 나옴
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql 전용 auto_increment 설정
	private Integer empno;
	private String ename;
	private float sal;
	private int deptno;
}
