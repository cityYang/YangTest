package test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class TestCar2 {
	public static WebDriver driver = new FirefoxDriver((new ProfilesIni()).getProfile("default"));

	public static void main(String[] args) throws InterruptedException {
		driver.navigate().to("http://mdmcarlib.chexiang.com/syncAsDataProcess/toSyncAsDataProcess.htm");
		driver.findElement(By.id("username")).sendKeys("chenweicong");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginbtn")).click();
		// new
		// Select(driver.findElement(By.id("processType"))).selectByVisibleText("更新");
		driver.findElement(By.id("syncBatchId")).sendKeys("76");
		new Select(driver.findElement(By.id("processStatus"))).selectByVisibleText("待处理");
		driver.findElement(By.id("queryButton")).click();

		// 这里打个断点，登陆进去
		while (true) {
			sleep();
			sleep();
			sleep();
			sleep();
			Date date = new Date();
			dorun(0, date, false);
		}
	}

	public static void dorun(int i, Date date, Boolean flag) throws InterruptedException {
		/*
		 * if (flag) { //driver.close(); open(); }
		 */
		try {
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
				try{
				   driver.findElement(By.linkText("处理")).click();
				}catch(Exception e){
					try{
						driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[2]/td[10]")).click();
					}catch(Exception e1){
						try{
							driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[3]/td[10]")).click();
						}catch(Exception e2){
							driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[4]/td[10]")).click();
						}
					}
				}
				driver.findElement(By.id("mergeData")).click();
				sleep();
				driver.findElement(By.id("okDopConfirmButton")).click();
				sleep();
				driver.findElement(By.xpath(".//div[@id='alert_Modal']//button[text()='确定']")).click();
			} else {
				// 更新
				try{
					   driver.findElement(By.linkText("处理")).click();
					}catch(Exception e){
					   driver.findElement(By.xpath(".//table[@id='models-data']/tbody/tr[2]/td[10]")).click();
				}
				driver.findElement(By.id("copyAllBtn")).click();
				sleep();
				driver.findElement(By.id("mergeData")).click();
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
				sleep();
				driver.findElement(By.id("okDopConfirmButton")).click();
				sleep();
				driver.findElement(By.xpath(".//div[@id='alert_Modal']//button[text()='确定']")).click();
				/*
				 * sleep(); sleep();
				 */
			}
		} catch (Exception e) {
			Date endDate = new Date();
			System.out.println(endDate.getHours() - date.getHours());
			if (endDate.getHours() - date.getHours() > 1) {
				dorun(++i, endDate, true);
			} else {
				dorun(++i, date, false);
			}

		}
	}

	public static void open() {
		driver.navigate().to("http://mdmcarlib.chexiang.com/syncAsDataProcess/toSyncAsDataProcess.htm");
		driver.findElement(By.id("username")).sendKeys("chenweicong");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginbtn")).click();
		// new
		// Select(driver.findElement(By.id("processType"))).selectByVisibleText("更新");
		driver.findElement(By.id("syncBatchId")).sendKeys("76");
		new Select(driver.findElement(By.id("processStatus"))).selectByVisibleText("待处理");
		driver.findElement(By.id("queryButton")).click();
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
}
