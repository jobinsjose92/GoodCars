package com.ourproject.GoodCars;

import com.ourproject.GoodCars.Controller.AddCarsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class GoodCarsApplication {



	public static void main(String[] args) {
		new File(AddCarsController.uploadDirectory).mkdir();

		SpringApplication.run(GoodCarsApplication.class, args);
	}

}
