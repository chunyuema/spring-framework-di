package com.chunyue.springframeworkdi;

import com.chunyue.springframeworkdi.controllers.ConstructorInjectedController;
import com.chunyue.springframeworkdi.controllers.MyController;
import com.chunyue.springframeworkdi.controllers.PropertyInjectedController;
import com.chunyue.springframeworkdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFrameworkDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringFrameworkDiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("-----Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());


		System.out.println("-----Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean(
				"setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());


		System.out.println("------Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean(
				"constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
