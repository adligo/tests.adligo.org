package org.adligo.tests;

import junit.framework.TestCase;

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

import org.apache.commons.logging.*;
import org.adligo.i.tests.I_RunnableTest;

import junit.framework.*;

public class ATest extends TestCase {
  static Log log = LogFactory.getLog(ATest.class);
  private boolean bLastTestFinished = false;
  private boolean bLastOne = false;
  String sError = null;

  public ATest(String s) {
    super(s);
  }

  /* call this at the end of each test method that you call!
   * if you are useing a events style test
  */
  public void waiter() {
    while (!bLastTestFinished || bLastOne) {
      try {
        if (log.isInfoEnabled()) {
          log.info("*WAITING For " + super.getName() + " Events to finish ");
        }
        bLastOne = false;
        Thread.sleep(500);
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

  }

  private boolean areTheyAllDone(I_RunnableTest [] tests) {
    for (int i = 0; i < tests.length; i++) {
      if (!tests[i].isFinished()) {
        return false;
      }
    }
    return true;

  }


  public void setLastTestFinished() {
    bLastOne = true;
    bLastTestFinished = true;
  }

  public void setError(String s) {
    sError = s;
    setLastTestFinished();
  }
}