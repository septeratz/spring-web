package edu.fisa.ce.controller;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fisa.ce.model.domain.Car;

@RestController
public class TestController {
	
	@Autowired
	private ObjectProvider<Car> carProvider;
	
	@GetMapping("carinfo")
	public Car getCar() {
		Car car = carProvider.getObject();
		System.out.println("*****" + carProvider);
		return car;
	}

}
