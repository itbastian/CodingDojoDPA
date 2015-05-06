/**
 * 
 */
package de.dpa.codingdojo.persistence;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import de.dpa.codingdojo.domain.Anschrift;
import de.dpa.codingdojo.domain.Person;

/**
 * @author Dietrich Travkin
 */
public class DBPersistenceFactory implements PropertyChangeListener {
	
	public Person createPerson() {
		Person person = new Person();
		person.addPropertyChangeListener(this);
		return person;
	}
	
	public Anschrift createAnschrift() {
		Anschrift anschrift = new Anschrift();
		anschrift.addPropertyChangeListener(this);
		return anschrift;
	}
	
	protected void saveElement(Person person) {
		System.out.println("Person (\"" + person.toString() + "\") gespeichert.");
	}
	
	protected void saveElement(Anschrift anschrift) {
		System.out.println("Anschrift (\"" + anschrift.toString() + "\") gespeichert.");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() instanceof Person) {
			saveElement((Person) evt.getSource());
		} else if (evt.getSource() instanceof Anschrift) {
			saveElement((Anschrift) evt.getSource());
		}
	}
}
