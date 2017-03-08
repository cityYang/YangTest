package test;

public class TestCarother extends Thread {
	private String name;
	public TestCarother(String name) {  
		super();  
		this.name = name;  
		}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i==100)
			System.out.println(this.name + "complete!" );
			else
			System.out.println("线程开始：" + this.name + ",percent=" + i+"%");
		}
	}
	public static void main(String[] args) {  
		TestCarother mt1=new TestCarother("ip:10.**.**.59");  
		TestCarother mt2=new TestCarother("ip:10.**.**.68");  
		mt1.start();  
		mt2.start();  
		}  
}
