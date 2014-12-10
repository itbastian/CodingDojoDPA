package de.postadress.dojo.duplicatecheck;

public class WholeNameTest {

	public void testGetter() {
		Forename forename = new Forename("Janosch");
		WholeName wholename = new WholeName();
		forename = wholename.getForename();
		// System.out.println("Forename only:",
		// wholename.getForename().getValue());
		// wholename.setForename(forename);
		// wholename.setForename("fdafds");
	}
}
