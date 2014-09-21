package EightPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import basic.XYLocation;
import basic.Move;

public class EightPuzzleBoard {
    
    public int[] getBoard() {
	return board;
    }

    int[] board;

    public EightPuzzleBoard() {
//    	List<Integer> bucket = Arrays.asList(0,1,2,3,4,5,6,7,8);
//    	Random gen = new Random();
//    	for(int i=0; i<8; i++) {
//    		int j = gen.nextInt(bucket.size()+1)-1;
//    		board[i] = bucket.remove(j);
//    	}
    	board = new int[] { 5, 4, 0, 6, 1, 8, 7, 3, 2 };
    }
    
    public EightPuzzleBoard(int[] _board) {
    	board = _board;
    }
    
    private int[] xycoordinatesFromAbsoluteCoordinate(int x) {
		int[] retVal = null;
		switch (x) {
		case 0:
			retVal = new int[] { 0, 0 };
			break;
		case 1:
			retVal = new int[] { 0, 1 };
			break;
		case 2:
			retVal = new int[] { 0, 2 };
			break;
		case 3:
			retVal = new int[] { 1, 0 };
			break;
		case 4:
			retVal = new int[] { 1, 1 };
			break;
		case 5:
			retVal = new int[] { 1, 2 };
			break;
		case 6:
			retVal = new int[] { 2, 0 };
			break;
		case 7:
			retVal = new int[] { 2, 1 };
			break;
		case 8:
			retVal = new int[] { 2, 2 };
			break;

		}
		return retVal;
	}
    
    private int absoluteCoordinatesFromXYCoordinates(int x, int y) {
		return x * 3 + y;
	}

	private int getValueAt(int x, int y) {
		// refactor this use either case or a div/mod soln
		return board[absoluteCoordinatesFromXYCoordinates(x, y)];
	}

	private int getGapPosition() {

		return getPositionOf(0);
	}

	private int getPositionOf(int val) {
		int retVal = -1;
		for (int i = 0; i < 9; i++) {
			if (board[i] == val) {
				retVal = i;
				return retVal;
			}
		}
		return retVal;
	}

	public XYLocation getLocationOf(int val) {
		int abspos = getPositionOf(val);
		int xpos = xycoordinatesFromAbsoluteCoordinate(abspos)[0];
		int ypos = xycoordinatesFromAbsoluteCoordinate(abspos)[1];
		return new XYLocation(xpos, ypos);
	}

	private void setValue(int xPos, int yPos, int val) {
		int abscoord = absoluteCoordinatesFromXYCoordinates(xPos, yPos);
		board[abscoord] = val;

	}

	public int getValueAt(XYLocation loc) {
		return getValueAt(loc.getXCoOrdinate(), loc.getYCoOrdinate());
	}

	public void moveGapRight() {
		int gapPosition = getGapPosition();
		int xpos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[0];
		int ypos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[1];
		if (!(ypos == 2)) {
			int valueOnRight = getValueAt(xpos, ypos + 1);
			setValue(xpos, ypos, valueOnRight);
			setValue(xpos, ypos + 1, 0);
		}

	}

	public void moveGapLeft() {
		int gapPosition = getGapPosition();
		int xpos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[0];
		int ypos = xycoordinatesFromAbsoluteCoordinate(getGapPosition())[1];
		if (!(ypos == 0)) {
			int valueOnLeft = getValueAt(xpos, ypos - 1);
			setValue(xpos, ypos, valueOnLeft);
			setValue(xpos, ypos - 1, 0);
		}

	}

	public void moveGapDown() {
		int gapPosition = getGapPosition();
		int xpos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[0];
		int ypos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[1];
		if (!(xpos == 2)) {
			int valueOnBottom = getValueAt(xpos + 1, ypos);
			setValue(xpos, ypos, valueOnBottom);
			setValue(xpos + 1, ypos, 0);
		}

	}

	public void moveGapUp() {
		int gapPosition = getGapPosition();
		int xpos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[0];
		int ypos = xycoordinatesFromAbsoluteCoordinate(gapPosition)[1];
		if (!(xpos == 0)) {
			int valueOnTop = getValueAt(xpos - 1, ypos);
			setValue(xpos, ypos, valueOnTop);
			setValue(xpos - 1, ypos, 0);
		}

	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		EightPuzzleBoard aBoard = (EightPuzzleBoard) o;

		for (int i = 0; i < 8; i++) {
			if (this.getPositionOf(i) != aBoard.getPositionOf(i)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 17;
		for (int i = 0; i < 8; i++) {
			int position = this.getPositionOf(i);
			result = 37 * result + position;
		}
		return result;
	}

	public List<XYLocation> getPositions() {
		ArrayList<XYLocation> retVal = new ArrayList<XYLocation>();
		for (int i = 0; i < 9; i++) {
			int[] res = xycoordinatesFromAbsoluteCoordinate(getPositionOf(i));
			XYLocation loc = new XYLocation(res[0], res[1]);
			retVal.add(loc);

		}
		return retVal;
	}

	public void setBoard(List<XYLocation> locs) {

		int count = 0;

		for (int i = 0; i < locs.size(); i++) {
			XYLocation loc = locs.get(i);
			this.setValue(loc.getXCoOrdinate(), loc.getYCoOrdinate(), count);
			count = count + 1;
		}
	}

	public boolean canMoveGap(Move where) {
		boolean retVal = true;
		int absPos = getPositionOf(0);
		if (where == Move.LEFT) {
			if ((absPos == 0) || (absPos == 3) || (absPos == 6)) {
				retVal = false;
			}
		}
		if (where == Move.RIGHT) {
			if ((absPos == 2) || (absPos == 5) || (absPos == 8)) {
				retVal = false;
			}
		}
		if (where == Move.UP) {
			if ((absPos == 0) || (absPos == 1) || (absPos == 2)) {
				retVal = false;
			}
		}
		if (where == Move.DOWN) {
			if ((absPos == 6) || (absPos == 7) || (absPos == 8)) {
				retVal = false;
			}
		}

		return retVal;
	}

	@Override
	public String toString() {
		String retVal = board[0] + " " + board[1] + " " + board[2] + "\n"
				+ board[3] + " " + board[4] + " " + board[5] + " " + "\n"
				+ board[6] + " " + board[7] + " " + board[8];
		return retVal;
	}

    
}
