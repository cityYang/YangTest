package Fiirst.TestMaven;

public class App 
{
    public static void main( String[] args )
    {
    	String xml="<xml><ToUserName><![CDATA[toUser]]></ToUserName>"
				+"<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+"<CreateTime>12345678</CreateTime>"
				+"<MsgType><![CDATA[text]]></MsgType>"
				+"<Content>你好！</Content></xml>";
				try {
				//加载xml字符串
				org.dom4j.Document document=org.dom4j.DocumentHelper.parseText(xml);
				//获取根节点
				org.dom4j.Element root=document.getRootElement();
				//获取值 ==toUser
				String toUserName=root.elementText("Content");
				System.out.println(toUserName);
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}

    }
 }
