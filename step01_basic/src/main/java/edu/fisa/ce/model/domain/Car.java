package edu.fisa.ce.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {
	private String carName = "그렌져";
	
	@Autowired
	private Engine carEngine;
	
	public Car() {
		System.out.println("Car 생성자");
	}

	public String getCarName() {
		System.out.println("Car getCarName");
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
		System.out.println("Car setCarName");
	}

	public Engine getCarEngine() {
		System.out.println("Car getCarEngine");
		return carEngine;
	}

	public void setCarEngine(Engine carEngine) {
		System.out.println("Car setCarEngine");
		this.carEngine = carEngine;
	}
	
	
	
}