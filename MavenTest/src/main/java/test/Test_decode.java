package test;

import java.io.UnsupportedEncodingException;

public class Test_decode {
    public static void main(String[]args) throws UnsupportedEncodingException{
    	String name ="袁鸣洋是个大傻逼！！！！";
    	//toHex(name.toCharArray());
    	byte[]b8 = name.getBytes("UTF-8");
    	System.out.println("b8——————————————————"+toHex(b8));
    	byte[]iso8859 = name.getBytes("ISO-8859-1");
    	System.out.println("iso8859——————————————————"+toHex(iso8859));
    	byte[]gb2312 = name.getBytes("GB2312");
    	System.out.println("gb2312——————————————————"+toHex(gb2312));
    	byte[]gbK = name.getBytes("GBK");
    	System.out.println("gbK——————————————————"+toHex(gbK));
    	byte[]b16 = name.getBytes("UTF-16");
    	System.out.println("b16——————————————————"+toHex(b16));
    	String result = new String(b8,"UTF-8");
    	System.out.println("result______________"+result);
    	String iso_result = new String(gbK,"ISO-8859-1");
    	System.out.println("iso_result______________"+iso_result);
    	byte[]gbk2 = iso_result.getBytes("ISO-8859-1");
    	String gbk2_result = new String(gbk2,"GBK");
    	System.out.println("iso_result______________"+gbk2_result);
    	String str= "Ô¬ÃùÑóÊÇ¸ö´óÉµ±Æ£¡£¡£¡£¡";
    	byte[]gbk_str = str.getBytes("ISO-8859-1");
    	String re_str = new String(gbk2,"GBK");
    	System.out.println("re_str______________"+re_str);
    }

	private static String toHex(byte[] b) {
		String ret="";
		for(int i=0;i<b.length;i++){
		String hex = Integer.toHexString(b[i]&0xFF);
		if(hex.length()==1){
			hex = '0'+hex;
		}
		ret+=" "+hex.toUpperCase();
		}
		return ret;
	}
}
