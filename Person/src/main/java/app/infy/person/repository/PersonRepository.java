package app.infy.person.repository;

import java.util.List;

import app.infy.person.entity.Person;

public interface PersonRepository {
	
	public List<Person> findAll();
	public Person findOnePerson(String personId);
	public Person create(Person person);
	public Person update(Person person);
	public void delete(Person person);

}
