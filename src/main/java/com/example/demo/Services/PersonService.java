package com.example.demo.Services;

import com.example.demo.Dao.PersonDao;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;
    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(@Qualifier("fake") Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson(){
       return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectByPersonId(id);
    }
    public int deletePerson(UUID id){
        return personDao.deleteById(id);
    }
    public int updateStudent(UUID id,Person person){
        return personDao.updateById(id, person);
    }
}
