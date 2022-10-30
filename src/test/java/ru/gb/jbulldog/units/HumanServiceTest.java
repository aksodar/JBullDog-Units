package ru.gb.jbulldog.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.gb.jbulldog.units.Human;
import ru.gb.jbulldog.units.HumanRepository;
import ru.gb.jbulldog.units.HumanService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HumanServiceTest {

    private HumanRepository humanRepository;
    HumanService hs;

    @BeforeEach
    void setUp() {
        this.hs = new HumanService();

        /* Mockito

        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human(Human.Profession.TRADER));
        humanList.add(new Human(Human.Profession.FARMER));
        humanList.add(new Human(Human.Profession.NONE));
        Human h1 = new Human("Alex", Human.Profession.FARMER);
        Human h2 = new Human("Sasha", Human.Profession.BANKER);
        humanRepository = Mockito.mock(HumanRepository.class); // в переменную humanRepository засунули мок объект класса
        Mockito.when(humanRepository.getAll()).thenReturn(humanList); // когда у репозитория будет вызов метода геталл, то
        Mockito.when(humanRepository.getHumanByName("Alex")).thenReturn(h1);
        Mockito.when(humanRepository.getHumanByName("Sasha")).thenReturn(h2);
        Mockito.when(humanRepository.getHumanByName("abracadabra")).thenThrow(IllegalStateException.class);
        hs = new HumanService(humanRepository);*/
    }


    /* Mockito
    @Test
    void getOrderedAllHumansTest() {
        List<Human> expected = new ArrayList<Human>();
        List<Human> actual = new ArrayList<Human>();
        actual = hs.getOrderedAllHumans();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByNameTest() {
        Human expected = new Human("Alex");
        Human actual = hs.getHumanByName("abracadabra");
        Assertions.assertEquals(expected, actual);
    }
*/


    @Test
    void getHumansByProfessionCodeTestSuccessfulArraysListIsEmpty() {
        List<Human> list = new ArrayList<>();

        List<Human> expected = new ArrayList<>();

        int code = 0;

        List<Human> actual = hs.getHumansByProfessionCode(list, code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestSuccessfulArraysListIsNull() {
        List<Human> list = null;

        List<Human> expected = new ArrayList<>();

        int code = 0;

        List<Human> actual = hs.getHumansByProfessionCode(list, code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestFailureNoneValidCode() {
        List<Human> listHumans = new ArrayList<>(Arrays.asList(new Human(Human.Profession.TRADER)));

        int code = 10;

        IllegalStateException exc = Assertions.assertThrows(IllegalStateException.class, () -> {
            hs.getHumansByProfessionCode(listHumans, code);
        });

        assertEquals("Non valid code", exc.getMessage());
    }


    @Test
    void getHumansByProfessionCodeTestSuccessfulCode2ProfFarmer() {
        List<Human> expected = new ArrayList<>();
        expected.add(new Human("Alex", Human.Profession.FARMER));
        List<Human> actual = hs.getHumansByProfessionCode(expected, 2);
        assertEquals(expected, actual);
    }


    @Test
    void getHumansByProfessionCodeTestSuccessfulArrayList() {
        List<Human> list = new ArrayList<>();
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.FARMER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.NONE));
        list.add(new Human(Human.Profession.TRADER));

        List<Human> expected = new ArrayList<Human>(Arrays.asList(list.get(0), list.get(4)));

        int code = 1;

        List<Human> actual = hs.getHumansByProfessionCode(list, code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestSuccessfulEmptyOutArrayListForNoMatches(){
        List<Human> list = new ArrayList<>();
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.FARMER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.TRADER));

        List<Human> expected = new ArrayList<Human>();

        int code = 0;

        List<Human> actual = hs.getHumansByProfessionCode(list,code);
    }

    @Test
    void getHumansByProfessionCodeTestSuccessfulAllValuesIsEqual(){
        List<Human> list = new ArrayList<>();
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.TRADER));

        int code = 1;

        List<Human> expected = new ArrayList<>(Arrays.asList(list.get(0),list.get(1),list.get(2),list.get(3)));

        List<Human> actual = hs.getHumansByProfessionCode(list,code);

        Assertions.assertEquals(expected, actual);

    }
}