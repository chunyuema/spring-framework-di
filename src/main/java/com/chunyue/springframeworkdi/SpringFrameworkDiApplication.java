package com.chunyue.springframeworkdi;

import com.chunyue.springframeworkdi.config.SpringFrameworkConfig;
import com.chunyue.springframeworkdi.controllers.*;
import com.chunyue.springframeworkdi.datasource.MockDataSource;
import com.chunyue.springframeworkdi.services.PrototypeBean;
import com.chunyue.springframeworkdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// This can be removed as now we bring in the pet services into the configuration
//@ComponentScan(basePackages = {"com.chunyue.springframeworkdi", "com.chunyue.pets"})
@SpringBootApplication
public class SpringFrameworkDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringFrameworkDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("------The best pet is: ");
		System.out.println(petController.whichPetIsBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("-----Primary Bean");
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());

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

		System.out.println("------Bean Scope--------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());


		MockDataSource mockDataSource = ctx.getBean(MockDataSource.class);
		System.out.println(mockDataSource.getUsername());
		System.out.println(mockDataSource.getPassword());
		System.out.println(mockDataSource.getJdbcurl());

		System.out.println("------- Config Prop Bean -------");
		SpringFrameworkConfig springFrameworkConfig = ctx.getBean(SpringFrameworkConfig.class);
		System.out.println(springFrameworkConfig.getUsername());
		System.out.println(springFrameworkConfig.getPassword());
		System.out.println(springFrameworkConfig.getJdbcurl());
	}

}
