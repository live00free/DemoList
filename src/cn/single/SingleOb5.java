package cn.single;

/**
 * ����ģʽ����̬�ڲ���
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
