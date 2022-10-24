package ru.gb.jbulldog.units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HumanServiceTest {
    List<Human> lh;
    List<Human> lh_null;
    @BeforeEach
    void setUp() {
        this.lh = new ArrayList<>(Arrays.asList(new Human(Human.Profession.BANKER),
                new Human(Human.Profession.BANKER), new Human(Human.Profession.FARMER),
                new Human(Human.Profession.TRADER)));
        this.lh_null = new ArrayList<>();

    }

    @Test
    void sizeArrayListTest() {
        List<Human> list = new HumanService().getHumansByProfessionCode(lh, 3);
        int expected = 2;
        int actual = list.size();
        assertEquals(expected,actual);
    }

    @Test
    void sizeArrayListNullTest() {
        List<Human> list = new HumanService().getHumansByProfessionCode(lh_null, 3);
        int expected = 0;
        int actual = list.size();
        assertEquals(expected,actual);
    }

    @Test
    void illegalStateExceptionTest() throws IllegalStateException {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            List<Human> list = new HumanService().getHumansByProfessionCode(lh, 5);
        });

    }
}