package QueueStack;

public class Utils {

    public static void reverse(IQueue queueToBeReversed, IStack stackAuxiliary) {
        int hold = 0;

        while (!queueToBeReversed.isEmpty()) {
            try {
                hold = queueToBeReversed.dequeue();
                stackAuxiliary.push(hold);
            } catch (Exception e) {
                throw new RuntimeException("An error occurred.");
            }  
        }
        while (!stackAuxiliary.isEmpty()) {       
            hold = stackAuxiliary.pop();
            queueToBeReversed.enqueue(hold);
        }
    }
}
