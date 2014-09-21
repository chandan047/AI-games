package basic;

public class Successor {
	private Move action;

	private Object state;

	public Successor(Move action, Object state) {
		this.action = action;
		this.state = state;
	}

	public Move getAction() {
		return action;
	}

	public Object getState() {
		return state;
	}
}
