package app.infy.person.service;

import java.util.List;

import app.infy.person.entity.Person;

public interface PersonService {
	public List<Person> findAll();
	public Person findOnePerson(String personId);
	public Person create(Person person);
	public Person update(String personId, Person person);
	public void delete(String personId);

}
