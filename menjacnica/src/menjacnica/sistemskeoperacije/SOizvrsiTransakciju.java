package menjacnica.sistemskeoperacije;

import java.util.LinkedList;

import menjacnica.Valuta;

public class SOizvrsiTransakciju {

	public static double izvrsi(Valuta valuta, boolean prodaja, double iznos) {
		if (prodaja)
			return iznos * valuta.getProdajni();
		else
			return iznos * valuta.getKupovni();
	}
}
