/**
 * 
 */
package de.dpa.codingdojo.observer;

import java.beans.PropertyChangeListener;

/**
 * @author Dietrich Travkin
 */
public interface Observable {

	void addPropertyChangeListener(PropertyChangeListener listener);
	
	void addPropertyChangeListener(PropertyChangeListener listener, String propertyname);
	
	void removePropertyChangeListener(PropertyChangeListener listener);
	
	void removePropertyChangeListener(PropertyChangeListener listener, String propertyname);
}
