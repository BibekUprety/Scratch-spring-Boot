package com.example.demo.api;

import com.example.demo.Model.Person;
import com.example.demo.Services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson( @Valid @NotNull @RequestBody Person person){

        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
      return   personService.getPersonById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person){
        personService.updateStudent(id,person);
    }
}
