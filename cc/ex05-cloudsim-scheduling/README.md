# ex05 - CloudSim scheduling

## Aim
Simulate a cloud scenario with CloudSim and run a scheduling algorithm not shipped with CloudSim (`CloudletSchedulerSpaceShared` instead of the default time-shared one).

## Run
Add the CloudSim jars to the classpath, then:
```
javac -cp cloudsim.jar:cloudsim-examples.jar NewScheduler.java
java  -cp .:cloudsim.jar:cloudsim-examples.jar NewScheduler
```

## Output
```
Cloudlet ID  STATUS  Data center ID  VM ID  Time  Start Time  Finish Time
0  SUCCESS  2  0  40.0  0.1  40.1
```
(exact timing varies by MIPS/host config, status and field order match the record)
