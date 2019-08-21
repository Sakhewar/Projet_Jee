package sn.ucad.gestionCommerciale.utilitaire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
	private static final String SPRING_BEANS = "bean.xml";
	private static ClassPathXmlApplicationContext context;

	static {

		try {
			 System.out.println("spring util 1 static debut ==>");
			 context = new ClassPathXmlApplicationContext (SPRING_BEANS);
			 System.out.println("valeur de context apres static try "+ context);
			 System.out.println("spring util 2 static fin ==>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ClassPathXmlApplicationContext getContext () {
		System.out.println("valeur de context "+ context);
		if (context == null) {
			try {
				 System.out.println("spring util public static debut==>");
				context = new ClassPathXmlApplicationContext(SPRING_BEANS);
				System.out.println("spring util public static fin ==>");
			} catch (Exception e) {
				
			}
		}
		return context;
	}
	
	public static Object getBean(String name) {
		Object bean = null;
		try {
			bean = getContext().getBean(name);
		} catch (Exception e) {
			
		}
		return bean;
	}

}
