package edu.fisa.ce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.fisa.ce.model.entity.Emp2;


@Repository
public interface Emp2Repository extends JpaRepository<Emp2, Integer>{

	public Emp2 findByEname(String ename);
	
	
	@Query("select e.ename, e.sal from Emp2 e where e.deptno=:deptno")
	public List<Object[]> findByDeptno(@Param("deptno") int deptno);
		
	
	@Modifying
	@Query("update Emp2 e set e.deptno=:deptno where e.empno=:empno")
	public int updateByEmpnoDeptno(@Param("empno") int empno, 
								   @Param("deptno") int deptno);
}
