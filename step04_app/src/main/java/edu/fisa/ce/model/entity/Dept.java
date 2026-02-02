package edu.fisa.ce.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "dept") // DB 테이블 이름이 'dept'라고 명시
public class Dept {
    
    @Id // PK 설정
    private int deptno;
    
    private String dname;
    private String loc;
}