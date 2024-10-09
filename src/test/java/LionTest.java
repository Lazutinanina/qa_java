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
    public void testGetKittens() {
        // Arrange
        when(mockFeline.getKittens()).thenReturn(3); // Задаем поведение мока
        // Act
        Lion lion = null;
        try {
            lion = new Lion("Самец", mockFeline); // Создание объекта Lion
        } catch (Exception e) {
            fail("Исключение было выброшено неожиданно");
        }
        int kittens = lion.getKittens(); // Получение количества детенышей
        // Assert
        assertEquals(3, kittens); // Проверка ожидаемого результата
    }
    @Test
    public void testDoesHaveMane() {
        // Act
        Lion lionMale = null;
        Lion lionFemale = null;
        try {
            lionMale = new Lion("Самец", mockFeline); // Создание самца
            lionFemale = new Lion("Самка", mockFeline); // Создание самки
        } catch (Exception e) {
            fail("Неожиданно возникло исключение");
        }
        // Assert
        assertTrue(lionMale.doesHaveMane()); // Проверка наличия гривы у самца
        assertFalse(lionFemale.doesHaveMane()); // Проверка отсутствия гривы у самки
    }

    /** Тест метода getFood().*/
    @Test
    public void testGetFood() {
        // Arrange
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        try {
            when(mockFeline.getFood("Хищник")).thenReturn(expectedFood); // Задаем поведение мока
        } catch (Exception e) {
            fail("Неожиданно возникло исключение");
        }
        // Act
        Lion lion = null;
        try {
            lion = new Lion("Самец", mockFeline); // Создание объекта Lion
        } catch (Exception e) {
            fail("Неожиданно возникло исключение");
        }
        List<String> food = null;
        try {
            food = lion.getFood(); // Получение списка пищи
        } catch (Exception e) {
            fail("Неожиданно возникло исключение");
        }
        // Assert
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

