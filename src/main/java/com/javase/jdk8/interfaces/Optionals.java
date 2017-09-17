package com.javase.jdk8.interfaces;

import java.util.Optional;

/**
 * Optional不是一个函数式接口，而是一个精巧的工具接口，用 NullPointerEception产生。这
 * 个概念在下一节会显得很重要，所以我们在这里快速地浏览一下Optional的工作原理。 
 * Optional是一个简单的值容器，这个值可以是null，也可以是non-null。考虑到一个方法可能会返
 * 回一个non-null的值，也可能返回一个空值。为了不直接返回 null，我们在 Java 8中就返回一个Optional. 
 * @author
 *
 */
public class Optionals {
	public static void main(String[] args) {
		
		Optional<String> optional = Optional.of("bam");    
		optional.isPresent();           // true   
		optional.get();                 // "bam"   
		optional.orElse("fallback");    // "bam"   
		    
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b" 
	}
}
