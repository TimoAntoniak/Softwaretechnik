/**
 * StartAdvGUI.java
 * 13.08.2020
 */
package _01_ADV_Verwaltung.guiSchicht;

import _01_ADV_Verwaltung.fachlicheSchicht.ADV;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author kds
 *
 *
 * Kurzbeschreibung:
 */
public class StartAdvGUI
{

	private JFrame frame;
	private JTextField txtAdresse;
	private JTextField txtTelefonnr;
	private JTextField txtEmail;
	private JTextField txtAnzahlKlassen;
	private JTextField txtAnzahlSchueler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					StartAdvGUI window = new StartAdvGUI();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartAdvGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame("ADV Informationen");
		frame.setBounds(100, 100, 960, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnKlassen = new JMenu("Klassen");
		mnKlassen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnKlassen);
		
		JMenuItem mntmNeueKlasse = new JMenuItem("Neue Klasse anlegen...");
		mntmNeueKlasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeueKlasseGUI dialog = new NeueKlasseGUI(null, true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				txtAnzahlKlassen.setText(Integer.toString(ADV.getAnzahlKlassen()));
			}
		});
		mnKlassen.add(mntmNeueKlasse);
		
		JMenuItem mntmAlleSchueler = new JMenuItem("Alle Sch\u00FCler...");
		mntmAlleSchueler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlleSchuelerGUI dialog = new AlleSchuelerGUI();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnKlassen.add(mntmAlleSchueler);
		
		JMenu mnSchueler = new JMenu("Sch\u00FCler");
		mnSchueler.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnSchueler);
		
		JMenuItem mntmNeuenSchuelerAufnehmen = new JMenuItem("Neuen Sch\u00FCler/-in aufnehmen...");
		mntmNeuenSchuelerAufnehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeuerSchuelerGUI dialog = new NeuerSchuelerGUI(null, true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				txtAnzahlSchueler.setText(Integer.toString(ADV.getAnzahlSchueler()));
			}
		});
		mnSchueler.add(mntmNeuenSchuelerAufnehmen);
		
		JMenuItem mntmSchuelerBearbeiten = new JMenuItem("Sch\u00FClerBearbeiten...");
		mntmSchuelerBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SchuelerBearbeitenGUI dialog = new SchuelerBearbeitenGUI(null, true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		/*
		 * Hier muss der ActionListener für den Dialog "BearbeitenSchuelerGUI" 
		 * hinzugefügt werden --> siehe oben NeuerSchuelerGUI 
		 */
		mnSchueler.add(mntmSchuelerBearbeiten);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(new EmptyBorder(15, 0, 10, 0));
		frame.getContentPane().add(pnlInfo);
		pnlInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlKopf = new JPanel();
		pnlInfo.add(pnlKopf);
		
		JLabel lblIcon = new JLabel(new ImageIcon("D:\\kdsDaten\\Documents\\Unterricht\\java\\Projekte\\AdvVerwaltungN\\bin\\GDS2_nur_Logo.png"));
		pnlKopf.add(lblIcon);
		
		JLabel lblTitel = new JLabel("Gottlieb-Daimler-Schule2 - Abt. ADV (Au\u00DFenstelle B\u00F6blingen)");
		pnlKopf.add(lblTitel);
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pnlDaten = new JPanel();
		pnlDaten.setBorder(new EmptyBorder(0, 20, 0, 20));
		pnlInfo.add(pnlDaten);
		pnlDaten.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlDaten.add(lblAdresse);
		
		txtAdresse = new JTextField();
		lblAdresse.setLabelFor(txtAdresse);
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdresse.setText(ADV.getAdresse());
		pnlDaten.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JLabel lblTelefonnr = new JLabel("Telefon-Nr. Sekretariat");
		lblTelefonnr.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefonnr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlDaten.add(lblTelefonnr);
		
		txtTelefonnr = new JTextField();
		txtTelefonnr.setText(ADV.getTelNr());
		txtTelefonnr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelefonnr.setColumns(10);
		pnlDaten.add(txtTelefonnr);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlDaten.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText(ADV.getEmail());
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		pnlDaten.add(txtEmail);
		
		JPanel pnlInfo2 = new JPanel();
		pnlInfo2.setBorder(new EmptyBorder(0, 20, 20, 20));
		frame.getContentPane().add(pnlInfo2, BorderLayout.SOUTH);
		pnlInfo2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnlKlassen = new JPanel();
		pnlKlassen.setBorder(new EmptyBorder(0, 0, 0, 20));
		pnlInfo2.add(pnlKlassen);
		pnlKlassen.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAnzahlKlassen = new JLabel("Anzahl Klassen:");
		pnlKlassen.add(lblAnzahlKlassen);
		lblAnzahlKlassen.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnzahlKlassen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtAnzahlKlassen = new JTextField();
		pnlKlassen.add(txtAnzahlKlassen);
		txtAnzahlKlassen.setEditable(false);
		txtAnzahlKlassen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnzahlKlassen.setColumns(5);
		txtAnzahlKlassen.setText(Integer.toString(ADV.getAnzahlKlassen()));
		
		JPanel pnlSchueler = new JPanel();
		pnlInfo2.add(pnlSchueler);
		pnlSchueler.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAnzahlSchueler = new JLabel("Anzahl Sch\u00FCler");
		pnlSchueler.add(lblAnzahlSchueler);
		lblAnzahlSchueler.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnzahlSchueler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtAnzahlSchueler = new JTextField();
		pnlSchueler.add(txtAnzahlSchueler);
		txtAnzahlSchueler.setEditable(false);
		txtAnzahlSchueler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnzahlSchueler.setColumns(10);
		txtAnzahlSchueler.setText(Integer.toString(ADV.getAnzahlSchueler()));
	}

}
