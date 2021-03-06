package galapagos.tests;

import galapagos.behaviors.*;
import galapagos.biotope.*;

/**
 * Test that the Analyzer behavior works properly.
 */
public class AnalyzerTest extends BehaviorTest {
	/**
	 * The decision-test only makes sure that no exceptions are
	 * thrown. This is because it is in the nature of the Analyzer
	 * behavior to be probabilistic and vague, which makes it hard to
	 * create and test hard rules for its behavior. Also, we do not
	 * believe that it makes sense to test the decision-making aspect of
	 * the behavior, as the determination algorithm is not specified, but
	 * an implementation detail.
	 */
    public void testDecide()
    {
    	try {
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.CLEANING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.CLEANING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.CLEANING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.IGNORING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.CLEANING);
        behavior.decide(opponent);
        behavior.response(opponent, Action.CLEANING);
        behavior.decide(opponent);
        } catch(Exception e) {
        	fail(e.getMessage());
        }
    }

    public Behavior getBehavior() {
        return new Analyzer();
    }

    public String behaviorName () {
    	return "Analyzer";
    }
}
