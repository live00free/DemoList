package cn.adapter;

public class User extends UserAdapter{
	@Override
	public void select() {
		System.out.println("��ѯ����");
		super.select();
		System.out.println("��ѯ���");
	}
	
	public static void main(String[] args) {
		User user=new User();
		user.select();
		user.update();
	}
}
