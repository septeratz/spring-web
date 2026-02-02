package edu.fisa.ce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fisa.ce.model.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
    // JpaRepository를 상속받으면 findAll(), save() 등이 자동으로 생성됩니다.
    // 아무것도 안 적어도 됩니다!
}