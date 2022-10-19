package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Human> list = new ArrayList<>();


        //List<Human> list = null;

        list.add(new Human(Human.Profession.TRADER));
        //list.add(new Human(Human.Profession.FARMER));

        HumanService humanService = new HumanService();
        humanService.log.fine("45466");
        System.out.println(humanService.getHumansByProfessionCode(list, 1));
    }
}
