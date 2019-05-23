package cn.smalldemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AlgorithmDemo {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		List<String> list2=new ArrayList<String>();
		list2.add("aa");
		list2.add("aa");
		list2.add("bb");
		list2.add("dd");
		list2.add("cc");
		for(String s:list) {
			if(list2.contains(s)) {
				list2.remove(s);
			}
		}
		System.out.println(list2);
		for(String s:list2) {
			if(list.contains(s)) {
				System.out.println(s+"重复");
			}
		}
	}
	
	public static String dayOfYearByDateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat( "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        return sdf.format(new Date());
    }
	
	public static int dayOfYearByDateFormat(int year, int month, int day) {
		SimpleDateFormat sdf = new SimpleDateFormat("DDD");
		return Integer.parseInt(sdf.format(new Date(year, month - 1, day)));
	}
	
	/**
	 * 数列移动m位
	 * @param arr
	 * @param m
	 * @return
	 */
	public  int[] moveSys(int[] arr, int m) {
        int[] resultArr = new int[arr.length];
        System.arraycopy(arr, arr.length - m, resultArr, 0, m);
        System.arraycopy(arr, 0, resultArr, m, arr.length - m);
        return resultArr;
    }
	
	/**
	 * 递归求斐波那契数列，或者求n个月后的兔子数量
	 * @param n
	 * @return
	 */
	public int feiBo(int n) {
		if(n==1||n==2) {
			return 1;
		}
		return feiBo(n-1)+feiBo(n-2);
	}
	
	/**
	 * 计算n！
	 * @param num
	 * @return
	 */
	public int power(int num) {
		if(num==1) {
			return 1;
		}
		return num*power(num-1);
	}
	
	/**
	 * 利用charAt()检查回文
	 * @param str
	 */
	public void checkHuiwen(String str) {
		for(int i=0;i<=str.length()/2;i++) {
			System.out.println(str.charAt(i));
			System.out.println(str.charAt(str.length()-1-i));
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				System.out.println("不");
				break;
			}
		}
		System.out.println("是回文");
	}
	
	/**
	 * 利用StringBuffer的reverse()方法检查回文
	 * @param str
	 * @return
	 */
	public boolean checkHuiwen2(String str) {
		StringBuffer sb=new StringBuffer(str);
		if(str.equals(sb.reverse().toString())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 反转list，校验回文
	 * @param str
	 * @return
	 */
	public boolean checkHuiwen3(String str) {
		char[] ch=str.toCharArray();
		String[] strr=new String[ch.length];
		for(int i=0;i<ch.length;i++) {
			strr[i]=String.valueOf(ch[i]);
		}
		List<String> list=Arrays.asList(strr);
		Collections.reverse(list);
		String str2="";
		for(String s:list) {
			str2+=s;
		}
		if(str2.equals(str2)) {
			return true;
		}
		return false;
	}
	
}
