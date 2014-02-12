package org.adligo.tests;

import org.adligo.i.log.shared.Log;
import org.adligo.i.log.shared.LogFactory;

/**
 * this class is used to help write a JUnit test that 
 * tests multi threaded code
 * 
 * in a nutshell it would be used as follows (the following is a psudo JUnit test)
 * 
 * Runnable runThroughYourMethodA = someImpl(this);
 * Runnable runThroughYourMethodB = someImpl(this);
 * boolean aDone = false;
 * boolean bDone = false;
 * boolean timedOut = false;
 * 
 * testSomethingAsJUnitTest() {
 * 		//note at end of runThroughYourMethod call done on this (the Junit test)
 * 	    Thread threadA = new Thread( runThroughYourMethodA);
 * 		Thread threadB = new Thread( runThroughYourMethodB);
 * 
 *      //would timeout after 5 seconds
 *      TestTimeoutRunnable testTimeoutRunnable = new TestTimeoutRunnable(5000, this);
 *      Thread timeOutThread = new Thread(testTimeoutRunnable);
 * 		threadA.start();
 *      threadB.start();
 *      timeOutThread.start();
 * 
 * 		while (!allDone()) {
 * 			if (timedOut) {
 *				long endTime = System.currentTimeMillis();
 *				long time = endTime - startTime;
 *				//note this assertion happens on the JUnit main thread,
 *				// so it will show up in eclipse exc
 *				assertTrue("testSomethingAsJUnitTest timedout after " + time + " millis",false);
 *			}
 *			Thread.sleep(1000);
 * 		}
 * 		//assert conditions that should be true after the runThroughYourMethod code is finished
 * 		// assert here to keep your assertions on the JUnit main thread
 *      // so it will show up in eclipse exc
 *      
 *      testTimeoutRunnable..setFinished(true);
 * }
 * 
 * synchronized void setTimedout() {
 * 	  timedOut = true;
 * }
 *  // note you may want to have a more specific class as a parameter here to aggregate results exc
 * synchronized done(Runnable p) {
 * 		if (p.equals(runThroughYourMethodA)) {
 * 			aDone = true;
 * 		}
 * 		if (p.equals(runThroughYourMethodB)) {
 * 			bDone = true;
 * 		}
 * }
 * 
 * boolean allDone() {
 * 	 if (!aDone) {
 *      return false;
 *   }
 *   if (!bDone) {
 *      return false;
 *   }
 *   return true;
 * }
 * @author scott
 *
 */
public class TestTimeoutRunnable implements Runnable {
	private static final Log log = LogFactory.getLog(TestTimeoutRunnable.class);
	private long maxDuration;
	private I_TimedTest test;
	
	/**
	 * set this to true when your test is done
	 * so it doesn't call the timeout
	 */
	private boolean finished = false;
	
	public TestTimeoutRunnable(int pMaxDuration, I_TimedTest pTest) {
		maxDuration = pMaxDuration;
		test = pTest;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(maxDuration);
			if (!finished) {
				test.setTimedout();
			} 
		} catch (InterruptedException x) {
			log.error(x.getMessage(), x);
		}
	}
	public synchronized boolean isFinished() {
		return finished;
	}
	public synchronized void setFinished(boolean finished) {
		this.finished = finished;
	}

}
