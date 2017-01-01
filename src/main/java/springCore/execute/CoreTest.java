package springCore.execute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springCore.bean.Thing;

public class CoreTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Thing test = (Thing) context.getBean(Thing.class);
		String output = test.output();
		System.out.println(output);
	}
}
