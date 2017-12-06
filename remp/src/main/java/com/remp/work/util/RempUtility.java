package com.remp.work.util;

import java.text.NumberFormat;
import java.util.Locale;

public class RempUtility {
	//id 생성
	public String getIdString(String prefix, int seq, int stringLegnth) {
		StringBuilder temp = new StringBuilder();
		temp.append(seq);
		StringBuilder temp2 = new StringBuilder(prefix);
		for (int i = 0; i < stringLegnth - temp.length() - prefix.length(); i++) {
			temp2.append(0);
		}
		temp2.append(temp);
		return temp2.toString();
	}
	//가격 , 천단위 구분
	public static StringBuffer numMoney(long num) {
		 StringBuffer sb = new StringBuffer(); 
		 NumberFormat nf = NumberFormat.getNumberInstance();
		 sb.append(nf.format(num));
		 return sb;
	}
}
