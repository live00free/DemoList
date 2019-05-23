package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射调用成员方法
 * @author bioknow
 *
 */
public class MethodUse {
	public static void main(String[] args) {
		try {
			Class pc=Class.forName("cn.entity.Person");
			Constructor con=pc.getConstructor();
			Object obj=con.newInstance();
			Method m1=pc.getMethod("show");
			m1.invoke(obj);
			
			Method m2=pc.getMethod("method", String.class);
			m2.invoke(obj, "hello");
			
			Method m3=pc.getMethod("getString", String.class,int.class);
			Object ob=m3.invoke(obj, "hello",28);
			System.out.println(ob);
			
			Method m4=pc.getDeclaredMethod("function");
			m4.setAccessible(true);
			m4.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
