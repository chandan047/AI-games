package basic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphSearch extends QueueSearch {

	Set<Object> closed = new HashSet<Object>();

	// Need to override search() method so that I can re-initialize
	// the closed list should multiple calls to search be made.
	@Override
	public List<Move> search(Puzzle problem, NodeStore fringe) {
		closed.clear();
		return super.search(problem, fringe);
	}

	@Override
	public void addExpandedNodesToFringe(NodeStore fringe, Node node,
			Puzzle problem) {

		// if STATE[node] is not in closed then
		if (!(alreadySeen(node))) {
			// add STATE[node] to closed
			closed.add(node.getState());
			// fringe <- INSERT-ALL(EXPAND(node, problem), fringe)
			fringe.add(expandNode(node, problem));

		}
	}

	private boolean alreadySeen(Node node) {
		return closed.contains(node.getState());
	}
}