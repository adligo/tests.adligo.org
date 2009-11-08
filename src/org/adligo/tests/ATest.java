package org.adligo.tests;


/**
 * Title:
 * Description:   This is the default testing api for Adligo if you are writeing a test
 *               for the adligo code extend this class and use
 *               the methods in this class for your test assertions
 *
 *               Do not use the JUnit Asssert methods, for your assertions!
 *               The problem with these methods is that you they don't know when your
 *               events have finised occuring! Or the threads that your code may light up
 *               finish.
 *
 *               This class was written because the other multi threaded testers that I saw
 *               were relying on the fact that you were going to light up your threads inside the
 *               test, but what if the code you are testing lights up the threads?
 *               So here we are go ATest go
 *
 *
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

import junit.framework.TestCase;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.tests.I_RunnableTest;
import org.adligo.tests.client.I_Test;


public class ATest extends TestCase implements I_Test {
  static Log log = LogFactory.getLog(ATest.class);
  private boolean bLastTestFinished = false;
  private boolean bLastOne = false;
  private boolean bHasCalledWaiter = false;
  String sError = null;
  String sTestName;
  
  static {
		InitJ2SE.init();
  }
  
  public ATest() {
	  super();
  }
  
  public ATest(String s) {
    super(s.substring(s.lastIndexOf(".") + 1 ,s.length()));
    sTestName = s;
  }

  /* call this at the end of each test method that you call!
   * if you are useing a events style test
  */
  public void waiter() {
    bHasCalledWaiter = true;
    while (!bLastTestFinished || bLastOne) {
      try {
        if (log.isInfoEnabled()) {
          log.info("*WAITING For " + super.getName() + " Events to finish ");
        }
        bLastOne = false;
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Thread.yield();
        Thread.sleep(2000);
      } catch (Exception x) {}
    }
    if (sError != null) {
      super.assertTrue(sError, false);
    }
  }

  public void runTests(I_RunnableTest [] tests) {
    for (int i = 0; i < tests.length; i++) {
      new Thread(tests[i]).run();
    }
    while (!areTheyAllDone(tests)) {
      if (log.isInfoEnabled()) {
        log.info("*WAITING For " + super.getName() + " Events to finish ");
      }
      bLastOne = false;
      try {
        Thread.sleep(500);
      } catch (Exception x) { x.printStackTrace(); }
    }
    for (int i = 0; i < tests.length; i++) {
      if (tests[i].getError() != null) {
        this.setError(tests[i].getError());
      }
    }
    if (sError != null) {
      super.assertTrue(sError, false);
    }
  }

  private boolean areTheyAllDone(I_RunnableTest [] tests) {
    for (int i = 0; i < tests.length; i++) {
      if (!tests[i].isFinished()) {
        return false;
      }
    }
    return true;

  }


  public void logStart() {
    log.warn("test " + sTestName + " is starting\n\n\n\n\n");
  }
  
  public void setLastTestFinished() {
    bLastOne = true;
    bLastTestFinished = true;
    log.warn("test " + sTestName + " is finished");
  }

  public void setError(String s) {
    sError = s;
    if (!bHasCalledWaiter) {
      super.assertTrue(sError, false);
    }
    System.out.println("test " + sTestName + ".setError reports \n" + s);
    setLastTestFinished();
  }


  /**
   * checks to see if the int pi is in the int array iTestOne
   * also returns true if iTestOne contains a -1
   */
  public static boolean testThis(int [] iTestOne, int pi) {
    for (int i = 0; i < iTestOne.length; i++) {
      if (iTestOne[i] == -1 || iTestOne[i] == pi) {
        return true;
      }
    }
    return false;

  }
  
	@Override
	public void assertIsEquals(Object a, Object b) {
		assertEquals(a, b);
	}

	@Override
	public void assertIsEquals(String message, Object a, Object b) {
		assertEquals(message, a, b);
	}

	@Override
	public void assertIsFalse(boolean p) {
		assertFalse(p);
	}

	@Override
	public void assertIsFalse(String message, boolean p) {
		assertFalse(message, p);
	}

	@Override
	public void assertIsNotNull(Object a) {
		assertNotNull(a);
	}

	@Override
	public void assertIsNotNull(String message, Object a) {
		assertNotNull(message, a);
	}

	@Override
	public void assertIsNull(Object a) {
		assertNull(a);
	}

	@Override
	public void assertIsNull(String message, Object a) {
		assertNull(message, a);
	}

	@Override
	public void assertIsTrue(boolean p) {
		assertTrue(p);
	}

	@Override
	public void assertIsTrue(String message, boolean p) {
		assertTrue(message, p);
	}
}