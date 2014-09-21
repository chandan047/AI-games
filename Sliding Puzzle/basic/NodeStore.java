package basic;

import java.util.List;

public interface NodeStore {
	public void add(Node anItem);

	public Node remove();

	public void add(List<Node> nodes);

	public boolean isEmpty();

	public int size();
}