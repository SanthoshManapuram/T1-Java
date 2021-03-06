package com.cts.training.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.training.repository.Student;
import com.cts.training.repository.StudentRepository;

public class StreamsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = StudentRepository.getStudents();
		
		Predicate<Student> gpaPredicate = (student) -> student.getGpa() > 3.5;
		Predicate<Student> gradePredicate = (student) -> student.getGrade() == 4;
		Function<Student, String> transformToName = (student) -> student.getName();
		
		// with lambda injected directly
		/*List<String>  names = students.stream() // placing records on belt
				.filter((student) -> student.getGpa() > 3.5) // person filters out record
				.filter((student) -> student.getGrade() == 4) // person filters out record
				.map((student) -> student.getName()) // person transforms data
				.collect(Collectors.toList()); // */
		
		
		// Stream<Student> studentStream =  students.stream();
		// studentStream.filter(null).filter(null).map(null);
		/*List<String>  names = students.stream().peek((student) -> System.out.println("On Belt : " + student)) // placing records on belt
				.filter(gpaPredicate).peek((student) -> System.out.println("After First Filter : " + student)) // person filters out record
				.filter(gradePredicate).peek((student) -> System.out.println("After Second Filter : " + student)) // person filters out record
				.map(transformToName).peek((name) -> System.out.println("After Transformation : " + name)) // person transforms data
				.collect(Collectors.toList()); // person collect the final data of belt as List*/
		
		
		/*System.out.println("Without Terminal Activity...");
		
		students.stream().peek((student) -> System.out.println("On Belt : " + student)) // placing records on belt
				.filter(gpaPredicate).peek((student) -> System.out.println("After First Filter : " + student)) // person filters out record
				.filter(gradePredicate).peek((student) -> System.out.println("After Second Filter : " + student)) // person filters out record
				.map(transformToName).peek((name) -> System.out.println("After Transformation : " + name)); // person transforms data
				*/

		
		// Parallel Stream
		List<String>  names = students.parallelStream().peek((student) -> System.out.println("On Belt : " + student)) // placing records on belt
				.filter(gpaPredicate).peek((student) -> System.out.println("After First Filter : " + student)) // person filters out record
				.filter(gradePredicate).peek((student) -> System.out.println("After Second Filter : " + student)) // person filters out record
				.map(transformToName).peek((name) -> System.out.println("After Transformation : " + name)) // person transforms data
				.collect(Collectors.toList());
		
		 		System.out.println("NAMES :" + names);
	}

}
