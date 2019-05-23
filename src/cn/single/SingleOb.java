package cn.single;

/**
 * 单例模式，懒汉式
 * @author Administrator
 *
 */
public class SingleOb {
	private static SingleOb single;
	
	private SingleOb() {}
	
	public static SingleOb getSingleOb() {
		if(single==null) {
			single= new SingleOb();
		}
		return single;
	}
	
	public static void SayHello() {
		System.out.println("Hello");
	}
}
