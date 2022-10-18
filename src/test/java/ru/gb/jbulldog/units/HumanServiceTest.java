package ru.gb.jbulldog.units;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class HumanServiceTest {

    HumanService humanService;

    @BeforeEach
    void setUp() {this.humanService = new HumanService();}

    @Test
    void getHumansTestFailedOnNullList() {                   // 1 тест если входной список null
        List<Human> expected = new ArrayList<>();

        List<Human> actual = humanService.getHumansByProfessionCode(null, 1);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void getHumansTestFailedOnEmptyList() {                 // 2 тест если входной список пустой
        List<Human> humans = new ArrayList<>();
        List<Human> expected = new ArrayList<>();

        List<Human> actual = humanService.getHumansByProfessionCode(humans, 0);

        Assertions.assertIterableEquals(expected, actual);

    }

    @Test
    void getHumansTestFailedOnNonValidCode() {              // 3 тест если код профессии вне допуска
        final List<Human> humans = new ArrayList<>();
        humans.add(new Human(Human.Profession.BANKER));
        final int code = -5;

        IllegalStateException exc = Assertions.assertThrows(IllegalStateException.class, () ->
                humanService.getHumansByProfessionCode(humans,code));

        Assertions.assertEquals("Non valid code", exc.getMessage());
    }

    @Test
    void getHumansTestSuccessful() {                       // 4 тест если входные параметры в порядке
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(Human.Profession.BANKER));
        humans.add(new Human(Human.Profession.FARMER));
        humans.add(new Human(Human.Profession.TRADER));
        humans.add(new Human(Human.Profession.BANKER));
        humans.add(new Human(Human.Profession.NONE));
        int code = 3;
        List<Human> expected = new ArrayList<>(2);
        expected.add(humans.get(0));
        expected.add(humans.get(3));

        List<Human> actual = humanService.getHumansByProfessionCode(humans, code);

        Assertions.assertIterableEquals(expected,actual);

    }

    @Test
    void getHumansTestFailedOnAbsentPerson() {        // 5 тест если во входном списке отсутствует искомый
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(Human.Profession.BANKER));
        humans.add(new Human(Human.Profession.FARMER));
        humans.add(new Human(Human.Profession.BANKER));
        humans.add(new Human(Human.Profession.NONE));
        int code = 1;
        List<Human> expected = new ArrayList<>(0);
        
        List<Human> actual = humanService.getHumansByProfessionCode(humans, code);

        Assertions.assertIterableEquals(expected,actual);
    }

    @Test
    void getHumansTestSuccessfulAllPersons() {  // 6 тест если во входном списке все искомые
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(Human.Profession.FARMER));
        humans.add(new Human(Human.Profession.FARMER));
        humans.add(new Human(Human.Profession.FARMER));
        int code = 2;
        List<Human> expected = new ArrayList<>(3);
        expected.add(humans.get(0));
        expected.add(humans.get(1));
        expected.add(humans.get(2));

        List<Human> actual = humanService.getHumansByProfessionCode(humans, code);

        Assertions.assertIterableEquals(expected,actual);
    }
}