package cn.reflect;

import cn.entity.Person;

/**
 * 获取Class的三种方式
 * @author bioknow
 *
 */
public class ClassGet {
	public static void main(String[] args) {
		try {
			Person p = new Person();
			Class className1 = Person.class;
			System.out.println(className1);
			Class className2 = p.getClass();
			System.out.println(className2);
			Class className3 = Class.forName("cn.entity.Person");
			System.out.println(className3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
