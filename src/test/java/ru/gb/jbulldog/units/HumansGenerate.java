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
}
