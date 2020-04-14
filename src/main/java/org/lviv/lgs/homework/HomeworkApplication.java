package org.lviv.lgs.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HomeworkApplication.class, args);

		UniversityService universityService = (UniversityService) applicationContext.getBean("universityService");

		University university = University.builder()
				.setName("university")
				.setAccreditationLevel(2)
				.setNumberOfStudents(321)
				.setAddress("address")
				.build();

		University university2 = University.builder()
				.setName("university2")
				.setAccreditationLevel(5)
				.setNumberOfStudents(500)
				.setAddress("address2")
				.build();

		University university3 = University.builder()
				.setName("university3")
				.setAccreditationLevel(7)
				.setNumberOfStudents(241)
				.setAddress("address3")
				.build();

		universityService.save(university);
		universityService.save(university2);
		universityService.save(university3);

		System.out.println("=================================================================================");
		University find = universityService.findById(1);
		System.out.println(find);
		System.out.println("=================================================================================");

		System.out.println("=================================================================================");
		List<University> universities = universityService.findAll();
		System.out.println("=================================================================================");

		System.out.println("=================================================================================");
		universityService.deleteById(5);
		List<University> universities1 = universityService.findAll();
		System.out.println(universities1);
		System.out.println("=================================================================================");

		System.out.println("=================================================================================");
		University newUniversity3 = University.builder()
				.setName("university3")
				.setAccreditationLevel(10)
				.setNumberOfStudents(800)
				.setAddress("address3")
				.build();
		universityService.update(8, newUniversity3);

		University find1 = universityService.findById(8);
		System.out.println(find1);
		System.out.println("=================================================================================");
	}

}
