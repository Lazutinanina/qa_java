import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {
    @Test
    public void testGetSound() {
        // Создание объекта Cat
        Cat cat = new Cat(Mockito.mock(Feline.class));
        // Проверка результата
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }
    @Test
    public void testGetFood() throws Exception {
        // Создание мока для объекта Feline
        Feline feline = Mockito.mock(Feline.class);
        // Создание объекта Cat с мок-объектом Feline
        Cat cat = new Cat(feline);
        // Создание мока для списка
        List<String> foodList = Mockito.mock(List.class);
        // Установка ожидаемого поведения для метода eatMeat() объекта Feline
        Mockito.when(feline.eatMeat()).thenReturn(foodList);
        // Проверка результата
        List<String> result = cat.getFood();
        assertEquals(foodList, result);
    }
}
