package org.adligo.tests;

/**
 * Title:
 * Description:  The base test suite for adligo tests
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */
import junit.framework.*;
import java.lang.reflect.*;

public class Suite {

  public Suite() {
  }

  public static Test suite(String packageName, int iTests) {
    //BasicConfigurator.configure();
    TestSuite suite= new TestSuite();
    try {
      for (int i = 0; i < iTests; i++) {
        Class c = Class.forName(packageName + "Test" + i);
        Class [] args = new Class[] {String.class};
        Constructor ct = c.getConstructor(args);
        String [] sa = new String [] {"test" + i};
        Object o = ct.newInstance(sa);
        suite.addTest((TestCase) o);
      }
    } catch (Exception x) {x.printStackTrace(); }

    //suite.addTest(new Test0("test0"));
    return suite;
  }
}