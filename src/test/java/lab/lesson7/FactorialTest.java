package lab.lesson7;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @org.testng.annotations.Test
    public void testCalculateFactorial() {
        Factorial calculator = new Factorial();
        assertEquals(calculator.calculateFactorial(0), 1);
        assertEquals(calculator.calculateFactorial(1), 1);
        assertEquals(calculator.calculateFactorial(2), 2);
        assertEquals(calculator.calculateFactorial(3), 6);
        assertEquals(calculator.calculateFactorial(4), 24);
        assertEquals(calculator.calculateFactorial(5), 120);
        assertEquals(calculator.calculateFactorial(8), 40320);
    }

        @Test
        public void testCalculateFactorialLargeNumber () {
            Factorial calculator = new Factorial();
            assertEquals(calculator.calculateFactorial(20), 2432902008176640000L);
        }

        @Test
        public void testCalculateFactorialBoundary () {
            Factorial calculator = new Factorial();
            assertEquals(calculator.calculateFactorial(0), 1); // Граничное значение 0
            assertEquals(calculator.calculateFactorial(1), 1); // Граничное значение 1
        }
    }
=======
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void testCalculateFactorial() {
        Factorial calculator = new Factorial();
        assertEquals(1, calculator.calculateFactorial(0));
        assertEquals(1, calculator.calculateFactorial(1));
        assertEquals(2, calculator.calculateFactorial(2));
        assertEquals(6, calculator.calculateFactorial(3));
        assertEquals(24, calculator.calculateFactorial(4));
        assertEquals(120, calculator.calculateFactorial(5));
        assertEquals(40320, calculator.calculateFactorial(8));

    }

    @Test
    public void testCalculateFactorialBoundary() {
        Factorial calculator = new Factorial();
        assertEquals(1, calculator.calculateFactorial(0)); // Граничное значение 0
        assertEquals(1, calculator.calculateFactorial(1)); // Граничное значение 1
    }


}


