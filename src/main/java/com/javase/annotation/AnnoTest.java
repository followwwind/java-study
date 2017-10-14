package com.javase.annotation;

@MyAnno("val")
public class AnnoTest {

    public static void main(String[] args) {
        MyAnno anno = AnnoTest.class.getAnnotation(MyAnno.class);
        System.out.println(anno.value());

    }
}
