package cn.template;

public class IoDemo extends TimeCountor {

	@Override
	public void doSomeThing() {
		for(int i=0;i<15;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("IoDemo");
	}

}
