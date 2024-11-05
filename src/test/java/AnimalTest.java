import com.example.Animal;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalTest {

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        // Создание объекта Animal
        Animal animal = Mockito.spy(new Animal());
        // Создание мока для списка
        List<String> foodList = mock(List.class);
        // Установка ожидаемого поведения для метода iterator() макета foodList
        Iterator<String> iterator = mock(Iterator.class);
        when(foodList.iterator()).thenReturn(iterator);
        // Установка ожидаемого поведения для методов hasNext() и next() итератора
        when(iterator.hasNext())
                .thenReturn(true) // Первый вызов hasNext()
                .thenReturn(true) // Второй вызов hasNext()
                .thenReturn(false); // Третий вызов hasNext()
        when(iterator.next())
                .thenReturn("Трава") // Первый вызов next()
                .thenReturn("Различные растения"); // Второй вызов next()
        // Установка ожидаемого поведения для метода getFood() объекта Animal
        when(animal.getFood("Травоядное")).thenReturn(foodList);
        // Выполнение метода getFood() объекта Animal
        List<String> result = animal.getFood("Травоядное");
        // Проверка результата
        List<String> expected = new ArrayList<>();
        expected.add("Трава");
        expected.add("Различные растения");
        assertEquals(expected, result);
    }
    @Test
    public void testGetFoodForCarnivore() throws Exception {
        Animal animal = mock(Animal.class);
        List<String> expectedFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
        when(animal.getFood("Хищник")).thenReturn(expectedFoodList);
        assertEquals(expectedFoodList, animal.getFood("Хищник"));
    }
    @Test
    public void testGetFoodForUnknownAnimal() {
        // Создание объекта Animal
        Animal animal = new Animal();
        // Проверка на выброс исключения
        try {
            animal.getFood("Неизвестный");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}

