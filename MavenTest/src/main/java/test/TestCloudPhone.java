package test;

import java.io.IOException;     
import org.apache.commons.httpclient.*;   
import org.apache.commons.httpclient.methods.*;

import Bean.Result;
import net.sf.json.JSONObject;
public class TestCloudPhone {
   public static void main (String args[]) throws IOException{
	HttpClient client =new HttpClient();
   	HttpMethod method = new GetMethod("http://121.41.74.120/app?Action=Dialout&Account=N00000009694&PBX=sh.ali.5.1&FromExten=8000&Exten=13818033715&ActionID=123123");
   	client.executeMethod(method);
   	System.out.println("status:"+method.getStatusLine());
   	System.out.println("information:"+method.getResponseBodyAsString());
   	JSONObject obj = new JSONObject();
   	obj=JSONObject.fromObject(method.getResponseBodyAsString());
   	String Succeed = obj.getString("Succeed");
   	System.out.println("Succeed:"+Succeed);
   	JSONObject obj1 = new JSONObject().fromObject(method.getResponseBodyAsString());
   	Result re = (Result)JSONObject.toBean(obj1,Result.class);
   	System.out.println(re.getCommand());
   	method.releaseConnection();
   }
}
