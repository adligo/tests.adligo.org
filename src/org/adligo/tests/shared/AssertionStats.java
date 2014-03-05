package org.adligo.tests.shared;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.log.shared.Log;
import org.adligo.i.log.shared.LogFactory;


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
	private static final String ALL_OF_THE_PACKAGES_MUST_MATCH_FOR_A_ARRAY_OF_A_ASSERTIONS = "All of the packages must match for a array of AAssertions.";
	private static final Log log = LogFactory.getLog(AssertionStats.class);
	private static final Map<String, Integer> packageAsserts = new HashMap<String, Integer>();
	
	public static synchronized void logAssertionStats(Class<?> testClass, String packageName, int numAssertions) {
		if (log.isInfoEnabled()) {
			log.info("Test class " + testClass + " had " + numAssertions + " assertions.");
		}
		Integer currentCount = packageAsserts.get(packageName);
		if (currentCount == null) {
			currentCount = numAssertions;
			packageAsserts.put(packageName, numAssertions);
		} else {
			currentCount = currentCount + numAssertions;
			packageAsserts.put(packageName, currentCount);
		}
		log.warn("The package " + packageName + " now has " + currentCount + " assertions.");
	}
	
	public static synchronized void logAssertionStats(Class<?> testClass, AAssertions ... asserts) {
		if (asserts.length == 1) {
			logAssertionStats(testClass, asserts[0].getPackage(), asserts[0].getAssertionCount());
		} else {
			String packageName = asserts[0].getPackage();
			int total = 0;
			for (int i = 0; i < asserts.length; i++) {
				AAssertions aas = asserts[i];
				String pkg = aas.getPackage();
				if (!packageName.equals(pkg)) {
					throw new IllegalArgumentException(ALL_OF_THE_PACKAGES_MUST_MATCH_FOR_A_ARRAY_OF_A_ASSERTIONS);
				}
				total = total + aas.getAssertionCount();
			}
			logAssertionStats(testClass, packageName, total);
		}
		
	}
}
