package sn.ucad.gestionCommerciale.utilitaire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
	private static final String SPRING_BEANS = "bean.xml";
	private static ClassPathXmlApplicationContext context;

	static {

		try {
			 System.out.println("spring util 1 ==>");
			 context = new ClassPathXmlApplicationContext (SPRING_BEANS);
			 System.out.println("spring util 2 ==>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ClassPathXmlApplicationContext getContext () {
		if (context == null) {
			try {
				 System.out.println("spring util ==>");
				context = new ClassPathXmlApplicationContext(SPRING_BEANS);
				System.out.println("spring util ==>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return context;
	}
	
	public static Object getBean(String name) {
		Object bean = null;
		try {
			bean = getContext().getBean(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

}
