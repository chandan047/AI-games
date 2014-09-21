
package puzzle;

import basic.*;

public class DefaultStepCostFunction implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			Move action) {

		return new Double(1);
	}

}
