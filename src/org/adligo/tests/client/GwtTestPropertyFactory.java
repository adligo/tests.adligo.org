package org.adligo.tests.client;

import java.util.Map;

import org.adligo.gwt.util.client.GwtPropertyFactory;
import org.adligo.gwt.util.client.MapWrapper;
import org.adligo.i.util.client.Event;
import org.adligo.i.util.client.I_Listener;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.ListenerValueObject;

import com.google.gwt.core.client.GWT;

public class GwtTestPropertyFactory extends GwtPropertyFactory {
	private static Map<String,String> adligo_log_properties;
	
	@SuppressWarnings("unchecked")
	public Object createNew(Object p) {
		
		
		ListenerValueObject list = (ListenerValueObject) p;
		System.out.println("Loading property file org.adligo.tests.client.adligo_log.properties from classpath");
		
	      Event event = new Event();
		
	      if (adligo_log_properties == null) {
	    	  Map<String,String> props = (Map) GWT.create(adligo_log.class) ;
	    	  adligo_log_properties = props;
	      }
		  I_Map result = new MapWrapper(adligo_log_properties);
		  
		  event.setValue(result);
			
		  I_Listener callback = list.getListener();
		  callback.onEvent(event);
		
		return null;
	}
	
	protected static void init() throws Exception {
		init(new GwtTestPropertyFactory());
	}

}
