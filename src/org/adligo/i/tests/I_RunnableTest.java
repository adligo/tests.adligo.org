package org.adligo.i.tests;

/**
 * @deprecated use I_TimedTest and TestTimeoutRunnable
 * 
 * Title:
 * Description:
 * Company:
 * @author
 * @version 1.0
 */

public interface I_RunnableTest extends Runnable {
  public boolean isFinished();
  /**
   * should return null if there wasn't a error
   */
  public String getError();
}