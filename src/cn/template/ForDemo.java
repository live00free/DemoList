package cn.template;

public class ForDemo extends TimeCountor {

	@Override
	public void doSomeThing() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("ForDemo");
	}

}
