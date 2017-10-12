package com.javase.jdk8.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator接口在早期的Java 版本中非常著名。Java 8 为这个接口添加了不同的默认方法。
 * @author 
 *
 */
public class Comparators {

	public static void main(String[] args) {
		//可以简化成如下方式
//		Comparator<Person> comparator2 = (p1, p2) -> p1.getAge().compareTo(p2.getAge());

		Comparator<Person> comparator = Comparator.comparing(Person::getAge);
		Person pp1 = new Person("John", 18);
		Person pp2 = new Person("Alice", 20);
		
		
		    
		int c1 = comparator.compare(pp1, pp2);             // > 0   
		int c2 = comparator.reversed().compare(pp1, pp2);  // < 0  
		System.out.println("c1:" + c1 + "," + "c2:" + c2);
		
		
		List<Person> persons = Arrays.asList(pp1, pp2);
		
		Collections.sort(persons, comparator);
		persons.forEach(p -> System.out.print(p.getAge() + "\t"));
		System.out.println();
		Collections.sort(persons, (p1, p2) -> {
			int age = p2.getAge() - p1.getAge();
			return age > 0 ? 1 : (age == 0 ? 0 : -1);
		});
		persons.forEach(p -> System.out.print(p.getAge() + "\t"));

	}
}

