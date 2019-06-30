package tw.core;

import org.junit.Before;
import org.junit.Test;

import tw.validator.InputValidator;

import static org.junit.Assert.assertEquals;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;
    
    @Before
    public void setup(){
    	inputValidator = new InputValidator();
    }
	
    @Test
    public void should_return_true_when_digitscount_is_4(){
		assertEquals(inputValidator.validate("1 2 3 4"), true);
	}
    
	@Test
    public void should_return_false_when_digitscount_is_not_4(){
		assertEquals(inputValidator.validate("1 2 3"), false);
		assertEquals(inputValidator.validate("1 2 3 4 5"), false);
	}
	
	@Test
    public void should_return_false_when_singledigit_is_legal(){
		assertEquals(inputValidator.validate("0 1 2 9"), true);
	}
	
	@Test
    public void should_return_false_when_singledigit_is_illegal(){
		assertEquals(inputValidator.validate("1 2 3 10"), false);
//		assertEquals(inputValidator.validate("1 2 3 -1"), false);
	}
	
	@Test
    public void should_return_false_when_singledigit_is_legal_but_repeated(){
		assertEquals(inputValidator.validate("1 1 3 4"), false);
	}
}
