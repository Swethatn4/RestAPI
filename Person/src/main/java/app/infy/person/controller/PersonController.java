package app.infy.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.infy.person.entity.Person;
import app.infy.person.service.PersonService;

@RestController
@RequestMapping(value = "people")
public class PersonController {
	
	 @Autowired
	    private PersonService personService;

	    @RequestMapping(method = RequestMethod.GET)
	    public List<Person> findAll(){
	    return personService.findAll();
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public Person findOne(@PathVariable("id") String personId){
	        return personService.findOnePerson(personId);
	    }

	    @RequestMapping(method = RequestMethod.POST)
	    public Person create(@RequestBody Person person) {
	        return personService.create(person);
	    }

	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public Person update(@PathVariable("id") String personId, @RequestBody Person person){
	        return personService.update(personId, person);
	    }

	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public void delete(@PathVariable("id") String personId){
	    	personService.delete(personId);
	    }

}
