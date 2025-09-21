Synchronization Simulation using Semaphores

Problem Definition
This project simulates a limited number of devices connected to a router’s Wi-Fi using Java threading and semaphores. The router restricts the number of concurrent connections to a specified maximum. When the maximum number of connections (N) is reached, the router will not accept additional connections until an existing connection is released. The implementation demonstrates how semaphores can be utilized to control and synchronize access to the router's Wi-Fi connections.

Solution Design
The program consists of several classes, each responsible for a different aspect of the simulation:

1. **Router Class**:
   - Manages a list of active connections.
   - Contains methods to handle the occupation and release of connections.

2. **Semaphore Class**:
   - Manages the synchronization of threads, ensuring that no more than N devices are connected at any time.

3. **Device Class**:
   - Represents the devices (threads) that attempt to connect to the router.
   - Each device has a name and type (e.g., mobile, pc, tablet).
   - Simulates three main activities: connect, perform online activity, and disconnect/logout, with each action represented by printed messages and random waiting times.

4. **Network Class**:
   - Contains the `main` method.
   - Prompts the user for the maximum number of connections (`N`) the router can handle and the total number of devices (`TC`) that wish to connect.
   - Reads device information and initiates the simulation.

Program Execution
- Initially, no devices are connected to the Wi-Fi.
- When a device attempts to connect, it logs in if there are available connections. If all connections are occupied, the device waits until a connection becomes available.
- Once connected, the device performs online activities and then logs out, freeing up a connection for any waiting devices.
- The simulation continues until all devices have connected and logged out.

Sample Input/Output

Sample Input:
```
What is the number of WI-FI Connections?
2
What is the number of devices Clients want to connect?
4
C1 mobile
C2 tablet
C3 pc
C4 pc
```

Sample Output:
```
- (C1)(mobile) arrived
- (C2)(tablet) arrived
- Connection 1: C1 Occupied
- Connection 2: C2 Occupied
- C4 (pc) arrived and waiting
- C3 (pc) arrived and waiting
- Connection 1: C1 login
- Connection 1: C1 performs online activity
- Connection 2: C2 login
- Connection 2: C2 performs online activity
- Connection 1: C1 Logged out
- Connection 1: C4 Occupied
- Connection 1: C4 login
- Connection 1: C4 performs online activity
- Connection 2: C2 Logged out
- Connection 2: C3 Occupied
```

Notes
- The program prints the execution order and actions of each device to a log file.
- It handles various scenarios, ensuring accurate synchronization using semaphores.
- Error handling ensures the program operates smoothly even when devices arrive simultaneously or in rapid succession.

By simulating device connections to a Wi-Fi router using Java threads and semaphores, this project provides a practical demonstration of synchronization in concurrent programming.
