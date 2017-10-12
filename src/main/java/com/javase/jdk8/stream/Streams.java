package com.javase.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.event.ListSelectionEvent;

/**
 * java.util.Stream表示了某一种元素的序列，在这些元素上可以进行各种操作。Stream 操作可以是中
 * 间操作，也可以是完结操作。完 结操作会返回一个某种类型的值，而中间操作会返回流对象本身，并且你
 * 可以通过多次调用 StringBuffer 的append方法一样）。Stream是在一个源的基础上创建出来的，例如java.util.Collection中的list或者 set
 * （map不能作为Stream的源）。Stream 操作往往可以通过顺序或者并行两种方式来执行。 
 * @author 步步科技
 *
 */
public class Streams {
	static List<String> lists = new ArrayList<>();
	static {
		lists.add("1");
		lists.add("2");
		lists.add("3");
		lists.add("3");
		lists.add("follow");
		lists.add("wind");
		lists.add("followwwind");
	}
	
	/**
	 * 数组，集合等数据源转换成stream
	 */
	public static void baseStream() {
		System.err.println("----------------------------SourceData 转换Stream-----------------------------");
		// 1. Individual values
		Stream<String> s = Stream.of("a", "b", "c");
		// 2. Arrays
		String [] strArray = new String[] {"a", "b", "c"};
		Stream<String> arrs = Stream.of(strArray);
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		Stream<String> lists = list.stream();
		System.out.println(s);
		System.out.println(arrs);
		System.out.println(lists);
		// 4. iterate 
		Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.print(x + " "));  // 0 3 6 9 12 15 18 21 24 27
		System.out.println();
		// 5. generate
		//String[] strArr = Stream.generate(() -> "test").limit(10).toArray(String[]::new);
		String joinStr = Stream.generate(() -> "test").limit(10).collect(Collectors.joining(","));
		System.out.println(joinStr);
		// 6. From Popular APIs
		String sentence = "Program creek is a Java site.";
        Stream<String> wordStream = Pattern.compile("\\W").splitAsStream(sentence);
        String[] wordArr = wordStream.toArray(String[]::new);
        System.out.println(Arrays.toString(wordArr));
		System.err.println("----------------------------SourceData 转换Stream-----------------------------");
	}
	
	/**
	 * 中间操作(Intermediate) 转换Stream
	 */
	public static void middleStream(){
		System.err.println("----------------------------中间操作 转换Stream-----------------------------");
		
		//去除重复 distinct
		lists.stream().distinct().forEach(p -> System.out.print(p + "\t"));  //1	2	3	follow	wind	followwwind
		System.out.println();
		
		//过滤元素 filter
		lists.stream().filter(p -> p.length() > 1).forEach(p -> System.out.print(p + "\t")); //follow	wind	followwwind
		System.out.println();
		
		// sorted 流排序,中间操作返回流本身
		lists.stream().filter(str -> str.contains("w"))
		.sorted((str1, str2) -> {
			if (str1.length() == str2.length()) {
				return 0;	
			} else if (str1.length() > str2.length()) {
				return 1;
			} else {
				return -1;
			}
		}).forEach(System.out::println);  //wind follow followwwind	
		
		//limit 对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素；
		lists.stream().limit(5).forEach(p -> System.out.print(p + "\t")); //1	2	3	3	follow	
		System.out.println();
		
		//skip 返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素个数小于N，那么返回空Stream；
		lists.stream().skip(5).forEach(p -> System.out.print(p + "\t")); //wind	followwwind
		System.out.println();
		
		//peek 生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数；
		lists.stream().peek(p -> {p = p.toUpperCase(); System.out.println(p);}).forEach(System.out::println); 
		System.out.println();
		
		//转换元素 map
		lists.stream().map(p -> p + "-->").forEach(System.out::print); // 1-->2-->3-->3-->follow-->wind-->followwwind-->
		System.out.println("end");
		lists.stream().map(p -> p.split(" ")).map(p -> p[0] + "\t").forEach(System.out::print);//1	2	3	3	follow	wind	followwwind
		System.out.println();
		lists.stream().map(p -> p.split("")).map(p -> {
			String tmp = "";
			if(p.length > 1){
				tmp = p[1];
			}else{
				tmp = p[0];
			}
			return tmp + "\t";
		}).forEach(System.out::print); //1	2	3	3	o	i	o
		System.out.println();
		lists.stream().filter(p -> p.matches("\\d+")).mapToInt(p -> Integer.valueOf(p)).forEach(p -> System.out.print(p + "\t"));//1	2	3	3
		System.out.println();
		
		// flatMap 和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中
		lists.stream().flatMap(p -> Stream.of(p.split("www"))).forEach(p -> System.out.print(p + "\t"));
		//1	 2	3	3	follow	wind	follo	ind
		Stream<List<Integer>> inputStream = Stream.of(
			 Arrays.asList(1),
			 Arrays.asList(2, 3),
			 Arrays.asList(4, 5, 6)
		 );
		System.out.println();
		Stream<Integer> outputStream = inputStream.
		flatMap((childList) -> childList.stream());
		outputStream.forEach(p -> System.out.print(p + "\t")); //1	2	3	4	5	6
		System.out.println();
		System.err.println("----------------------------中间操作 转换Stream-----------------------------");
	}
	
	/**
	 * 终端操作(Terminal) Stream
	 */
	public static void endStream(){
		System.err.println("----------------------------终端操作 Terminal Stream-----------------------------");
		//forEach
		lists.stream().forEach(System.out::print);
		System.out.println();
		//match 流匹配,终结操作
		System.out.println(lists.stream().allMatch(str -> str.length() == 3));// false
		System.out.println(lists.stream().anyMatch(str -> str.length() > 5));// true
		System.out.println(lists.stream().noneMatch(str -> str.length() > 5));// false
		//count
		System.out.println(lists.stream().count());  //7
		//reduce
		Optional<String> reOptional = lists.stream().reduce((str, str2) -> str + "-->" + str2);
		reOptional.ifPresent(System.out::println); //1-->2-->3-->3-->follow-->wind-->followwwind
		lists.stream().filter(p -> p.matches("\\d+")).mapToInt(p -> Integer.valueOf(p)).reduce(Integer::sum).ifPresent(System.out::println);
		
		//collect
		List<String> ll = lists.stream().collect(Collectors.toList());
		System.out.println(ll);  //[1, 2, 3, 3, follow, wind, followwwind]
		lists.stream().collect(Collectors.maxBy((p1, p2) -> p1.compareTo(p2))).ifPresent(System.out::println); //wind
		lists.stream().collect(Collectors.minBy((p1, p2) -> p1.compareTo(p2))).ifPresent(System.out::println); //1
		int s = lists.stream().filter(p -> p.matches("\\d+")).collect(Collectors.summingInt(p -> Integer.valueOf(p)));
		System.out.println(s);  //9
		String liString = lists.stream().collect(Collectors.joining(",")); 
		System.out.println(liString);  //1,2,3,3,follow,wind,followwwind
		//sum
		int sum = lists.stream().filter(p -> p.matches("\\d+")).mapToInt(p -> Integer.valueOf(p)).sum(); //9
		System.out.println(sum);
		//findFirst
		Optional<String> firstOptional = lists.stream().findFirst();
		firstOptional.ifPresent(System.out::println);  //1
		Stream.of().findFirst().ifPresent(System.out::println); //不返回任何值
		//findAny 不一定返回第一个，而是返回任意一个,在并行流式处理中使用findAny的性能要比findFirst好
		lists.stream().findAny().ifPresent(System.out::println);
		//lists.stream().filter(p -> "3".equals(p));
		System.err.println("----------------------------终端操作 Terminal Stream-----------------------------");
	}

	public static void main(String[] args) {
		baseStream();
		//middleStream();
		//endStream();
	}
}
