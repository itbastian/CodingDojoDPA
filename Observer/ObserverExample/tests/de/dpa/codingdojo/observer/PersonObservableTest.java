/**
 * 
 */
package de.dpa.codingdojo.observer;

import static org.junit.Assert.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.dpa.codingdojo.domain.Person;

/**
 * @author Dietrich Travkin
 */
public class PersonObservableTest {

	private Person objectUnderTest;
	private List<PropertyChangeEvent> events;
	
	@Before
	public void beforeTests() {
		this.objectUnderTest = new Person("Lisa", "Mustermann");
		events = new ArrayList<PropertyChangeEvent>();
	}
	
	private class EventCollector implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			events.add(evt);
		}
	}
	
	@Test
	public void firingEvents() {
		assertEquals(0, events.size());
		
		// given a listener registered to a person
		this.objectUnderTest.addPropertyChangeListener(new EventCollector());
		
		// when an attribute is changed
		this.objectUnderTest.setNachname("Meyer");
		
		// then an event is fired
		assertEquals(1, events.size());
		
		// when an attribute is changed
		this.objectUnderTest.setVorname("Max");
				
		// then another event is fired
		assertEquals(2, events.size());
	}
	
	@Test
	public void registerAndDeregister() {
		PropertyChangeListener listener = new EventCollector();
		this.objectUnderTest.addPropertyChangeListener(listener);
		
		this.objectUnderTest.setVorname("Otto");
		assertEquals(1, events.size());
		
		this.objectUnderTest.removePropertyChangeListener(listener);
		
		this.objectUnderTest.setVorname("Anna");
		assertEquals(1,  events.size());
	}
	
	@Test
	public void eventContainsOldAndNewValuesAndPropertynameAndSourceObject() {
		this.objectUnderTest.addPropertyChangeListener(new EventCollector());
		
		String newName = "Meier";
		String oldName = this.objectUnderTest.getNachname();
		this.objectUnderTest.setNachname(newName);
		
		assertEquals(1, events.size());
		PropertyChangeEvent event = events.get(0);
		assertEquals(newName, event.getNewValue());
		assertEquals(oldName, event.getOldValue());
		
		assertEquals(Person.PROPERTY_NACHNAME, event.getPropertyName());
		assertEquals(this.objectUnderTest, event.getSource());
	}
	
	@Test
	public void onlyFireEventsIfValuesChanged() {
		this.objectUnderTest.addPropertyChangeListener(new EventCollector());
		
		String oldName = this.objectUnderTest.getVorname();
		this.objectUnderTest.setVorname(oldName);
		
		assertEquals(0, events.size());
		
		this.objectUnderTest.setVorname(oldName + "-Mayer");
		
		assertEquals(1, events.size());
	}

	@Test
	public void onlyFireEventsForPropertiesRegisteredFor() {
		PropertyChangeListener listener = new EventCollector();
		this.objectUnderTest.addPropertyChangeListener(listener, Person.PROPERTY_NACHNAME);
		
		this.objectUnderTest.setVorname("Elisa");
		
		assertEquals(0, events.size());
		
		this.objectUnderTest.setNachname("Beethoven");
		
		assertEquals(1, events.size());
		assertEquals(Person.PROPERTY_NACHNAME, events.get(0).getPropertyName());
		
		this.events.clear();
		assertEquals(0, events.size());
		
		this.objectUnderTest.removePropertyChangeListener(listener, Person.PROPERTY_NACHNAME);
		this.objectUnderTest.addPropertyChangeListener(listener, Person.PROPERTY_VORNAME);
		
		this.objectUnderTest.setVorname("Mona");
		this.objectUnderTest.setNachname("Fauna");
		
		assertEquals(1, events.size());
		assertEquals(Person.PROPERTY_VORNAME, events.get(0).getPropertyName());
	}
	
	@Test
	public void allowForMultipleListeners() {
		// given arbitrary many listeners
		int numberOfListeners = 101;
		final HashMap<PropertyChangeListener, List<PropertyChangeEvent>> listenersEvents = new HashMap<PropertyChangeListener, List<PropertyChangeEvent>>();
		ArrayList<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>(numberOfListeners);
		for (int i = 0; i< numberOfListeners; i++) {
			PropertyChangeListener listener = new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					listenersEvents.get(this).add(evt); // remember own events
				}
			};
			listeners.add(listener);
			listenersEvents.put(listener, new ArrayList<PropertyChangeEvent>());
			
			switch (i) {
			case 0:
				this.objectUnderTest.addPropertyChangeListener(listener, Person.PROPERTY_VORNAME);
				break;
			case 51:
				// do not register
				break;
			case 100:
				this.objectUnderTest.addPropertyChangeListener(listener, Person.PROPERTY_NACHNAME);
				break;

			default:
				this.objectUnderTest.addPropertyChangeListener(listener);
				break;
			}
		}
		
		// when several changes are performed on the subject
		String nachname1 = "Schultz";
		String nachname2 = "Ostermann";
		String vorname = "Anne-Marie";
		this.objectUnderTest.setNachname(nachname1);
		this.objectUnderTest.setVorname(vorname);
		this.objectUnderTest.setNachname(nachname2);
		
		// then the expected events should arrive the listeners
		List<PropertyChangeEvent> events;
		for (int i = 0; i< numberOfListeners; i++) {
			events = listenersEvents.get(listeners.get(i));
			switch (i) {
			case 0:
				assertEquals(1, events.size()); // Vorname property only
				assertEquals(Person.PROPERTY_VORNAME, events.get(0).getPropertyName());
				assertEquals(vorname, events.get(0).getNewValue());
				break;
			case 51:
				assertEquals(0, events.size()); // no events, since not registered
				break;
			case 100:
				assertEquals(2, events.size()); // Nachname property only
				assertEquals(Person.PROPERTY_NACHNAME, events.get(0).getPropertyName());
				assertEquals(Person.PROPERTY_NACHNAME, events.get(1).getPropertyName());
				assertEquals(nachname1, events.get(0).getNewValue());
				assertEquals(nachname2, events.get(1).getNewValue());
				break;

			default:
				assertEquals(3, events.size()); // both properties
				assertEquals(Person.PROPERTY_NACHNAME, events.get(0).getPropertyName());
				assertEquals(Person.PROPERTY_VORNAME, events.get(1).getPropertyName());
				assertEquals(Person.PROPERTY_NACHNAME, events.get(2).getPropertyName());
				assertEquals(nachname1, events.get(0).getNewValue());
				assertEquals(vorname, events.get(1).getNewValue());
				assertEquals(nachname2, events.get(2).getNewValue());
				break;
			}
		}
	}
	
}
