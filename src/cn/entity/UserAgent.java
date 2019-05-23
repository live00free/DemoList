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
		System.out.println("权限校验");
		Object result=method.invoke(target, args);
		System.out.println("日志记录");
		return result;
	}

}
