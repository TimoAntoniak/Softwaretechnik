package _01_ADV_Verwaltung.fachlicheSchicht;
import java.util.Vector;

public class Klasse
{
	private String klBez;
	private String klRaum;
	private String klLehrer;
	private Vector<Schueler> alleSchueler;

	public Klasse(String klBez, String klRaum, String klLehrer)
	{
		this.klBez = klBez;
		this.klRaum = klRaum;
		this.klLehrer = klLehrer;
		alleSchueler = new Vector<Schueler>();
	}

	public String getKl_Bez()
	{
		return klBez;
	}

	public int getAnzahlSchueler()
	{
		return alleSchueler.size();
	}

	public void hinzufuegenSchueler(Schueler neuerSchueler)
	{
		alleSchueler.addElement(neuerSchueler);
	}

	public String[] getAlleSchueler()
	{
		String[] schuelerDaten = new String[alleSchueler.size()];
		for (int i = 0; i < alleSchueler.size(); i++)
		{
			Schueler einSchueler = (Schueler) alleSchueler.elementAt(i);
			schuelerDaten[i] = einSchueler.getSchuelerNr() + "\t"
			+ einSchueler.getName() + "\t" + einSchueler.getVorname() + "\t" + einSchueler.getAdresse();
		}
		return schuelerDaten;
	}
	
//	Alternative: Vector von Schülern zurückgeben ==> "Zerlegen" in Attribute
//  Schülernr., Name, Adresse in AlleSchuelerGUI
//	public Vector<Schueler> getAlleSchüler()
//	{
//		return alleSchueler;
//	}

	public Schueler suchenSchueler(String sSchuelerNr)
	{
		Schueler gesuchterSchueler = null;

		/*
		 * hier den Quellcode um Suchschleife ergänzen
		 */
		
		return gesuchterSchueler;
	}

	public boolean loeschenSchueler(String sSchuelerNr)
	{
		boolean geloescht = false;

		/*
		 * hier den Quellcode um Suchschleife ergänzen
		 * wenn gefunden, dann aus alleSchueler entfernen
		 */
		
		return geloescht;
	}
}