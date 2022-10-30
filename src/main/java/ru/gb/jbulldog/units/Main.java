package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HumanService hs = new HumanService();

        List<Human> listHumans = new ArrayList<>();
        listHumans.add(new Human(Human.Profession.NONE));
        //listHumans.add(new Human(Human.Profession.TRADER));
        hs.getHumansByProfessionCode(listHumans, 10);
    }
}
