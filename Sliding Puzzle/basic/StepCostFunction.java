package basic;

public interface StepCostFunction {
	Double calculateStepCost(Object fromState, Object toState, Move move);
}
