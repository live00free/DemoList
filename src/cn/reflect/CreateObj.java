package cn.reflect;

import java.lang.reflect.Constructor;

/**
 * 获取构造方法创建对象
 * @author bioknow
 *
 */
public class CreateObj {
	public static void main(String[] args) {
		try {
			Class c=Class.forName("cn.entity.Person");
			Constructor con=c.getConstructor();
			Object obj=con.newInstance();
			System.out.println(obj);
			
			Constructor con2=c.getConstructor(String.class,int.class,String.class);
			Object obj2=con2.newInstance("xiaohong",15,"beijing");
			System.out.println(obj2);
			
			Constructor con3=c.getDeclaredConstructor(String.class);
			con3.setAccessible(true);
			Object obj3=con3.newInstance("xiaoli");
			System.out.println(obj3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
