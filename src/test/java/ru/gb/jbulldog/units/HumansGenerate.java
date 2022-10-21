package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.List;

public class HumansGenerate {

    public List<Human> createHumanList(){
        List<Human> ppl = new ArrayList<>();
        for (Human.Profession profession : Human.Profession.values()) {
            ppl.add(new Human(profession));
        }
        return ppl;
    }

    public static void main(String[] args) {
        HumansGenerate hg = new HumansGenerate();
        System.out.println(hg.createHumanList().get(1).getProfession());
    }
}
