import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The main class representing the network simulation
class Network {
    public static void main(String[] args) throws InterruptedException {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Get the max number of connections a router can accept
        System.out.println("What is the number of WI-FI Connections?");
        int maxConnections = scanner.nextInt();

        // Get the total number of devices that wish to connect
        System.out.println("What is the number of devices Clients want to connect?");
        int totalDevices = scanner.nextInt();

        // Create a router with the specified max connections
        Router router = new Router(maxConnections);

        // Collect input for each device
        List<DeviceInput> deviceInputs = new ArrayList<>();
        for (int i = 1; i <= totalDevices; i++) {
            System.out.println("Enter details for device " + i + " (Name Type):");
            String name = scanner.next();
            String type = scanner.next();
            deviceInputs.add(new DeviceInput(name, type));
        }

        // Simulate the connections by creating and starting threads for each device
        for (DeviceInput deviceInput : deviceInputs) {
            new Device(deviceInput.name, deviceInput.type, router).start();
        }

        // Close the scanner to release system resources
        scanner.close();
    }

    // A private inner class representing the input details of a device
    private static class DeviceInput {
        String name;
        String type;

        DeviceInput(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }
}
