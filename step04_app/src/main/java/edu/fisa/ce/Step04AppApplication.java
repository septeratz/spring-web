package edu.fisa.ce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Step04AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step04AppApplication.class, args);
	}

}

/* 미션
1. 소스별 기능 확인, 사고하기
2. step03에서의 세션 기능을 적용하여 로그인된 자에 한해서만 모든 부서 정보 보기
3. jsp로 모든 부서 출력하기
4. index.html로 로그인 후 부서 정보 요청하는 로직 추가 구현하기
5. 참고
	- ai 충분히 활용 및 비교
 */