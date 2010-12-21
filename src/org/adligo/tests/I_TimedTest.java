package org.adligo.tests;

/**
 * note impls should use synchronized on these methods
 * to communicate between threads
 * 
 * @author scott
 *
 */
public interface I_TimedTest {
	public void setTimedout();
}
