package galapagos;

public class FlipFlopper implements Behavior {
    Action last = Action.IGNORING;
    /**
     * 
     */
    public Action decide(Finch finch) {
        switch (last) {
        case CLEANING:
            last = Action.IGNORING;
            break;
        case IGNORING:
            last = Action.CLEANING;            
            break;
        }   

        return last;
    }

    /**
     * 
     */
    public void response(Finch finch, Action action) {
        
    }
}