package cn.adapter;

/**
 * ������ģʽ
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
		System.out.println("���¹���");
	}

	@Override
	public void select() {
		System.out.println("��ѯ����");
	}

}
