# Ex 7 viva — NS2 and congestion control

1. **What is NS2?** An open-source discrete-event network simulator written in C++ with an OTcl front end.
2. **What is discrete-event simulation?** Events are kept in a time-ordered list and processed one by one; each can schedule future events.
3. **What are the trace file and NAM file?** Trace (`.tr`) logs every packet event for analysis. NAM (`.nam`) drives the network animator.
4. **Trace line fields?** `event time from to type size flags flow src dst seq id`; event is `+` enqueue, `-` dequeue, `r` receive, `d` drop.
5. **What is congestion?** Too much traffic for the network's capacity, causing queue overflow, delay and packet loss.
6. **Congestion control vs flow control?** Congestion control protects the network (cwnd). Flow control protects the receiver (rwnd). TCP sends min(cwnd, rwnd).
7. **What is slow start?** cwnd starts at 1 MSS and doubles each RTT (exponential growth) until `ssthresh` or a loss.
8. **What is AIMD?** After ssthresh, cwnd grows by 1 MSS per RTT (additive increase) and is halved on loss (multiplicative decrease). It produces the sawtooth graph and fair sharing between flows.
9. **What is fast retransmit?** Three duplicate ACKs trigger retransmission of the lost segment without waiting for the timeout.
10. **What is fast recovery?** After fast retransmit, set ssthresh = cwnd/2 and continue in congestion avoidance instead of restarting slow start.
11. **Tahoe vs Reno?** Tahoe resets cwnd to 1 on any loss. Reno uses fast recovery and halves cwnd on 3 duplicate ACKs.
12. **What does DropTail mean?** The queue drops arriving packets when it is full. RED drops early and randomly to signal congestion sooner.
13. **Why the small queue limit in the script?** A bottleneck queue of 10 forces losses so the congestion control behaviour is visible.
14. **Performance metrics?** Throughput, delay, packet loss, queue length.
