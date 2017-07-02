package beantest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.TestBean;

public class BeanTest {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		TestBean b = (TestBean) context.getBean("test");
		System.out.println(b.getTest());
	}
}
