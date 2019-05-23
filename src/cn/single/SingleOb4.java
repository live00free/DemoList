package cn.single;

/**
 * ����ģʽ��˫��У����
 * @author Administrator
 *
 */
public class SingleOb4 {
	private static SingleOb4 single;
	
	private SingleOb4() {}
	
	public static SingleOb4 getSingle() {
		if(single==null) {
			synchronized (SingleOb4.class) {
				if(single==null) {
					single=new SingleOb4();
				}
			}
		}
		return single;
	}

}
