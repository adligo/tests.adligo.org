package org.adligo.tests.client;

import java.util.ArrayList;
import java.util.List;

import org.adligo.gwt.util.client.GwtPlatform;
import org.adligo.gwt.util.client.GwtPropertyFactory;
import org.adligo.i.log.client.LogPlatform;

public class InitGwt {
	private static final boolean init = false;
	  
	  public static synchronized void init(){
		  if (!init) {
			try {
				List<Class<?>> ommit = new ArrayList<Class<?>>();
				ommit.add(GwtPropertyFactory.class);
				GwtPlatform.init(ommit);
				GwtTestPropertyFactory.init();
				LogPlatform.init();
				
			} catch (Exception x) {
				x.printStackTrace();
			}
		  } 
	  }
	  
	  static {
		  init();
	  }
}
