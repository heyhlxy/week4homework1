package tw.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.model.GuessResult;
import tw.views.GameView;
import static org.mockito.Mockito.*;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    
	private GameController gameController;
    private Game game;
    private GameView mockgameView;
    private InputCommand inputCommand;
    
    private Answer answer;
    
    @Before
    public void setup(){
    	game = mock(Game.class);
    	mockgameView =  mock(GameView.class); //Mockito cannot mock this class: class tw.views.GameView?jdk
    	inputCommand = mock(InputCommand.class);
    	
    	gameController = new GameController(game, mockgameView);	
    }
    
    @Test
    public void should_begin_game() throws IOException{
    	gameController.beginGame();
    	
    	verify(mockgameView).showBegin();
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void should_show_guess_result_and_history_when_play_game() throws IOException{
        //given
    	when(game.checkCoutinue()).thenReturn(true, false);
    	
    	answer = Answer.createAnswer("1 2 3 4");
    	when(inputCommand.input()).thenReturn(answer); 
    	
    	when(game.guess(answer)).thenReturn(new GuessResult("", answer));
    	when(game.guessHistory()).thenReturn(new ArrayList<GuessResult>());
    	
        //when
    	gameController.play(inputCommand);
    	
    	//then
    	verify(mockgameView).showGuessResult(any());
    	verify(mockgameView).showGuessHistory(anyList());
    }
    
    @Test
    public void should_show_fail_status_when_game_ends() throws IOException{
    	//given
    	when(game.checkCoutinue()).thenReturn(false);
    	when(game.checkStatus()).thenReturn("");
    	
    	//when
    	gameController.play(inputCommand);
    	
    	//then
    	verify(mockgameView).showGameStatus(anyString());
    }
}
