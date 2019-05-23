package cn.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestUserSort {
	public static void main(String[] args) {
		List<User> users=new ArrayList<User>();
		User u1=new User("faef",12);
		User u2=new User("faerf",13);
		User u3=new User("faefaef",14);
		User u4=new User("ff",17);
		User u5=new User("faeefgaeg",15);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		System.out.println(users);
		//Collections.sort(users);
		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		System.out.println(users);
	}
}
