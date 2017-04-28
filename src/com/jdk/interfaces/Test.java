package com.jdk.interfaces;

interface A {  
    public void sayString(String str);  
  
    default public void SayInt(int i) {// 接口内默认实现，不需要子类实现，子类可以覆盖或子接口或子抽象类可以覆盖为抽象方法  
        System.out.println("sayInt--->" + i);  
    }  
}  
  
abstract class B implements A {  
    public abstract void SayInt(int i);  
}  

class C extends B {  
  
    @Override  
    public void sayString(String str) {  
        System.out.println("sayString--->" + str);  
    }  
  
    @Override  
    public void SayInt(int i) {  
        System.out.println("sayInt2--->" + i);  
    }  
  
}  

class D implements A{

	@Override
	public void sayString(String str) {
		System.out.println("D.class--->" + str);  
	}
	
}
public class Test {  
    public static void main(String[] args) {  
        C c = new C();  
        c.SayInt(21);  
        c.sayString("senssic"); 
        
        D d = new D();
        d.SayInt(18);
    }  
}  
