package cn.single;

/**
 * ����ģʽ������ʽ
 * @author Administrator
 *
 */
public class SingleOb3 {
	private static SingleOb3 single=new SingleOb3();
	
	private SingleOb3() {}
	
	public static SingleOb3 getSingle() {
		return single;
	}
}
