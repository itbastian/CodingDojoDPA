package de.postadress.dojo.duplicatecheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataObjectTest {

	
	@Test
		public void testIsDuplicateOfEquals() {
			DataObject object1 = new DataObject();
			DataObject object2 = new DataObject();
			
			assertTrue(object1.isDuplicateOf(object2));
		}
	
	@Test
			public void testIsDuplicateOfNotEquals() {
				DataObject object1 = new DataObject();
				object1.setAttribute("irgendwas");
				DataObject object2 = new DataObject();
				object2.setAttribute("nichts");
				
				assertFalse(object1.isDuplicateOf(object2));
			}
	
	@Test
			public void testIsDuplicateOfAttrEquals() {
				DataObject object1 = new DataObject();
				object1.setAttribute("nichts");
				DataObject object2 = new DataObject();
				object2.setAttribute(" NICHTS ");
				
				assertTrue(object1.isDuplicateOf(object2));
			}

	@Test
			public void testIsDuplicateOfIgnoreNullAttr() {
				DataObject object1 = new DataObject();
				object1.setAttribute("nichts");
				DataObject object2 = new DataObject();
				
				assertTrue(object1.isDuplicateOf(object2));
				
				assertTrue(object2.isDuplicateOf(object1));
			}
	
}
