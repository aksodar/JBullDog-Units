package ru.gb.jbulldog.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HumanServiceTest {


    HumanService humanService;
    HumansGenerate hg;

    @BeforeEach
    void setUp() {
        humanService = new HumanService();
        hg = new HumansGenerate();
    }

    @Test
    void getHumanByProfessionCodeNullSuccessTest(){
        List<Human> expected = new ArrayList<>();
        List<Human> actual = humanService.getHumansByProfessionCode(null, 0);
        assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByProfessionCodeEmptySuccessTest(){
        List<Human> expected = new ArrayList<>();
        List<Human> actual = humanService.getHumansByProfessionCode(new ArrayList<>(), 0);
        assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByProfessionCodeNoneSuccessTest(){
        List<Human> expected = new ArrayList<>();
        List<Human> actual = humanService.getHumansByProfessionCode(hg.createHumanList(), 0);
        expected.add(actual.get(0));
        assertIterableEquals(expected, actual);
    }


    @Test
    void getHumanByProfessionCodeTraderSuccessTest(){
        List<Human> expected = new ArrayList<>();
        List<Human> actual = humanService.getHumansByProfessionCode(hg.createHumanList(), 1);
        expected.add(actual.get(0));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByProfessionCodeFarmerSuccessTest(){
        List<Human> expected = new ArrayList<>();
        List<Human> actual = humanService.getHumansByProfessionCode(hg.createHumanList(), 2);
        expected.add(actual.get(0));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByProfessionCodeBankerSuccessTest(){
        List<Human> expected = new ArrayList<>();
        List<Human> actual = humanService.getHumansByProfessionCode(hg.createHumanList(), 3);
        expected.add(actual.get(0));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByProfessionCodeOverCodeFailTest(){
    IllegalStateException exc = assertThrows(
            IllegalStateException.class,
            () -> humanService.getHumansByProfessionCode(
                    hg.createHumanList(), 4));

    assertEquals("Non valid code", exc.getMessage());
    }

}