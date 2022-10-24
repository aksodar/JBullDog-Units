package ru.gb.jbulldog.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human h;
    @BeforeEach
    void setUp() {
        this.h = new Human(Human.Profession.FARMER);
    }

    @Test
    void getProfessionTest() {
        Human.Profession expected = Human.Profession.FARMER;
        Human.Profession actual = h.getProfession();
        assertEquals(expected,actual);

    }

    @Test
    void getCodeProfessionTest() {
        int expected = 2;
        int actual = h.getProfession().getCode();
        assertEquals(expected,actual);

    }


}