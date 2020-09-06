package com.udemy.java.test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import compare.Student;

public class TestStudent {

	public static void main(String[] args) {
		
		Student a = new Student("Adam", 80, 150);
		Student b = new Student("Bob", 96, 123);
		Student c = new Student("Carl", 75, 135);
		
		Optional<Student> min = Stream.of(a,b,c)
		.min(Comparator.comparing(s -> s.getScore()));
		
		System.out.println(min);
		
		String test = "Rajesh\nHelloWorld\nHowAreYou";
		
	
		
   System.out.println(test);
	}

}
