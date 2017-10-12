package com.javase.jdk8.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * 函数式接口
 * predicates是一个布尔类型的函数，该函数只有一个输入参数。predicate接口包含了多种默认方法，用于处理复杂的逻辑动词(and or negate)
 * @author 
 *
 */
public class Predicates {
	
	public static void collectPre(){
		Collection<String> c = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 加入0 ~ 9的字符串  
            c.add(String.valueOf(i));  
        }  
         
        /*Predicate<String> predicate = new Predicate<String>() {		
			@Override
			public boolean test(String t) {
				return Integer.valueOf(t) > 3;
			}
		};*/
		
		Predicate<String> p2 = ele -> Integer.valueOf(ele) > 3;
		p2.and(ele -> Integer.valueOf(ele) < 8);
		
        for (String ele: c) {  
            if (p2.test(ele)) {  
                System.out.print(ele + "\t");  
            }  
        }  
        System.out.println();
        
	}
	
	public static void collectPre2(){
		Collection<String> c = new ArrayList<String>();  
        for (int i = 0; i < 10; i++) { // 加入0 ~ 9的字符串  
            c.add(String.valueOf(i));  
        }  
        
        operate(c, ele -> Integer.valueOf((String)ele) > 5); // 大于3的打印出来
	}
	
	public static void operate(Collection<String> c, Predicate<String> p) { // 满足谓词条件p的元素都打印出来  
        for (String ele: c) {  
            if (p.test(ele)) {  
                System.out.print(ele + "\t");  
            }  
        }  
        System.out.println();
    }  
	
	public static void collectPre3(){
		Collection<String> c = new ArrayList<String>();  
        for (int i = 0; i < 10; i++) { // 加入0 ~ 9的字符串  
            c.add(String.valueOf(i));  
        }  
        
        c.removeIf(ele -> Integer.valueOf(ele) > 7);
        
        c.forEach(ele -> System.out.print(ele + "\t"));
	}
	
	
	public static void main(String[] args) {  
		collectPre();
		//collectPre2();
		//collectPre3();
    }  
}
