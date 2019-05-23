package cn.template;

/**
 * ģ��ģʽ
 * @author bioknow
 *
 */
public abstract class TimeCountor {
	public void getTime() {
		long start=System.currentTimeMillis();
		doSomeThing();
		long end=System.currentTimeMillis();
		System.out.println("�ܹ���ʱ��"+(end-start)+"����");
	}

	public abstract void doSomeThing();
	
	
	public static void main(String[] args) {
		TimeCountor tc=new ForDemo();
		TimeCountor tc2=new IoDemo();
		tc.getTime();
		tc2.getTime();
	}
}
