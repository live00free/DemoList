package cn.actionurl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TestPost {
	public static void main(String[] args) {
		String requestUrl="http://localhost:8080/getUser";
//		String requestUrl="http://www.baidu.com";
		Map<String, String> fromJson = new HashMap<String, String>();
		String params = "";
		String result="";
		try {
			result = HttpUtil.post(requestUrl,params);
			System.out.println(result);
			//fromJson = new Gson().fromJson(result, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
