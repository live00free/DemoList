package cn.adapter;

public class User extends UserAdapter{
	@Override
	public void select() {
		System.out.println("查询条件");
		super.select();
		System.out.println("查询结果");
	}
	
	public static void main(String[] args) {
		User user=new User();
		user.select();
		user.update();
	}
}
