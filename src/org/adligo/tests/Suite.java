package org.adligo.tests;

/**
 * Title:
 * Description:  The base test suite for adligo tests
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */
import java.lang.reflect.Constructor;

import org.adligo.jse.util.JSECommonInit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite {

  static {
		JSECommonInit.callLogDebug(Suite.class.getName());
  }
	  
  public Suite() {
  }

  @SuppressWarnings("unchecked")
public static Test suite(String packageName, int iTests) {
    //BasicConfigurator.configure();
    TestSuite suite= new TestSuite();
    try {
      for (int i = 0; i < iTests; i++) {
        Class c = Class.forName(packageName + "Test" + i);
        Class [] args = new Class[] {String.class};
        Constructor ct = c.getConstructor(args);
        Object [] sa = new Object [] {"test" + i};
        Object o = ct.newInstance(sa);
        suite.addTest((TestCase) o);
      }
    } catch (Exception x) {x.printStackTrace(); }

    //suite.addTest(new Test0("test0"));
    return suite;
  }
}