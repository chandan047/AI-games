package basic;

import java.util.List;

public interface Search {

	List search(Puzzle p) throws Exception;
	
	Metrics getMetrics();
	
}
