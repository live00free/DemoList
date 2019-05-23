package cn.single;

public class TestSingle {
	public static void main(String[] args) {
		SingleOb single=SingleOb.getSingleOb();
		SingleOb single2=SingleOb.getSingleOb();
		System.out.println(single==single2);
	}
}
