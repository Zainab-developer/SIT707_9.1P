package web.service;

import org.junit.Assert;
import org.junit.Test;
import web.service.MathQuestionService;

public class TestMathQuestionService {

    @Test
    public void testQ1AdditionWithValidInputs() {
        double result = MathQuestionService.q1Addition("2", "3");
        Assert.assertEquals(5.0, result, 0);
    }

    @Test(expected = NumberFormatException.class)
    public void testQ1AdditionWithInvalidInput() {
        MathQuestionService.q1Addition("invalid", "3");
    }

    @Test
    public void testQ2SubtractionWithValidInputs() {
        double result = MathQuestionService.q2Subtraction("5", "2");
        Assert.assertEquals(3.0, result, 0);
    }

    @Test(expected = NumberFormatException.class)
    public void testQ2SubtractionWithInvalidInput() {
        MathQuestionService.q2Subtraction("5", "invalid");
    }
}
