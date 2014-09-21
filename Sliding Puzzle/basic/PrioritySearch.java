package basic;

import java.util.Comparator;
import java.util.List;

public abstract class PrioritySearch implements Search {
	protected QueueSearch search;

	public List search(Puzzle p) throws Exception {
		return search.search(p, new PriorityNodeStore(getComparator(p)));
	}

	public Metrics getMetrics() {
		return search.getMetrics();
	}

	//
	// PROTECTED METHODS
	//
	protected abstract Comparator<Node> getComparator(Puzzle p);
}
