import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PredatorTest {
    @Test
    public void testEatMeat() throws Exception {
        // Создание мока для объекта Predator
        Predator predator = Mockito.mock(Predator.class);
        // Создание мок-списка
        List<String> mockList = new ArrayList<>();
        mockList.add("Говядина");
        mockList.add("Баранина");
        // Установка ожидаемого поведения для метода eatMeat() объекта Predator
        when(predator.eatMeat()).thenReturn(mockList);
        // Вызов метода eatMeat() объекта Predator
        List<String> result = predator.eatMeat();
        // Проверка, что метод eatMeat() объекта Predator был вызван
        Mockito.verify(predator).eatMeat();
        // Проверка, что результат вызова метода eatMeat() объекта Predator равен мок-списку
        Assert.assertEquals(mockList, result);
    }
}

