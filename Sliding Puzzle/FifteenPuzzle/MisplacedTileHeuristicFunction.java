package FifteenPuzzle;

import basic.HeuristicFunction;
import basic.XYLocation;

public class MisplacedTileHeuristicFunction implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		FifteenPuzzleBoard board = (FifteenPuzzleBoard) state;
		return getNumberOfMisplacedTiles(board);

	}

	private int getNumberOfMisplacedTiles(FifteenPuzzleBoard board) {
		int numberOfMisplacedTiles = 0;
		if (!(board.getLocationOf(0).equals(new XYLocation(0, 0)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(1).equals(new XYLocation(0, 1)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(2).equals(new XYLocation(0, 2)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(3).equals(new XYLocation(0, 3)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(4).equals(new XYLocation(1, 0)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(5).equals(new XYLocation(1, 1)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(6).equals(new XYLocation(1, 2)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(7).equals(new XYLocation(1, 3)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(8).equals(new XYLocation(2, 0)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(9).equals(new XYLocation(2, 1)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(10).equals(new XYLocation(2, 2)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(11).equals(new XYLocation(2, 3)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(12).equals(new XYLocation(3, 0)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(13).equals(new XYLocation(3, 1)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(14).equals(new XYLocation(3, 2)))) {
			numberOfMisplacedTiles++;
		}
		if (!(board.getLocationOf(15).equals(new XYLocation(3, 3)))) {
			numberOfMisplacedTiles++;
		}
		
		return numberOfMisplacedTiles;
	}

}
