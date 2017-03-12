package it.coderunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.coderunner.dao.InvoiceDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);

		Person homer = new Person();
		homer.setName("Michał");
		homer.setCountry("Poland");
		
		personDAO.save(homer);

		System.out.println("Person::" + homer);

		personDAO.list().forEach(System.out::println);
		
		Person updateMe=personDAO.find(1);
		updateMe.setName("Krzysztof");
		personDAO.update(updateMe);
		
		InvoiceDAO invoiceDAO= context.getBean(InvoiceDAO.class);
		Invoice invoice=new Invoice();
		invoice.setTitle("FirstInnvoice");
		invoice.setAccount("2852214");
		invoice.setPerson(homer);
		
		Invoice invoice1=new Invoice();
		invoice1.setTitle("ScondInnvoice");
		invoice1.setAccount("3841208");
		invoice1.setPerson(homer);
		
		invoiceDAO.save(invoice);
		invoiceDAO.save(invoice1);
		System.out.println("Invoivce::" + invoice);
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+personDAO.find(1));
		
		context.close();
		
		


	}


}
