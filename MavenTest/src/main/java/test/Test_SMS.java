package test;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test_SMS {
   public static void main(String[]args)throws Exception{
	   HttpClient client = new HttpClient();
	   PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
	   post.addRequestHeader("content-Type","application/x-www-form-urlencoded;charset=gbk");
	   NameValuePair[]data={new NameValuePair("uid","liushiyang"),
			   new NameValuePair("Key","520d2e728446695d41e7"),
			   new NameValuePair("smsMob","13564890705"),
			   new NameValuePair("smsMob","18817844007"),
			   new NameValuePair("smsText","你不爱我！……^-^【来自太空的暗黑者】")};
	   post.setRequestBody(data);
	   client.executeMethod(post);
	   Header[]headers = post.getResponseHeaders();
	   int statusCode = post.getStatusCode();
	   System.out.println("statusCode:" + statusCode);  
	   for(Header h:headers){
		   System.out.println(h.toString());  
		   
	   }
	   String result = new String(post.getResponseBodyAsString().getBytes(  
	            "gbk"));  
	    System.out.println(result);  
	    post.releaseConnection();  
   }
}
