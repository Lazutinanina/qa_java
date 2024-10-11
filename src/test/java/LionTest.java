import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {
    @Mock
    private Feline mockFeline; // Мок зависимости Feline
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Инициализация моков
    }
    @Test
    public void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3); // Задаем поведение мока
        Lion lion = new Lion("Самец", mockFeline);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        // Act
        Lion lionMale = new Lion("Самец", mockFeline); // Создание самца
        Lion lionFemale = new Lion("Самка", mockFeline); // Создание самки
        assertTrue(lionMale.doesHaveMane()); // Проверка наличия гривы у самца
        assertFalse(lionFemale.doesHaveMane()); // Проверка отсутствия гривы у самки
    }

    /** Тест метода getFood().*/
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood); // Задаем поведение мока
        Lion lion = new Lion("Самец", mockFeline); // Создание объекта Lion
        List<String> food = lion.getFood(); // Получение списка пищи
        assertNotNull(food); // Проверка, что список пищи не null
        assertEquals(expectedFood, food); // Проверка соответствия ожидаемых и полученных данных
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        Feline feline = new Feline();
        // Создаем объект Lion с недопустимым значением пола
        Lion lion = new Lion("Недопустимый пол", feline);
    }

}

