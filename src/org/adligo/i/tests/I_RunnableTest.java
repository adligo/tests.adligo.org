package org.adligo.i.tests;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
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