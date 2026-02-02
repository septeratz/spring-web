package edu.fisa.ce.model.domain;

import org.springframework.stereotype.Component;

@Component  //spring bean으로 등록
public class Engine {
	private String engineName = "그랜저 엔진";
	
	public Engine() {
		System.out.println("Engine 생성자");
	}

	public String getEngineName() {
		System.out.println("Engine getEngineName()");
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
		System.out.println("Engine setEngineName()");
	}	
	
}