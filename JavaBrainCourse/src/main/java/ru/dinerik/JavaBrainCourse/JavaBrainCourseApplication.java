package ru.dinerik.JavaBrainCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaBrainCourseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(JavaBrainCourseApplication.class, args);
		run.getBeanDefinitionNames();
		//SpringApplication.run(JavaBrainCourseApplication.class, args);
	}

}
