package _01_ADV_Verwaltung.fachlicheSchicht;
import java.util.Vector;

public class ADV
{
	// die Klasse ADV ist hier eine Klasse, die nur static-Attribute und
	// static-Methoden
	// bereitstellt (vgl. Standardklasse Math), da diese Informationen sich
	// nicht ändern
	// Alternative wäre: eine Singleton-Klasse definieren (nach singleton
	// pattern), von der
	// nur ein einziges Objekt erzeugt werden kann ==> später! (Thema design
	// patterns)
	private static String sAdresse = "Danziger Str. 6, 71034 Böblingen";
	private static String sTelNr = "07031 - 627 - 0";
	private static String sEmailAdresse = "info@gds2.de";
	// für 1:n Beziehung zu Klasse
	private static Vector<Klasse> klassen = new Vector<Klasse>();

	public static String getAdresse()
	{
		return sAdresse;
	}

	public static String getTelNr()
	{
		return sTelNr;
	}

	public static String getEmail()
	{
		return sEmailAdresse;
	}

	public static int getAnzahlKlassen()
	{
		return klassen.size();
	}

	public static int getAnzahlSchueler()
	{
		int iAnzahlSchueler = 0;

		for (Klasse klasse : klassen)
		{
			iAnzahlSchueler += klasse.getAnzahlSchueler();
		}
		return iAnzahlSchueler;
	}

	public static boolean hinzufuegenKlasse(Klasse neueKlasse)
	{		
		return klassen.add(neueKlasse);
	}

	public static Klasse suchenKlasse(String kl_Bez)
	{
		for (Klasse gesuchteKlasse : klassen)
		{
			if (gesuchteKlasse.getKl_Bez().equals(kl_Bez))
				return gesuchteKlasse;
		}
		return null;
	}
}