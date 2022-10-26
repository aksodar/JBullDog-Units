import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.gb.jbulldog.units.Human;
import ru.gb.jbulldog.units.HumanRepository;
import ru.gb.jbulldog.units.HumanService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HumanServiceTest {

    private HumanRepository humanRepository;
    HumanService hs;

    @BeforeEach
    void setUp() {
        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human(Human.Profession.TRADER));
        humanList.add(new Human(Human.Profession.FARMER));
        humanList.add(new Human(Human.Profession.NONE));
        Human h1 = new Human("Alex", Human.Profession.FARMER);
        Human h2 = new Human("Sasha", Human.Profession.BANKER);
        humanRepository = Mockito.mock(HumanRepository.class); // в переменную humanRepository засунули мок объект класса
        Mockito.when(humanRepository.getAll()).thenReturn(humanList); // когда у репозитория будет вызов метода геталл, то
        Mockito.when(humanRepository.getHumanByName("Alex")).thenReturn(h1);
        Mockito.when(humanRepository.getHumanByName("Sasha")).thenReturn(h2);
        Mockito.when(humanRepository.getHumanByName("abracadabra")).thenThrow(IllegalStateException.class);
        hs = new HumanService(humanRepository);
    }

    @Test
    void getOrderedAllHumansTest() {
        List<Human> expected = new ArrayList<Human>();
        List<Human> actual = new ArrayList<Human>();
        actual = hs.getOrderedAllHumans();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void getHumanByNameTest() {
        Human expected = new Human("Alex");
        Human actual = hs.getHumanByName("abracadabra");
        Assertions.assertEquals(expected, actual);
    }
}