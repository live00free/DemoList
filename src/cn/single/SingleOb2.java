package cn.single;

/**
 * ����ģʽ������ʽ���̰߳�ȫ
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
