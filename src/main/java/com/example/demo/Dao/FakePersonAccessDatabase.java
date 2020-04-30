package com.example.demo.Dao;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class FakePersonAccessDatabase implements PersonDao{
    private static List<Person> DB =new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectByPersonId(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteById(UUID id) {
        Optional<Person> personMayBe = selectByPersonId(id);
        if (personMayBe.isPresent()){
            DB.remove(personMayBe.get());
            return 1;
        }
        return 0;

    }

    @Override
    public int updateById(UUID id, Person update) {
        selectByPersonId(id)
                .map(person -> {
                    int indexOdPersonTUpdate = DB.indexOf(person);
                    if (indexOdPersonTUpdate >= 0) {
                        DB.set(indexOdPersonTUpdate, new Person(id,update.getName()));
                        return 1;
                    }
                    return 0;
                });
               return 0;

    }



//    }
//    @Override
//    public int addPerson(Person person) {
//        return 0;
}
