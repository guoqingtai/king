package beantest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import knight.z9_test.TestBean;

public class BeanTest {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-common.xml"});
		TestBean b = (TestBean) context.getBean("knight.z9_test");
		System.out.println(b.getTest());
	}
}
