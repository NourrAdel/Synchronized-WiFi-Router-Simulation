import java.util.ArrayList;
import java.util.List;

class Router {
    private Semaphore semaphore;
    private List<String> connections;
    private int connectionIndex;

    public Router(int maxConnections) {
        semaphore = new Semaphore(maxConnections);
        connections = new ArrayList<>();
        connectionIndex = 1;
    }

    public void connect(String deviceName, String deviceType) {
        try {
            semaphore.P();
            if (connections.add(deviceName)) {
                System.out.println("- (" + deviceName + ")(" + deviceType + ") arrived");

            } else {
                System.out.println(" " + deviceName + " arrived and waiting");
            }


            // If this is the first connection, print "Occupied"
            if (connectionIndex == 1) {
                System.out.println("- Connection " + connectionIndex + ": " + deviceName + " Occupied");
            }

            // Log in
            System.out.println("- Connection " + connectionIndex + ": " + deviceName + " login");

            // Perform online activity
            performOnlineActivity(deviceName);

            // Release the connection
            disconnect(deviceName);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void performOnlineActivity(String deviceName) throws InterruptedException {
        System.out.println("- Connection " + connectionIndex + ": " + deviceName + " performs online activity");
        // Simulate online activity without using Thread.sleep
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 2000) {
            // Simulate online activity
        }
    }

    public void disconnect(String deviceName) {
        connections.remove(deviceName);
        semaphore.V();

        // If there are waiting clients, increment the connection index
        if (!connections.isEmpty()) {
            connectionIndex++;
        }

        System.out.println("- Connection " + connectionIndex + ": " + deviceName + " Logged out");
    }
}