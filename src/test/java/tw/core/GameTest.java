package tw.core;

import org.junit.Before;
import org.junit.Test;

import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
	private Answer answer;
	private Game game;
	
	@Before
	public void setup() throws OutOfRangeAnswerException{
		answer = Answer.createAnswer("1 2 3 4");
		AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
		when(answerGenerator.generate()).thenReturn(answer);
		game = new Game(answerGenerator);
	}
    
	@Test
	public void should_return_success_when_inputanswer_is_correct(){
		Answer inputAnswer = Answer.createAnswer("1 2 3 4");
		game.guess(inputAnswer);
	    
		assertEquals(game.checkStatus(), "success");
	}
	
	@Test
	public void should_return_continue_when_guesscount_is_under_six(){
		Answer inputAnswer = Answer.createAnswer("5 6 7 8");
		game.guess(inputAnswer);
	    
		assertEquals(game.checkStatus(), "continue");
	}
	
	@Test
	public void should_return_fail_when_guesscount_is_beyond_six(){
		game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        
		assertEquals(game.checkStatus(), "fail");
	}
}
