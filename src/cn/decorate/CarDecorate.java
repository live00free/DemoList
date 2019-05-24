package cn.decorate;

/**
 * ×°ÊÎÆ÷Ä£Ê½
 * @author bioknow
 *
 */
public class CarDecorate implements Car{
	private Car car;
	
	public CarDecorate(Car car) {
		this.car=car;
	}

	@Override
	public void configure() {
		this.car.configure();
	}

}
