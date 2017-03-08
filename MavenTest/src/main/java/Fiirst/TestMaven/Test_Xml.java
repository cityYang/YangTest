package Fiirst.TestMaven;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.xpath.DefaultXPath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test_Xml {
	public static void finalVersion() throws DocumentException {
		List<Element> list_generate = new ArrayList<Element>();
		Document doc = DocumentHelper.createDocument();
		SAXReader reader = new SAXReader();
		String name = null;
		String account = null;
		String nickname = null;
		String password = null;
		String level = null;
		Element nickElement = null;
		Element passElement = null;
		Element levelElement = null;
		Document document = reader.read("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\generate.xml");
		Document document_Text = reader.read("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\NewText.xml");
		XPath xpath = new DefaultXPath("/resources/product");
		list_generate = xpath.selectNodes(document.getRootElement());
		List<Element> root_list = document_Text.getRootElement().selectNodes("/resources");
		Element resource = root_list.get(0);
		Iterator<Element> iterator_generate = list_generate.iterator();
		while (iterator_generate.hasNext()) {
			Element product = (Element) iterator_generate.next();
			name = product.attributeValue("name");
			System.out.println("name________________________" + "\n" + name);
			product = resource.addElement("product");
			product.addAttribute("name", name);
			// resource.addElement(product);
			List<Element> root_name = document.getRootElement()
					.selectNodes("/resources/product[@name='" + name + "']/account");
			// resources/product[@name='QQ']
			// List<Element> root_name =
			// document.getRootElement().selectNodes("/resources/product[@name='yuanmingyang']/account");
			System.out.println("root_name长度________________________" + root_name.size());
			for (Element accountElement : root_name) {
				account = accountElement.attributeValue("id");
				System.out.println("account________________________"  + account);
				accountElement = product.addElement("account");
				accountElement.addAttribute("account", account);
/*				List<Element> root_account = document_Text.getRootElement().selectNodes(
						"/resources/product[@name='" + name + "']/account[@id='" + account + "']/nickname");*/
				XPath xPath = new DefaultXPath("/resources/product[@name='" + name + "']/account[@id='" + account + "']/nickname");
				List<Element> root_account = xPath.selectNodes(document.getRootElement());
				System.out.println("root_account长度________________________" + root_account.size());
				for (Element element : root_account) {
					nickname = element.getTextTrim();
					nickElement = accountElement.addElement("nickname");
					nickElement.setText(nickname);
					System.out.println("nickname________________________"  + nickname);
				}
				xPath = new DefaultXPath("/resources/product[@name='" + name + "']/account[@id='" + account + "']/password");
				root_account = xPath.selectNodes(document.getRootElement());
				for (Element element : root_account) {
					password = element.getTextTrim();
					passElement = accountElement.addElement("password");
					passElement.setText(password);
					System.out.println("password ________________________" + "\n" + password);
				}
				xPath = new DefaultXPath("/resources/product[@name='" + name + "']/account[@id='" + account + "']/level");
				root_account = xPath.selectNodes(document.getRootElement());
				for (Element element : root_account) {
					level = element.getTextTrim();
					levelElement = accountElement.addElement("level");
					levelElement.setText(level);
					System.out.println("level_________________________" + "\n" + level);
				}
			}
		}
		PrintWriter pwriter = null;
		XMLWriter xwriter = null;
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("gbk");
			pwriter = new PrintWriter("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\finalVersion.xml");
			xwriter = new XMLWriter(pwriter,format);
			Element resource_result=doc.addElement("resource");
			resource_result.add(resource);
			xwriter.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				xwriter.flush();
				xwriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static List<String> parseMethod1() throws DocumentException {
		List<String> result = new ArrayList<String>();

		SAXReader reader = new SAXReader();
		Document document = reader.read("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\NewText.xml");
		XPath xPath = new DefaultXPath("/resources/product[@name='QQ']/account[@id='987654321']/password");
		List<Element> list = xPath.selectNodes(document.getRootElement());
		for (Element element : list) {
			// System.out.println(element.getTextTrim());
			result.add(element.getTextTrim());
		}
		return result;
	}

	public static List<Element> parseMethod2() throws DocumentException {
		List<Element> result = new ArrayList<Element>();

		SAXReader reader = new SAXReader();
		Document document = reader.read("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\NewText.xml");
		System.out.println("document_____________________________" + "\n" + document);
		List<Element> products = document.getRootElement().selectNodes("/resources/product");
		Iterator<Element> iterator = products.iterator();
		while (iterator.hasNext()) {
			Element product = (Element) iterator.next();
			/*
			 * String name = product.attributeValue("name");
			 * System.out.println(name); result.add(product);
			 */
		}
		return result;
	}

	public static void generate() {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("resources");

		Element product = root.addElement("product");
		product.addAttribute("name", "yuanmingyang");

		Element account = product.addElement("account");
		account.addAttribute("id", "12125810");

		Element nickname = account.addElement("nickname");
		nickname.setText("大羊崽");

		Element password = account.addElement("password");
		password.setText("123asd21qda");

		Element level = account.addElement("level");
		level.setText("0");

		PrintWriter pWriter = null;
		XMLWriter xWriter = null;
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("gbk");
			pWriter = new PrintWriter("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\generate.xml");
			xWriter = new XMLWriter(pWriter, format);
			xWriter.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				xWriter.flush();
				xWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void reader() throws DocumentException {
		File file = new File("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\NewText.xml");
		Reader reader = null;
		String Xml = null;
		int j = 0;
		try {
			System.out.println("一次一个字节：");
			reader = new InputStreamReader(new FileInputStream(file));
			int temchar;
			while ((temchar = reader.read()) != -1) {
				if ((char) temchar != '\r') {
					if (j == 0)
						Xml = (char) temchar + "";
					else
						Xml += (char) temchar;
				}
				j++;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(Xml);
			// Document doc_result = DocumentHelper.createDocument();
			List<Element> root_list = doc.getRootElement().selectNodes("/resources");
			// Element root = doc_result.addElement(""+root_list.get(0));
			Element product = root_list.get(0).addElement("product");
			product.addAttribute("name", "liushiyang");

			Element account = product.addElement("account");
			account.addAttribute("id", "12125802");

			Element nickname = account.addElement("nickname");
			nickname.setText("xiaoyangyang");

			Element password = account.addElement("password");
			password.setText("18079516469");

			Element level = account.addElement("level");
			level.setText("999");

			PrintWriter pWriter = null;
			XMLWriter xWriter = null;
			try {
				pWriter = new PrintWriter("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\reader.xml");
				xWriter = new XMLWriter(pWriter);
				xWriter.write(doc);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					xWriter.flush();
					xWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		try {
			System.out.println("一次读多个字节");
			char[] tempchars = new char[10];
			int charread = 0;
			reader = new InputStreamReader(
					new FileInputStream("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\generate.xml"));
			while ((charread = reader.read(tempchars)) != -1) {
				if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
					/* System.out.print(tempchars); */
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == '\r') {
							continue;
						} else {
							// System.out.print(tempchars[i]);
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				reader.close();
				System.out.println();
			} catch (IOException e2) {

			}
		}
	}
}
