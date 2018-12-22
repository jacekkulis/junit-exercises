package pl.dmcs.stringcalculator;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.dmcs.stringcalculator.utils.CalculatorService;
import pl.dmcs.stringcalculator.utils.ICalculatorService;
import pl.dmcs.stringcalculator.utils.StringCalculator;

import static org.mockito.Mockito.*;

class AdvancedStringCalculatorTest {

    @Mock
    ICalculatorService calculatorService = mock(CalculatorService.class);

    @InjectMocks
    StringCalculator stringCalculator = new StringCalculator(calculatorService);

    @Test
    void testCompute() {
        stringCalculator.compute("2+2");
        verify(calculatorService).compute("2+2");

        verify(calculatorService, never()).compute("2+3");


//        when(calculatorService.compute("2+2")).thenReturn(4.0);
//        assertEquals(4, stringCalculator.compute("2+2"));
        //verify(calculatorService).compute("2+2");
    }

}
