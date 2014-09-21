package basic;


import basic.HeuristicFunction;
import basic.StepCostFunction;
import basic.SuccessorFunction;
import basic.GoalTest;
import puzzle.DefaultStepCostFunction;

public class Puzzle {
	
	protected Object initialState;
	
	protected SuccessorFunction successorFunction;

	protected StepCostFunction stepCostFunction;

	protected GoalTest goalTest;
	
	protected HeuristicFunction heuristicFunction;

	protected Puzzle() {
	}

	public Puzzle(
			Object initialState,
			SuccessorFunction successorFunction,
			GoalTest goalTest) {
		this.initialState = initialState;
		this.successorFunction = successorFunction;
		this.goalTest = goalTest;
		this.stepCostFunction = new DefaultStepCostFunction();
	}

	public Puzzle(
			Object initialState,
			SuccessorFunction successorFunction,
			GoalTest goalTest,
			StepCostFunction stepCostFunction ) {
		this(initialState, successorFunction, goalTest);
		this.stepCostFunction = stepCostFunction;
	}

	public Puzzle(
			Object initialState,
			SuccessorFunction successorFunction,
			GoalTest goalTest,
			HeuristicFunction heuristicFunction ) {
		this(initialState, successorFunction, goalTest);
		this.heuristicFunction = heuristicFunction;
	}

	public Puzzle(
			Object initialState,
			SuccessorFunction successorFunction,
			GoalTest goalTest,
			StepCostFunction stepCostFunction,
			HeuristicFunction heuristicFunction ) {
		this(initialState, successorFunction, goalTest, stepCostFunction);
		this.heuristicFunction = heuristicFunction;
	}

	public Object getInitialState() {

		return initialState;
	}

	public boolean isGoalState(Object state) {

		return goalTest.isGoalState(state);
	}

	public StepCostFunction getStepCostFunction() {
		return stepCostFunction;
	}

	public SuccessorFunction getSuccessorFunction() {
		return successorFunction;
	}

	public HeuristicFunction getHeuristicFunction() {
		return heuristicFunction;
	}
	
}
