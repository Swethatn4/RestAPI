package app.infy.person.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.infy.person.entity.Person;
import app.infy.person.exception.PersonNotFoundException;
import app.infy.person.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Transactional
	public Person findOnePerson(String personId) {
		Person person = personRepository.findOnePerson(personId);
		if(person == null) throw new PersonNotFoundException("Person with id="+personId+" NOT FOUND");
		return person;
	}

	@Transactional
	public Person create(Person person) {
		Person existing = personRepository.findOnePerson(person.getId());
		if(existing !=null) throw new PersonNotFoundException("Person with Id="+person.getId()+" already exists");
		return personRepository.create(person);
	}

	@Transactional
	public Person update(String personId, Person person) {
		Person existing = personRepository.findOnePerson(personId);
		if(existing ==null) throw new PersonNotFoundException("Person with Id="+person.getId()+" NOT FOUND");
		return personRepository.update(person);
	}

	@Transactional
	public void delete(String personId) {
		Person existing = personRepository.findOnePerson(personId);
		if(existing ==null) throw new PersonNotFoundException("Person with Id="+personId+" NOT FOUND");
		personRepository.delete(existing);
		
	}

}
