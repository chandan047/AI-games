
package FifteenPuzzle;

import basic.*;

public class DefaultStepCostFunction implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {

		return new Double(1);
	}

}
