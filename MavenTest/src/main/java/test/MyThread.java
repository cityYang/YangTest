package test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class MyThread implements Runnable {
	public static WebDriver driver = new FirefoxDriver((new ProfilesIni()).getProfile("default"));
	private String name;
	private int i;

	public MyThread(int i, String name) {
		this.name = name;
		this.i = i;
	}

	public void run() {
		System.out.println("线程开始：" + this.name + ",i=" + i);
		if (i != 0) {
			try {
				driver.findElement(By.xpath(".//div[@id='alert_Modal']//button[text()='确定']")).click();
			} catch (Exception e) {
				// System.out.println("捕获不到确定按钮！");
			}
			try {
				try {
					driver.findElement(By.id("mergeData")).click();
				} catch (Exception e) {
					// System.out.println("捕获不到确定按钮！");
				}
				sleep();
				try {
					driver.findElement(By.id("okDopConfirmButton")).click();
				} catch (Exception e) {
					// System.out.println("捕获不到确定按钮！");
				}
				sleep();
				String msg = driver.findElement(By.xpath(".//div[@id='alert_Modal']//div[@class='modal-body']"))
						.getText();
				System.out.println("________" + msg);
				if (msg.contains("请先") || msg.contains("重复")) {
					driver.findElement(By.xpath(".//div[@id='alert_Modal']//button[text()='确定']")).click();
					sleep();
					driver.findElement(By.id("ignoreOp")).click();
					sleep();
					driver.findElement(By.id("okDopConfirmButton")).click();
				}
				// System.out.println(driver.findElement(By.xpath(".//div[@id='alert_Modal']//div[text()='请先更新车型信息']")));
			} catch (Exception e) {
				System.out.println("线程正常！");
			}
		}
		try {
			driver.findElement(By.id("queryButton")).click();
		} catch (Exception e) {
			System.out.println("查询！");
		}
		if (driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[1]/td[4]")).getText().equals("新增")) {
			driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[2]/td[10]")).click();
			driver.findElement(By.id("mergeData")).click();
			try {
				sleep();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By.id("okDopConfirmButton")).click();
			try {
				sleep();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath(".//div[@id='alert_Modal']//button[text()='确定']")).click();
		} else {
			// 更新
			driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[2]/td[10]")).click();
			driver.findElement(By.id("copyAllBtn")).click();
			try {
				sleep();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			driver.findElement(By.id("mergeData")).click();
			try {
				sleep();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By.id("okDopConfirmButton")).click();
			try {
				sleep();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath(".//div[@id='alert_Modal']//button[text()='确定']")).click();
		}
	}

	public static void main(String[] args) {
		MyThread mt1 = new MyThread(0, "第一线程");
		MyThread mt2 = new MyThread(0, "第二线程");
		driver.navigate().to("http://mdmcarlib.chexiang.com/syncAsDataProcess/toSyncAsDataProcess.htm");
		driver.findElement(By.id("username")).sendKeys("chenweicong");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginbtn")).click();
		// new
		// Select(driver.findElement(By.id("processType"))).selectByVisibleText("更新");
		driver.findElement(By.id("syncBatchId")).sendKeys("76");
		new Select(driver.findElement(By.id("processStatus"))).selectByVisibleText("待处理");
		driver.findElement(By.id("queryButton")).click();
		while (true) {
			int i = 0;
			try {
				new Thread(mt1).start();
			} catch (Exception e) {
				mt1 = new MyThread(1, "第一线程");
				new Thread(mt1).start();
			}
			try {
				new Thread(mt2).start();
			} catch (Exception e) {
				mt2 = new MyThread(1, "第一线程");
				new Thread(mt2).start();
			}
		}
	}

	public void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}

}
