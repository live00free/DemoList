package cn.single;

/**
 * 单例模式：懒汉式，线程安全
 * @author Administrator
 *
 */
public class SingleOb2 {
	private static SingleOb2 single;
	
	private SingleOb2() {}
	
	public static synchronized SingleOb2 getSingle() {
		if(single==null) {
			single=new SingleOb2();
		}
		return single;
	}
}
