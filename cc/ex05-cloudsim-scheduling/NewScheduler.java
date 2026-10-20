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
