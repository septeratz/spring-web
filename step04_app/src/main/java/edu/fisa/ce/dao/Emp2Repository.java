package edu.fisa.ce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.fisa.ce.model.entity.Emp2;

/* Spring Data JPA
 * 
 * @Repository - 의미만 DAO, 기능은 @Component (spring bean)
 * 개발자 관점
 * - 개발이 쉬움: 추상화
 * - 어떤 table(entity, pk타입) 세팅
 * 
 * JpaRepository: crud 기본 메소드 다 제공, 내부적으로는 구현체로 구동
 */

@Repository
public interface Emp2Repository extends JpaRepository<Emp2, Integer>{
	
	/* 지원받는 sql 처리 메소드의 부족으로 인해 개발자가 선언하여 sql을 생성하거나 관리를 위임시킴
	 * rule: 관련된 entity는 Emp2
	 * findByEname
	 * 	find - select / by - where / Ename 기준 컬럼값
	 * select * from emp2 where ename="" 
	 * 
	 */
	public Emp2 findByEname(String ename);
	
	/* sql 문장을 직접 생성하는 기능
	 * @Query: 사용자 정의 쿼리 생성
	 * ename과 sal만 검색하고 싶은데 이런 메소드가 없음
	 * 방법 1: findByEnameAndSal() 작성
	 * 방법 2: sql 문장 작성
	 * 	순수 정통 db의 sql문장
	 * 	entity 기반의 java sql문장(선택)
	 * 		e.ename, e.sal: 멤버 변수명
	 * 		Emp2: Entity명
	 * 			deptno: bind된 변수로 간주함 / @Param("deptno") 동일한 이름
	 * 
	 * select e.ename, e.sal from emp2 e where e.deptno=:deptno 에러
	 * select e.ename, e.sal from Emp2 e where e.deptno=:deptno 정상
	 * 
	 * ? findByDeptno
	 * 	select * from emp2 where deptno=?;
	 * 
	 * ? 질문
	 * 	- Query가 선언된 해당 메소드명은 자유롭게 선언해도 되는가? find로 해야만 하는가?
	 */
	@Query("select e.ename, e.sal from Emp2 e where e.deptno=:deptno")
	public List<Object[]> findByDeptno(@Param("deptno") int deptno);
		
	/* ? 질문
	 * @Modifying의 필요성?
	 */
	@Modifying
	@Query("update Emp2 e set e.deptno=:deptno where e.empno=:empno")
	public int updateByEmpnoDeptno(@Param("empno") int empno, 
								   @Param("deptno") int deptno);
}
