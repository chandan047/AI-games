package FifteenPuzzle;

import java.util.ArrayList;
import java.util.List;

import basic.Move;
import basic.Successor;
import basic.SuccessorFunction;

import FifteenPuzzle.FifteenPuzzleBoard;

public class FifteenPuzzleSuccessorFunction implements SuccessorFunction {
	
	public List<Successor> getSuccessors(Object state) {
		FifteenPuzzleBoard board = (FifteenPuzzleBoard) state;
		List<Successor> successors = new ArrayList<Successor>();
		if (board.canMoveGap(Move.UP)) {
			FifteenPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapUp();
			successors.add(new Successor(Move.UP, newBoard));
		}
		if (board.canMoveGap(Move.DOWN)) {
			FifteenPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapDown();
			successors.add(new Successor(Move.DOWN, newBoard));
		}
		if (board.canMoveGap(Move.LEFT)) {
			FifteenPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapLeft();
			successors.add(new Successor(Move.LEFT, newBoard));
		}
		if (board.canMoveGap(Move.RIGHT)) {
			FifteenPuzzleBoard newBoard = copyOf(board);
			newBoard.moveGapRight();
			successors.add(new Successor(Move.RIGHT, newBoard));
		}
		return successors;
	}

	private FifteenPuzzleBoard copyOf(FifteenPuzzleBoard board) {
		FifteenPuzzleBoard newBoard = new FifteenPuzzleBoard();
		newBoard.setBoard(board.getPositions());
		return newBoard;
	}

}
