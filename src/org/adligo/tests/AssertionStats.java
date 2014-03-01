package org.adligo.tests;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.log.shared.Log;
import org.adligo.i.log.shared.LogFactory;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

/**
 * This is just a helper class to log assertions at the test level
 * outside of the test log, so that the number of assertions can be tracked
 * to improve test quality.  To use 
 * extend ATest and instantiate a number of classes which extend AAssertions
 * then call this in a method with the @AfterClass annotation
 * 
 * @author scott
 *
 */
public class AssertionStats {
	private static final Log log = LogFactory.getLog(AssertionStats.class);
	private static final Map<String, Integer> packageAsserts = new HashMap<String, Integer>();
	
	public static synchronized void logAssertionStats(Class<?> testClass, String packageName, int numAssertions) {
		if (log.isInfoEnabled()) {
			log.info("Test class " + testClass + " had " + numAssertions + " assertions.");
		}
		Integer currentCount = packageAsserts.get(packageName);
		if (currentCount == null) {
			packageAsserts.put(packageName, numAssertions);
		} else {
			currentCount = currentCount + numAssertions;
			packageAsserts.put(packageName, currentCount);
		}
		log.warn("The package " + packageName + " now has " + currentCount + " assertions.");
	}
}
