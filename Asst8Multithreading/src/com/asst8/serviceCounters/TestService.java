/**
 * There are 2 order counters that order items at 1 second interval.
 * There are 4 service counters that services items at 1.5 second intervals.
 * 
 * The lack of speed of service counters is compensated with number of service counters.
 * 
 * So if 2 order counters get 6 orders in 3 seconds,
 * The 4 service counters can service 8 orders in 3 seconds.
 * 
 * Hence all orders will be taken care off even if service counter is slow.
 * 
 */

package com.asst8.serviceCounters;

public class TestService {

	public static void main(String[] args) {
		
		ServiceQueue singleServiceQueue = new ServiceQueue();
		
		OrderCounter orderCounterA = new OrderCounter("orderCounter_A", singleServiceQueue);
		OrderCounter orderCounterB = new OrderCounter("orderCounter_B", singleServiceQueue);
		
		ServiceCounter northServiceCounter = new ServiceCounter("northServiceCounter", singleServiceQueue);
		ServiceCounter southServiceCounter = new ServiceCounter("southServiceCounter", singleServiceQueue);
		ServiceCounter eastServiceCounter = new ServiceCounter("eastServiceCounter", singleServiceQueue);
		ServiceCounter westServiceCounter = new ServiceCounter("westServiceCounter", singleServiceQueue);
		
		orderCounterA.start();
		orderCounterB.start();
		
		northServiceCounter.start();
		southServiceCounter.start();
		eastServiceCounter.start();
		westServiceCounter.start();
		
	}

}
