package cn.adapter;

/**
 * 适配器模式
 * @author bioknow
 *
 */
public abstract class UserAdapter implements UserDao {

	@Override
	public void add() {

	}

	@Override
	public void delete() {

	}

	@Override
	public void update() {
		System.out.println("更新功能");
	}

	@Override
	public void select() {
		System.out.println("查询功能");
	}

}
