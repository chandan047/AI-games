package puzzle;
import basic.BestFirstSearch;
import basic.QueueSearch;



public class AStarSearch extends BestFirstSearch {

	public AStarSearch(QueueSearch search) {
		super(search, new AStarEvaluationFunction());
	}
}