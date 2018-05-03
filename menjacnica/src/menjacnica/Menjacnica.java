package menjacnica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterface;
import menjacnica.sistemskeoperacije.SOdodajValutu;
import menjacnica.sistemskeoperacije.SOizvrsiTransakciju;
import menjacnica.sistemskeoperacije.SOobrisiValutu;
import menjacnica.sistemskeoperacije.SOsacuvajUFajl;
import menjacnica.sistemskeoperacije.SOucitajIzFajla;

public class Menjacnica implements MenjacnicaInterface{
	
	private LinkedList<Valuta> kursnaLista = new LinkedList<Valuta>();

	@Override
	public void dodajValutu(Valuta valuta) {
		SOdodajValutu.izvrsi(valuta, kursnaLista);	
	}

	@Override
	public void obrisiValutu(Valuta valuta) {
		SOobrisiValutu.izvrsi(valuta, kursnaLista);
	}

	@Override
	public double izvrsiTransakciju(Valuta valuta, boolean prodaja, double iznos) {
		return SOizvrsiTransakciju.izvrsi(valuta, prodaja, iznos);
	}

	@Override
	public LinkedList<Valuta> vratiKursnuListu() {
		return kursnaLista;
	}

	@Override
	public void ucitajIzFajla(String putanja) {
		kursnaLista = SOucitajIzFajla.izvrsi(putanja);
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		SOsacuvajUFajl.izvrsi(putanja, kursnaLista);
	}

	
}
