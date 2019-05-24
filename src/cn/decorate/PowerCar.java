package cn.decorate;

public class PowerCar extends CarDecorate {

	public PowerCar(Car car) {
		super(car);
	}
	
	@Override
	public void configure() {
		super.configure();
		System.out.println("qigangfadongji");
	}

}
