package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);
//            createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);
//            findCoursesForInstructor(appDAO);
//            findCoursesForInstructorJoinFetch(appDAO);
//            updateInstructor(appDAO);
//            updateCourse(appDAO);
//            deleteInstructor(appDAO);
//            deleteCourse(appDAO);
//            createCourseAndReviews(appDAO);
//            retrieveCourseAndReviews(appDAO);
//            deleteCourseAndReviews(appDAO);
//            createCourseAndStudents(appDAO);
//            findCourseAndStudents(appDAO);
//            findStudentsAndCourses(appDAO);
//            addMoreCoursesForStudent(appDAO);
//            deleteCourse(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteStudentById(id);
        System.out.println("done");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        // create more courses
        Course course1 = new Course("Rubik's Cube - How to Speed Cube?");
        Course course2 = new Course("Atari 2600 - Game Development");

        // add courses to student
        student.addCourse(course1);
        student.addCourse(course2);

        appDAO.update(student);
    }

    private void findStudentsAndCourses(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        System.out.println(student);
        System.out.println(student.getCourses());
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndStudentsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getStudents());
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        // create course
        Course course = new Course("Pacman - How to Score One Million Points");

        // create students
        Student student1 = new Student("John", "Doe", "john@luv2code.com");
        Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

        // add students to course
        course.addStudent(student1);
        course.addStudent(student2);

        // save course and associated students
        appDAO.save(course);
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        appDAO.deleteCourseById(id);
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        // create a course
        Course course = new Course("Pacman - How to Score One Million Points");

        course.addReview(new Review("Great Course ... loved it"));
        course.addReview(new Review("Cool course, job well done."));
        course.addReview(new Review("What a dumb course, you are an idiot!"));

        appDAO.save(course);
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 10;
        appDAO.deleteCourseById(id);
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseById(id);
        course.setTitle("Enjoy the Simple Things");
        appDAO.update(course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Find instructor id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);

        // update instructor
        instructor.setLastName("TEMP");

        appDAO.update(instructor);
        System.out.println("done");
    }

    private void findCoursesForInstructorJoinFetch(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());
        System.out.println(instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        List<Course> courses = appDAO.findCoursesByInstructorId(id);

        // associate the objects
        instructor.setCourses(courses);
        System.out.println(instructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor instructor = new Instructor("Susan", "Public", "susan@luv2code.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.susan.com/youtube", "Video Games");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // create some courses
        Course course1 = new Course("Air Guitar - The Ultimate Guide");
        Course course2 = new Course("The Pinball Masterclass");

        instructor.add(course1);
        instructor.add(course2);

        // save the instructor
        // NOTE: this was ALSO save the courses because of CascadeType.Persist
        System.out.println("Saving instructor: " + instructor);
        System.out.println("The courses: " + instructor.getCourses());
        appDAO.save(instructor);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteInstructorDetailById(id);
        System.out.println("Done");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        // get the instructor detail object
        int id = 2;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

        // print the instructor detail
        System.out.println(instructorDetail);

        // print the associated instructor
        System.out.println("the associated instructor: " + instructorDetail.getInstructor());
    }

    private void createInstructor(AppDAO appDAO) {
        // create the instructor
        Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.madhu.com/youtube", "Guitar");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        System.out.println(instructor);
        appDAO.save(instructor);
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorById(id);
    }
}
