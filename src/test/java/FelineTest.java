import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Test
    public void testEatMeat() throws Exception {
        // Создание мока для объекта Animal
        Animal animal = Mockito.mock(Animal.class);
        List<String> foodList = Arrays.asList("Животные", "Птицы", "Рыба");
        // Создание объекта Feline
        Feline feline = new Feline();
        // Установка ожидаемого поведения для метода getFood() объекта Animal
        Mockito.when(animal.getFood("Хищник")).thenReturn(foodList);
        // Тестирование метода eatMeat()
        List<String> result = feline.eatMeat();
        assertEquals(foodList, result);
    }
    @Test
    public void testGetFamily() {
        // Создание объекта Feline
        Feline feline = new Feline();
        // Проверка результата
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }
    @Test
    public void testGetKittens() {
        // Создание объекта Feline
        Feline feline = new Feline();
        // Проверка результата
        int result = feline.getKittens();
        assertEquals(1, result);
    }
    @Test
    public void testGetKittensWithCount() {
        // Создание объекта Feline
        Feline feline = new Feline();
        // Задаем количество котят для проверки
        int expectedKittenCount = 3;
        // Проверка результата
        int result = feline.getKittens(expectedKittenCount);
        assertEquals(expectedKittenCount, result);
    }
}
