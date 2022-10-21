package ru.gb.jbulldog.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.jbulldog.units.Human;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    Human tester;

    @Test
    void getBankerProfessionSuccessfulTest() {
        tester = new Human(Human.Profession.BANKER);
        Human.Profession expected = Human.Profession.BANKER;
        Human.Profession actual = tester.getProfession();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFarmerProfessionSuccessfulTest() {
        tester = new Human(Human.Profession.FARMER);
        Human.Profession expected = Human.Profession.FARMER;
        Human.Profession actual = tester.getProfession();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTraderProfessionSuccessfulTest() {
        tester = new Human(Human.Profession.TRADER);
        Human.Profession expected = Human.Profession.TRADER;
        Human.Profession actual = tester.getProfession();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getNoneProfessionSuccessfulTest() {
        tester = new Human(Human.Profession.NONE);
        Human.Profession expected = Human.Profession.NONE;
        Human.Profession actual = tester.getProfession();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getNullProfessionSuccessTest() {
        tester = new Human(null);
        Human.Profession expected = null;
        Human.Profession actual = tester.getProfession();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getNoneProfessionCodeSuccessTest() {
        int expected = 0;
        int actual = Human.Profession.NONE.getCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getBankerProfessionCodeSuccessTest() {
        int expected = 3;
        int actual = Human.Profession.BANKER.getCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFarmerProfessionCodeSuccessTest() {
        int expected = 2;
        int actual = Human.Profession.FARMER.getCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTraderProfessionCodeSuccessTest() {
        int expected = 1;
        int actual = Human.Profession.TRADER.getCode();
        Assertions.assertEquals(expected, actual);
    }

}