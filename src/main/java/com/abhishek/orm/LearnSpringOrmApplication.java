package com.abhishek.orm;

import com.abhishek.orm.Services.UserService;
import com.abhishek.orm.entities.Laptop;
import com.abhishek.orm.entities.Student;
import com.abhishek.orm.entities.User;
import com.abhishek.orm.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.abhishek.orm", "com.abhishek.todo"})

public class LearnSpringOrmApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(LearnSpringOrmApplication.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(LearnSpringOrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setName("Ankit");
//        user.setCity("Delhi");
//        user.setAge(21);
//        User user1 = userService.saveUser(user);
//        logger.info("User1 details:{}", user1);

        //get single user
//        List<User> users = userService.getAllUser();
//        logger.info("Users details:{}", users);
//        logger.info("Users size:{}", users.size());

//        User user = userService.getUser(2);
//        logger.info("User detatil:{}", user);
//        User user = new User();
//        user.setName("Ankit Tiwari");
//        user.setCity("Ambala");
//        user.setAge(45);
//        User updatedUser = userService.updateUser(user, 1);
//        logger.info("Updated user details:{}", updatedUser);
        //       userService.deleteUser(2);
//        Student student = new Student();
//        student.setStudentId(23);
//        student.setStudentName("Tejas");
//        student.setAbout("Boy Handsome");
//
//        Laptop laptop = new Laptop();
//        laptop.setBrand("HP");
//        laptop.setLaptopId(23);
//        laptop.setModelNumber("abc56");
//
//
//        laptop.setStudent(student);
//
//
//        student.setLaptop(laptop);
//
//        Student save = studentRepository.save(student);
//        logger.info("saved student:{}", save.getStudentName());

        Student student = studentRepository.findById(23).get();
        logger.info("Name is {}:", student.getStudentName());

        Laptop laptop = student.getLaptop();
        logger.info("Laptop  {},{}", laptop.getBrand(), laptop.getModelNumber());

    }
}
