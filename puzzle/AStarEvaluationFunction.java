package puzzle;
import basic.EvaluationFunction;
import basic.Node;
import basic.Puzzle;

public class AStarEvaluationFunction implements EvaluationFunction {

	public AStarEvaluationFunction() {
	}

	public Double getValue(Puzzle p, Node n) {
		// f(n) = g(n) + h(n)
		return new Double( n.getPathCost() + p.getHeuristicFunction().getHeuristicValue(n.getState()) );
	}
	
}
