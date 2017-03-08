package test;

import java.util.List;

import org.dom4j.DocumentException;
import org.testng.annotations.Test;

import Fiirst.TestMaven.Test_Xml;

public class Test_testXml {
	@Test
	public void testParseMethod1() throws DocumentException {
		/*
		 * List<?>list=Test_Xml.parseMethod1(); System.out.println(list);
		 */
		Test_Xml.parseMethod1();
	}

	@Test
	public void testParseMethod2() throws DocumentException {
		/*
		 * List<?>list=Test_Xml.parseMethod2(); System.out.println(list);
		 */
		Test_Xml.parseMethod2();
	}

	@Test
	public void testGenerate() {
		Test_Xml.generate();
	}

	@Test
	public void testReader() throws DocumentException {
		Test_Xml.reader();
	}

	@Test
	public void testfinalVersion() throws DocumentException {
		Test_Xml.finalVersion();
	}
}
