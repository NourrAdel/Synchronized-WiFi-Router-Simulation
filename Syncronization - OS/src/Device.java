// Class representing a device that connects to a router
class Device extends Thread {
    private String name; // Name of the device
    private String type; // Type of the device
    private Router router; // Router to which the device connects

    // Constructor to initialize the device with a name, type, and router
    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    // The main execution method when the thread is started
    @Override
    public void run() {
        // Attempt to connect the device to the router
        router.connect(name, type);
    }
}
