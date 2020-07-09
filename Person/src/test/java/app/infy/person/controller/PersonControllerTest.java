package app.infy.person.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.infy.person.controller.PersonController;
import app.infy.person.entity.Person;

import app.infy.person.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-servlet.xml"}) 
public class PersonControllerTest {
	
	@InjectMocks
	private PersonController controller; 
	
	@Mock
	private PersonService service;
	
	List<Person> listOfPeople = new ArrayList<Person>();
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

		Person person1 = new Person();
		person1.setId("Id1");
		person1.setName("Person1");
		person1.setAge(25);
		listOfPeople.add(person1);
		
		Person person2 = new Person();
		person2.setId("Id2");
		person2.setName("Person2");
		person2.setAge(30);
		listOfPeople.add(person2);
    }
	
	@Test
	public void findAll() throws Exception{
		
		Mockito.when(service.findAll()).thenReturn(listOfPeople);
	
		List<Person> result = controller.findAll();

		assertEquals(listOfPeople.get(0).getName(),result.get(0).getName());
		
	}
	
	@Test
	public void findOnePerson() throws Exception{
		
		Mockito.when(service.findOnePerson("Id2")).thenReturn(listOfPeople.get(1));
	
		Person result = controller.findOne("Id2");

		assertEquals(result.getId(), listOfPeople.get(1).getId());
		
	}
	
	
	

}
