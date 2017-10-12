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
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
		greeter.accept(new Person("Luke", 18));
		
		
		Person p1 = new Person("follow", 21);
		Person p2 = new Person("followwwind", 27);

		p1 = updatePerson(p1, 
				p -> "follow".equals(p.getName()),
				p -> p.setName("hello"));
		p2 = updatePerson(p2, 
				p -> "follow".equals(p.getName()),
				p -> p.setName("hello"));
		System.out.println(p1.getName());
		System.out.println(p2.getName());
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


