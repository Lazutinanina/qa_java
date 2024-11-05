import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParametrizedLionTests {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true }, { "Самка", false }
        });
    }

    private final String sex;
    private final boolean hasMane;
    @Mock
    private Feline mockFeline;
    public ParametrizedLionTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Test
    public void shouldReturnLion() {
        System.out.println("parameters " + this.sex);
        Lion lion = null;
        try {
            lion = new Lion(this.sex, mockFeline); // Создание самца
        } catch (Exception e) {
            fail("Неожиданно возникло исключение");
        }
        // Assert
       // assertTrue(lionMale.doesHaveMane()); // Проверка наличия гривы у самца
        assertEquals(this.hasMane, lion.doesHaveMane());
    }
    }


