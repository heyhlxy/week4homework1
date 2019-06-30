package tw.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

	private Answer answer;
	private Answer inputAnswer;
	
	@Before
	public void setup(){
		answer = Answer.createAnswer("1 2 3 4");
	}
	@Test
	public void should_inputanswer_1567_output_1A0B_record(){
		inputAnswer = Answer.createAnswer("1 5 6 7");
	    assertEquals(answer.check(inputAnswer).getValue(), "1A0B");
	}
	
	@Test
	public void should_inputanswer_2478_output_0A2B_record(){
	    inputAnswer = Answer.createAnswer("2 4 7 8"); 
	    assertEquals(answer.check(inputAnswer).getValue(), "0A2B");
	}
	
	@Test
	public void should_inputanswer_0324_output_1A2B_record(){
	    inputAnswer = Answer.createAnswer("0 3 2 4"); 
	    assertEquals(answer.check(inputAnswer).getValue(), "1A2B");
	}
	
	@Test
	public void should_inputanswer_5678_output_0A0B_record(){
	    inputAnswer = Answer.createAnswer("5 6 7 8");
	    assertEquals(answer.check(inputAnswer).getValue(), "0A0B");
	}
	
	@Test
	public void should_inputanswer_4321_output_0A4B_record(){
	    inputAnswer = Answer.createAnswer("4 3 2 1");
	    assertEquals(answer.check(inputAnswer).getValue(), "0A4B");
	}
	
	@Test
	public void should_inputanswer_1234_output_4A0B_record(){
	    inputAnswer = Answer.createAnswer("1 2 3 4");
	    assertEquals(answer.check(inputAnswer).getValue(), "4A0B");
	}
}
