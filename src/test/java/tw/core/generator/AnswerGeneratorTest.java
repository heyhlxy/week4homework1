package tw.core.generator;

import org.junit.Before;
import org.junit.Test;

import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotEquals;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    
	private RandomIntGenerator randomIntGenerator;
    
    @Before
    public void setup(){
    	randomIntGenerator = mock(RandomIntGenerator.class);
    }
    
    @Test(expected = OutOfRangeAnswerException.class)	
    public void should_throws_out_of_range_answer_exception_when_answer_is_out_of_range()
        throws OutOfRangeAnswerException {    	
    	//given
    	when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 10");
        
    	//when
    	AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        answerGenerator.generate();
    }
    
    @Test
    public void should_generate_answer() throws OutOfRangeAnswerException{
    	//given
    	when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
    	
    	//when
    	AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Answer answer = answerGenerator.generate();
        
        //then
        assertNotEquals(answer, null);
    }
}
