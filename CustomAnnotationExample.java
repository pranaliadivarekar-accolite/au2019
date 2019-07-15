package com.accolite.au.java;

import java.io.FileWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Servlet {
	String name();

	String url();
}

@Servlet(name = "BasicServlet", url = "basicServletExample")
public class CustomAnnotationExample {

	public CustomAnnotationExample() {
		Servlet servletAnn = this.getClass().getAnnotation(Servlet.class);

		System.out.println(servletAnn.name());
		System.out.println(servletAnn.url());
		System.out.println(this.getClass().getSimpleName());

		try {
			FileWriter fw = new FileWriter("C:\\Users\\pranali.adivarekar\\Documents\\New folder\\servlet.xml");
			fw.write("<servlet>\n");
			fw.write("\t<servletname>" + servletAnn.name() + "</servletname>\n");
			fw.write("\t<url>" + servletAnn.url() + "</url>\n");
			fw.write("\t<class>" + this.getClass().getSimpleName() + "</class>\n");
			fw.write("</servlet>\n");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String args[]) {
		CustomAnnotationExample customAnnotationExampleObj = new CustomAnnotationExample();

	}

}
