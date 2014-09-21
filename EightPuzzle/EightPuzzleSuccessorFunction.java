package EightPuzzle;

import java.util.ArrayList;
import java.util.List;

import basic.Move;
import basic.Successor;
import basic.SuccessorFunction;

import EightPuzzle.EightPuzzleBoard;

public class EightPuzzleSuccessorFunction implements SuccessorFunction {
	
	public List<Successor> getSuccessors(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		List<Successor> successors = new ArrayList<Successor>();
		if (board.canMoveGap(Move.UP)) {
			EightPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapUp();
			successors.add(new Successor(Move.UP, newBoard));
		}
		if (board.canMoveGap(Move.DOWN)) {
			EightPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapDown();
			successors.add(new Successor(Move.DOWN, newBoard));
		}
		if (board.canMoveGap(Move.LEFT)) {
			EightPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapLeft();
			successors.add(new Successor(Move.LEFT, newBoard));
		}
		if (board.canMoveGap(Move.RIGHT)) {
			EightPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapRight();
			successors.add(new Successor(Move.RIGHT, newBoard));
		}
		return successors;
	}

	private EightPuzzleBoard copyOf(EightPuzzleBoard board) {
		EightPuzzleBoard newBoard = new EightPuzzleBoard();
		newBoard.setBoard(board.getPositions());
		return newBoard;
	}

}
