package cn.reflect;

import java.lang.reflect.Proxy;

import cn.entity.User;
import cn.entity.UserAgent;
import cn.entity.UserImpl;

/**
 * ∑¥…‰¥˙¿Ì
 * @author bioknow
 *
 */
public class ReflectAgent {
	
	public static void main(String[] args) {
		User user=new UserImpl();
		user.login();
		user.regist();
		System.out.println("-----------------------");
		
		UserAgent uag=new UserAgent(user);
		User proxy=(User) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), uag);
		proxy.login();
		proxy.regist();
		
	}
	
}
