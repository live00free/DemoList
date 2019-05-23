package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 反射设置成员变量
 * @author bioknow
 *
 */
public class VariableSet {
	public static void main(String[] args) {
		try {
			Class pc=Class.forName("cn.entity.Person");
			Constructor con = pc.getConstructor();
			Object obj=con.newInstance();
			Field addField=pc.getField("address");
			addField.set(obj, "beijing");
			System.out.println(obj);
			
			Field ageField=pc.getDeclaredField("age");
			ageField.setAccessible(true);
			ageField.set(obj, 16);
			System.out.println(obj);
			
			Field nameField=pc.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(obj, "xiaohong");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
