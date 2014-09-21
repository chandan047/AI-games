package FifteenPuzzle;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import puzzle.AStarSearch;
import basic.GraphSearch;
import basic.Puzzle;
import basic.Search;
import basic.Move;
import basic.SearchAgent;

public class FifteenPuzzle {
    
	static FifteenPuzzleBoard boardWithThreeMoveSolution = new FifteenPuzzleBoard(
			new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });;

	static FifteenPuzzleBoard random1 = new FifteenPuzzleBoard(new int[] { 12, 1, 4, 9, 2, 7, 11, 5, 14, 10, 15, 8, 3, 0, 13, 6 });

	static FifteenPuzzleBoard extreme = new FifteenPuzzleBoard(new int[] { 0,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1 });

	public static void main(String[] args) {
		FifteenPuzzleAStar();
		//FifteenPuzzleAStarManhattan();
	}
	
	private static void FifteenPuzzleAStar() {
		System.out
				.println("\nFifteenPuzzleDemo AStar Search (MisplacedTileHeursitic)-->");
		try {
			Puzzle puzzle = new Puzzle(random1,
					new FifteenPuzzleSuccessorFunction(),
					new FifteenPuzzleGoalTest(),
					new MisplacedTileHeuristicFunction());
			
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(puzzle, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			System.out.println(random1.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void printActions(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			Move action = (Move) actions.get(i);
			System.out.println(action);
		}
	}
	
	private static void printInstrumentation(Properties properties) {
		Iterator keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}
	
}
