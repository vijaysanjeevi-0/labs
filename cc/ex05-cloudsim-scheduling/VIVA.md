# ex05 viva — CloudSim scheduling

1. **What is a Datacenter in CloudSim?** A simulated resource provider: a collection of hosts with characteristics like architecture, OS and pricing.
2. **What is a Broker?** The entity that submits VMs and cloudlets on behalf of a user and mediates with the datacenter.
3. **What is a Cloudlet?** A simulated unit of work (a "job") with a defined length, file size and output size.
4. **Space-shared vs time-shared scheduling?** Space-shared gives each cloudlet a dedicated PE until it finishes; time-shared interleaves multiple cloudlets on the same PE.
5. **Why change the default `CloudletScheduler`?** To study how a different scheduling policy (space-shared here) affects completion time versus the CloudSim default.
