import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.example.Calculadora;

public class TesteCalculadora {
    Calculadora calc = new Calculadora();

    //criar os teste
    @Test
    public void TesteSoma(){
        double resultado = calc.soma(3, 8);
        assertEquals(11, resultado, 0);
    }

    @Test
    public void TesteSubtrai(){
        double resultado = calc.subtrai(10, 5);
        assertEquals(5, resultado, 0);
    }

    @Test
    public void TesteMulti(){
        double resultado = calc.multiplica(4, 6);
        assertEquals(24, resultado, 0);
    }

    @Test
    public void TesteDivisao(){
        double resultado = calc.divide(12, 3);
        assertEquals(4, resultado, 0);
    }

    @Test
    public void TesteDivisaoZero(){      
        assertThrows(IllegalArgumentException.class,()-> calc.divide(10, 0));
    }

}
