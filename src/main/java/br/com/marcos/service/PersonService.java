package br.com.marcos.service;

import br.com.marcos.model.Person;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService{
    @Override
    public Person createPerson(Person person) {

        if(person.getEmail() == null|| person.getEmail().isBlank()) throw new IllegalArgumentException("The person email is null or is empty");

        var id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }
}
