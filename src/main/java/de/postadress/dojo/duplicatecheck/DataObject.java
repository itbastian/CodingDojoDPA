package de.postadress.dojo.duplicatecheck;

public class DataObject {

	private String attribute;
	
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	boolean isDuplicateOf(DataObject objectToCompare){
		
		final String stringToCompare; 
		if (objectToCompare.getAttribute() != null) {
			stringToCompare = objectToCompare.getAttribute().trim().toLowerCase();
		} else {
			return true;
		}
		
		if (getAttribute() == null) {
			return true;
		}
		
		return getAttribute().trim().toLowerCase().equals(stringToCompare);
	}
}
