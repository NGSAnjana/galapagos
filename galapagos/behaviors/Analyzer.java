package galapagos.behaviors;

import galapagos.biotope.*;

/**
 * A behavior using memory and attempting to correlate actions with
 * reactions to maximize its gain.
 */
public class Analyzer extends AnalyzingBehavior {
    private static final String DESCRIPTION = 
        "<HTML>Tries to analyse the best action against a given finch<br>" + 
        "based on the points given for each possible outcome<br>" + 
        "and a memory of all previous meetings with that finch.</HTML>";
    
    private Behavior fallbackBehavior;
    private final static int HelpedGotHelpValue = 1;
    private final static int HelpedDidntGetHelpValue = -2;
    private final static int DidntHelpGotHelpValue = 3;
    private final static int DidntHelpDidntGetHelpValue = -1;

    /**
     * @inheritDoc
     */
    public String description() {
        return DESCRIPTION;
    }
    
    public Analyzer () {
        fallbackBehavior = new Predictor();
    }

    public void response(Finch finch, Action action) {
        registerReaction(finch, action);
        fallbackBehavior.response(finch, action);
    
    }
    
    public Action decide(Finch finch) {
        Analysis analysis = recall(finch);
        Action choice = fallbackBehavior.decide(finch);


        if (analysis != null) {
            int cleaningGoodness = 0;
            int ignoringGoodness = 0;
            
            for (Analysis.Interaction interaction : analysis) {
                Action action = interaction.action;
                Action reaction = interaction.reaction;
                if (action == Action.CLEANING) {
                    if (reaction == Action.CLEANING)
                        cleaningGoodness += HelpedGotHelpValue;
                    else if (reaction == Action.IGNORING)
                        cleaningGoodness += HelpedDidntGetHelpValue;
                } else if (action == Action.IGNORING){
                    if (reaction == Action.CLEANING)
                        ignoringGoodness += DidntHelpGotHelpValue;
                    if (reaction == Action.IGNORING)
                        ignoringGoodness += DidntHelpDidntGetHelpValue;
                }
            }
            if (cleaningGoodness != ignoringGoodness)
                choice = cleaningGoodness > ignoringGoodness ? Action.CLEANING
                    : Action.IGNORING;
        }

        registerAction(finch, choice);
        return choice;
    }

    public Behavior clone() {
        return new Analyzer();
    }

    public String toString() {
        return "Analyzer";
    }

    public boolean equals(Object obj) {
    	return obj instanceof Analyzer;
    }

    public int hashCode() {
    	return toString().hashCode();
    }
}
