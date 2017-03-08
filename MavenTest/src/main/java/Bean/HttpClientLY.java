package Bean;

import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpClientLY {
private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static String appKey = "liyang";
	private static String securityKey = "M4UoMc8s";
	private static String message = "{\"lyLibraryAndTask\": [{\"taskCode\": 2, \"lyModelId\": 123, \"remarks\": 新增}]}";
	private static String timestamp = format.format(new Date());
	private static String service = "MDMCarLib.ly.MDMLyService";
	private static String method = "insertLyModelLibrary";
//	private static String httpUrl = "http://openapi.chexiang.com/services/" + service + "/" + method;
//	private static String httpUrl = "http://openapi.pre.chexiang.com/services/" + service + "/" + method;
	private static String httpUrl = "http://openapi.sit.chexiang.com/services/" + service + "/" + method;
//	private static String httpUrl = "http://127.0.0.1:8080/services/" + service + "/" + method;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Map<String, String> headParams = new HashMap<String, String>();
		headParams.put("appKey", appKey);
		headParams.put("timestamp", timestamp);
		headParams.put("format", "json");
		headParams.put("signatureMethod", "md5");
		headParams.put("version", "1");
		headParams.put("signature", make(headParams, service, method, message, securityKey));
		
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(httpUrl);
		Set<String> keySet = headParams.keySet();
		for (String key : keySet) {
			postMethod.setRequestHeader(key, headParams.get(key));
		}
		postMethod.setRequestBody(message);
		postMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
		try {
			int httpStatus = httpClient.executeMethod(postMethod);
			System.out.println("httpStatus: " + httpStatus);
			byte[] result = postMethod.getResponseBody();
			System.out.println("result: " + new String(result));
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String make(Map<String, String> headParams,String service,String method, String message,
			String securityKey) {
		String signature = md5(makeOriginalString(headParams,service,method,message,securityKey));
		System.out.println("signature : " + signature);
		return signature;
		
	}
	
	public static String makeOriginalString(Map<String, String> headParams, String service,String method,String message,
			String securityKey){
		StringBuilder builder = new StringBuilder();
		builder.append(service);
		builder.append(method);
		builder.append(message);
		builder.append("appKey").append("=").append(headParams.get("appKey"));
		builder.append("format").append("=").append(headParams.get("format"));
		builder.append("timestamp").append("=").append(headParams.get("timestamp"));
		builder.append("signatureMethod").append("=").append(headParams.get("signatureMethod"));
		builder.append("version").append("=").append(headParams.get("version"));
		builder.append(securityKey);
		String contents = builder.toString();
		System.out.println("contents : " + contents);
		return  contents;
	}
	
	public final static String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
