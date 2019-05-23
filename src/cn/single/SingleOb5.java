package cn.single;

/**
 * 单例模式：静态内部类
 * @author Administrator
 *
 */
public class SingleOb5 {
	private static class SingleObHandle{
		private final static SingleOb5 SINGLE=new SingleOb5();
	}
	
	private SingleOb5() {}
	
	public static final SingleOb5 getSingle() {
		return SingleObHandle.SINGLE;
	}
	
}
