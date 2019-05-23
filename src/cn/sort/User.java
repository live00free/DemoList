package cn.sort;

public class User implements Comparable<User>{
	private String name;
	private int age;
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public User() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(User user) {
		return this.age-user.age;
	}

	@Override
	public String toString() {
		return "[" + name + "," + age + "]";
	}
	
	
	
	
}
