package Animals;

public class AnimalCounter implements AutoCloseable {
    private int count = 0;
    private boolean isClosed = false;
    private boolean usedInTry = false;

    // Add method to increase counter
    public void add() {
        if (isClosed) {
            throw new IllegalStateException("The resource is closed and cannot be used.");
        }
        count++;
        System.out.println("Counter is increased");
    }

    @Override
    public void close() throws Exception {
        if (!usedInTry) {
            throw new IllegalStateException("Counter object wasn't used in a try-with-resources block.");
        }
        isClosed = true;
        System.out.println("Counter closed successfully");
    }

    public int getCount() {
        return count;
    }

    public void markUsedInTry() {
        usedInTry = true;
    }
}

