package EightPuzzle;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import puzzle.AStarSearch;
import basic.GraphSearch;
import basic.Puzzle;
import basic.Search;
import basic.Move;
import basic.SearchAgent;

public class EightPuzzle {
    
	static EightPuzzleBoard boardWithThreeMoveSolution = new EightPuzzleBoard(
			new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });;

	static EightPuzzleBoard random1 = new EightPuzzleBoard(new int[] { 1, 4, 2,
			7, 5, 8, 3, 0, 6 });

	static EightPuzzleBoard extreme = new EightPuzzleBoard(new int[] { 0, 8, 7,
			6, 5, 4, 3, 2, 1 });

	public static void main(String[] args) {
		eightPuzzleAStar();
		//eightPuzzleAStarManhattan();
	}
	
	private static void eightPuzzleAStar() {
		System.out
				.println("\nEightPuzzleDemo AStar Search (MisplacedTileHeursitic)-->");
		try {
			Puzzle puzzle = new Puzzle(extreme,
					new EightPuzzleSuccessorFunction(),
					new EightPuzzleGoalTest(),
					new MisplacedTileHeuristicFunction());
			
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(puzzle, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			System.out.println(extreme.toString());
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
