package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Human> lh = new ArrayList<>(Arrays.asList(new Human(Human.Profession.BANKER),
                new Human(Human.Profession.BANKER), new Human(Human.Profession.FARMER),
                new Human(Human.Profession.TRADER)));
        List<Human> lh_2 = new ArrayList<>();


        List<Human> list = new HumanService().getHumansByProfessionCode(lh, 3);
        System.out.println(list.size());
    }
}
