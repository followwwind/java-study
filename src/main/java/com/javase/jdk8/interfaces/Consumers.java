package com.javase.jdk8.interfaces;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Consumer代表了在一个输入参数上需要进行的操作。
 * @author 
 *
 */
public class Consumers {
	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());   
		greeter.accept(new Person("Luke", "Skywalker"));  
		
		
		Person p1 = new Person("follow", "wind");
		Person p2 = new Person("followwwind", "mi");
		System.out.println(p1.getFirstName());
		System.out.println(p2.getFirstName());
		p1 = updatePerson(p1, 
				p -> "follow".equals(p.getFirstName()), 
				p -> p.setFirstName("hello"));
		p2 = updatePerson(p2, 
				p -> "follow".equals(p.getFirstName()), 
				p -> p.setFirstName("hello"));
		System.out.println(p1.getFirstName()); 
		System.out.println(p2.getFirstName());
	}
	
	public static Person updatePerson(Person p, Predicate<Person> predicate, Consumer<Person> consumer){
        //Use the predicate to decide when to update the discount.
        if ( predicate.test(p)){

            //Use the consumer to update the discount value.
            consumer.accept(p);
        }
        return p;

    }
}


