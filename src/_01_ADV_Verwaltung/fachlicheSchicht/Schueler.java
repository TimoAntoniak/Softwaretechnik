package _01_ADV_Verwaltung.fachlicheSchicht;
public class Schueler
{
	private String sSchuelerNr;
	private String sName;
	private String sVorname;
	private String sAdresse;
	private Klasse klasse;

	public Schueler(String sSchuelerNr, String sName, String sVorname, String sAdresse)
	{
		this.sSchuelerNr = sSchuelerNr;
		this.sName = sName;
		this.sVorname = sVorname;
		this.sAdresse = sAdresse;
	}

	public String getSchuelerNr()
	{
		return sSchuelerNr;
	}

	public String getName()
	{
		return sName;
	}

	public void setsName(String sName)
	{
		this.sName = sName;
	}

	public String getVorname()
	{
		return sVorname;
	}

	public void setsVorname(String sVorname)
	{
		this.sVorname = sVorname;
	}

	public String getAdresse()
	{
		return sAdresse;
	}

	public void setsAdresse(String sAdresse)
	{
		this.sAdresse = sAdresse;
	}

	public void zuordnenKlasse(Klasse klasse)
	{
		this.klasse = klasse;
	}
}