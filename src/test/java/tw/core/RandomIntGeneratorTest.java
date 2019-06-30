package tw.core;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import tw.core.generator.RandomIntGenerator;


/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
	
	RandomIntGenerator randomIntGenerator;
	
	@Before
    public void setup(){
	    randomIntGenerator	 = new RandomIntGenerator();
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void should_throws_illegal_argument_exception_when_numbersofneed_is_beyond_digitmax(){
		randomIntGenerator.generateNums(1, 2);
	}
	
	@Test
	public void should_generate_specified_count_random_nums_in_range(){
		String randomInt = randomIntGenerator.generateNums(10, 4);
	    Boolean isUnder = Arrays.stream(randomInt.split(" "))
	    		                     .map(num -> parseInt(num))
	    		                     .filter(num -> num < 10).count() == 4;
	    
	    assertEquals(isUnder, true);
	}
}
