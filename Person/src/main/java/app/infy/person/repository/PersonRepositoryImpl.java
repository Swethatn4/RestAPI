package app.infy.person.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import app.infy.person.entity.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> query = entityManager.createNamedQuery("Person.findAll",Person.class);
		return query.getResultList();
	}

	public Person findOnePerson(String personId) {
		return entityManager.find(Person.class, personId);
	}

	public Person create(Person person) {
		 entityManager.persist(person);
		 return person;
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public void delete(Person person) {
		entityManager.remove(person);
	}

}
