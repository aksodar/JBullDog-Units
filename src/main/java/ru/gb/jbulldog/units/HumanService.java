package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class HumanService {

    Logger log;
    private HumanRepository humanRepository;

    public HumanService() {
        this.log = Logger.getLogger(HumanService.class.getName());
        this.humanRepository = new HumanRepository();
    }

    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    List<Human> getHumansByProfessionCode(final List<Human> humans, final int code) {
        if (humans == null || humans.isEmpty()) {
            log.fine("Empty humans list!");
            //log.info("Empty humans list!");  для отображения лога в консоли
            return new ArrayList<Human>();
        }

        boolean flag = false;
        for (final Human.Profession p : Human.Profession.values()) {
            if (p.getCode() == code) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            log.severe("Non valid code");
            //log.info("Non valid code"); для отображения лога в консоли
            throw new IllegalStateException("Non valid code");
        }

        final List<Human> result = new ArrayList<Human>();
        for (final Human human : humans) {
            if (human.getProfession().getCode() == code) {
                result.add(human);
            }
        }
        log.fine(String.format("Find %s items.", result.size()));
        //log.info(String.format("Find %s items.", result.size()));  для отображения лога в консоли

        return result;
    }

    public List<Human> getOrderedAllHumans() { // Mockito
        List<Human> humans = humanRepository.getAll();
        //...
        return humans;
    }

    public Human getHumanByName(String name) {// Mockito
        Human human = humanRepository.getHumanByName(name);
        //...
        return human;
    }
}
