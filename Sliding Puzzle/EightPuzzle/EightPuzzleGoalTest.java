package EightPuzzle;
import basic.GoalTest;
import EightPuzzle.EightPuzzleBoard;


public class EightPuzzleGoalTest implements GoalTest {
	
	EightPuzzleBoard goal = new EightPuzzleBoard(new int[] { 0, 1, 2, 3, 4, 5,6, 7, 8 });

	public boolean isGoalState(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		return board.equals(goal);
	}
	
}
