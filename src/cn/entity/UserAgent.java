package cn.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserAgent implements InvocationHandler{
	private Object target;
	
	public UserAgent(Object obj) {
		this.target=obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Ȩ��У��");
		Object result=method.invoke(target, args);
		System.out.println("��־��¼");
		return result;
	}

}
