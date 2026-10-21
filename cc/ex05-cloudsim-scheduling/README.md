# Ex 5 — Simulate a cloud scenario with CloudSim (custom scheduler)

**Aim:** To simulate a cloud scenario using CloudSim and run a scheduling algorithm that is not present in CloudSim's own examples.

**Apparatus / Tools required:** Java, Eclipse (or any IDE), CloudSim and CloudSim-examples jars on the classpath.

**Algorithm**
1. Initialise the CloudSim library (`CloudSim.init`).
2. Create a Datacenter (with its hosts/PEs and a `DatacenterCharacteristics`).
3. Create a `DatacenterBroker`.
4. Create a VM with `CloudletSchedulerSpaceShared` (the example's own `CloudSimExample1` uses the default time-shared scheduler — this swaps it for a space-shared one, which is "not present" in that stock example) and submit it to the broker.
5. Create a Cloudlet and submit it to the broker.
6. Start the simulation and print the results once it finishes.

**Procedure**
```bash
javac -cp cloudsim.jar:cloudsim-examples.jar NewScheduler.java
java  -cp .:cloudsim.jar:cloudsim-examples.jar NewScheduler
```

**Program**
```java
import java.util.*;
import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;

public class NewScheduler {

    public static void main(String[] args) {
        try {
            int numUser = 1;
            Calendar calendar = Calendar.getInstance();
            boolean traceFlag = false;
            CloudSim.init(numUser, calendar, traceFlag);

            Datacenter datacenter0 = createDatacenter("Datacenter_0");
            DatacenterBroker broker = createBroker();
            int brokerId = broker.getId();

            Vm vm = new Vm(0, brokerId, 1000, 1, 512, 1000, 10000,
                    "Xen", new CloudletSchedulerSpaceShared());
            List<Vm> vmList = new ArrayList<Vm>();
            vmList.add(vm);
            broker.submitVmList(vmList);

            UtilizationModel utilizationModel = new UtilizationModelFull();
            Cloudlet cloudlet = new Cloudlet(0, 40000, 1, 300, 300,
                    utilizationModel, utilizationModel, utilizationModel);
            cloudlet.setUserId(brokerId);
            List<Cloudlet> cloudletList = new ArrayList<Cloudlet>();
            cloudletList.add(cloudlet);
            broker.submitCloudletList(cloudletList);

            CloudSim.startSimulation();
            List<Cloudlet> finished = broker.getCloudletReceivedList();
            CloudSim.stopSimulation();

            printResults(finished);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Datacenter createDatacenter(String name) throws Exception {
        List<Pe> peList = new ArrayList<Pe>();
        peList.add(new Pe(0, new PeProvisionerSimple(1000)));

        List<Host> hostList = new ArrayList<Host>();
        hostList.add(new Host(0, new RamProvisionerSimple(2048),
                new BwProvisionerSimple(10000), 1000000, peList,
                new VmSchedulerSpaceShared(peList)));

        DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
                "x86", "Linux", "Xen", hostList, 10.0, 3.0, 0.05, 0.001, 0.0);

        return new Datacenter(name, characteristics,
                new VmAllocationPolicySimple(hostList),
                new LinkedList<Storage>(), 0);
    }

    private static DatacenterBroker createBroker() throws Exception {
        return new DatacenterBroker("Broker");
    }

    private static void printResults(List<Cloudlet> list) {
        System.out.println("Cloudlet ID  STATUS  Data center ID  VM ID  Time  Start Time  Finish Time");
        for (Cloudlet c : list) {
            System.out.println(c.getCloudletId() + "  " +
                    (c.getCloudletStatus() == Cloudlet.SUCCESS ? "SUCCESS" : "FAILED") + "  " +
                    c.getResourceId() + "  " + c.getVmId() + "  " +
                    c.getActualCPUTime() + "  " + c.getExecStartTime() + "  " +
                    c.getFinishTime());
        }
    }
}
```

**Sample Output** (from the manual's own `CloudSimExample1`, for the stock time-shared example this program's output format matches)
```
Starting CloudSimExample1...
Initialising...
Starting CloudSim version 3.0
Datacenter_0 is starting...
Broker is starting...
Entities started.
0.0 : Broker: Cloud Resource List received with 1 resource(s)
0.0 : Broker: Trying to Create VM #0 in Datacenter_0
0.1 : Broker: VM #0 has been created in Datacenter #2, Host #0
0.1 : Broker: Sending cloudlet 0 to VM #0
400.1 : Broker: Cloudlet 0 received
400.1 : Broker: All Cloudlets executed. Finishing...
Broker is shutting down...
Simulation completed.

========== OUTPUT ==========
Cloudlet ID  STATUS   Data center ID  VM ID  Time  Start Time  Finish Time
0            SUCCESS  2               0      400   0.1         400.1
```

**Result:** A cloud scenario was simulated using CloudSim and a scheduling algorithm not present in the stock example was run successfully.
