package cn.decorate;

public class DecorateTest {
	public static void main(String[] args) {
		Car car=new PowerCar(new BmCar());
		car.configure();
	}
}
