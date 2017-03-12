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

		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");

		personDAO.save(person);

		System.out.println("Person::" + person);

		personDAO.list().forEach(System.out::println);

		InvoiceDAO invoiceDAO= context.getBean(InvoiceDAO.class);
		Invoice invoice=new Invoice();
		invoice.setTitle("FirstInnvoice");
		invoice.setAccount("2852214");
		
		invoiceDAO.save(invoice);
		System.out.println("Invoivce::" + invoice);
		context.close();
		

	}


}
