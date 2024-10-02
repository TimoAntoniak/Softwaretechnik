/**
 * NeueKlasseGUI.java
 * 13.08.2020
 */
package _01_ADV_Verwaltung.guiSchicht;

import _01_ADV_Verwaltung.fachlicheSchicht.ADV;
import _01_ADV_Verwaltung.fachlicheSchicht.Klasse;
import _01_ADV_Verwaltung.fachlicheSchicht.Schueler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author kds
 *
 *
 *         Kurzbeschreibung:
 */
public class SchuelerBearbeitenGUI extends JDialog implements ActionListener
{
	private JTextField txtName;
	private JTextField txtVorname;
	private JTextField txtAdresse;
	private JTextField txtKlasse;
	private JTextField txtSchuelerNr;

	/**
	 * Create the dialog.
	 * Dieser Dialog soll "modal" sein. Das bedeutet, dass das aufrufende
	 * Fenster solange inaktiv ist und wartet, bis das modale Fenster
	 * wieder geschlossen wird.
	 */
	public SchuelerBearbeitenGUI(Dialog owner, boolean modality)
	{
		super(owner, modality);
		setBounds(100, 100, 450, 301);
		this.setTitle("Neuen Schüler/Schülerin anlegen");
		getContentPane().setLayout(new BorderLayout());
		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPanel.setLayout(new GridLayout(0, 2, 0, 10));

		JLabel lblSchuelerNr = new JLabel("Sch\u00FClerNr");
		lblSchuelerNr.setHorizontalAlignment(SwingConstants.LEFT);
		lblSchuelerNr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblSchuelerNr);

		txtSchuelerNr = new JTextField();
		txtSchuelerNr.setText("Sxxxx");
		txtSchuelerNr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSchuelerNr.setColumns(10);
		contentPanel.add(txtSchuelerNr);
		JLabel lblName = new JLabel("Nachname");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblName);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		contentPanel.add(txtName);

		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setHorizontalAlignment(SwingConstants.LEFT);
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblVorname);

		txtVorname = new JTextField();
		txtVorname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVorname.setColumns(10);
		contentPanel.add(txtVorname);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblAdresse);

		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdresse.setColumns(10);
		contentPanel.add(txtAdresse);

		JLabel lblKlasse = new JLabel("Klasse");
		lblKlasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblKlasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblKlasse);

		txtKlasse = new JTextField();
		txtKlasse.setText("Ixx");
		txtKlasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKlasse.setColumns(10);
		contentPanel.add(txtKlasse);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton suchButton = new JButton("Suchen");
		suchButton.addActionListener(this);
		suchButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		suchButton.setActionCommand("Suchen");
		buttonPane.add(suchButton);
		getRootPane().setDefaultButton(suchButton);

		JButton aendernButton = new JButton("Ändern");
		aendernButton.addActionListener(this);
		aendernButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		aendernButton.setActionCommand("Ändern");
		buttonPane.add(aendernButton);
		getRootPane().setDefaultButton(aendernButton);

		JButton loeschenButton = new JButton("Löschen");
		loeschenButton.addActionListener(this);
		loeschenButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loeschenButton.setActionCommand("Suchen");
		buttonPane.add(loeschenButton);
		getRootPane().setDefaultButton(loeschenButton);

		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(this);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Uebernehmen"))  // Prüfen, ob Übernehmen Button geklickt
		{
			if (txtSchuelerNr.getText().isEmpty() || txtName.getText().isEmpty() || txtVorname.getText().isEmpty()
					|| txtKlasse.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "SchülerNr, Name, Vorname und Klasse eintragen");
			}
			else
			{
				this.datenUebernehmen();
			}
		}
		else // Abbrechen geklickt --> einfach Fenster schließen
		{
			dispose();
		}
	}

	private void datenUebernehmen()
	{
		Schueler neuerSchueler;
		Klasse klasse = ADV.suchenKlasse(txtKlasse.getText());
		if (klasse == null)
			JOptionPane.showMessageDialog(this, "Klasse " + txtKlasse.getText() + " ex. nicht!");
		else
		{
			// hier könnte zusätzlich noch geprüft werden, ob es einen Schüler mit dieser
			// SchülerNr. schon gibt
			neuerSchueler = new Schueler(txtSchuelerNr.getText(), txtName.getText(), txtVorname.getText(),
					txtAdresse.getText());
			klasse.hinzufuegenSchueler(neuerSchueler);
			neuerSchueler.zuordnenKlasse(klasse);
			JOptionPane.showMessageDialog(this, "Daten übernommen\nEs können weitere Schüler erfasst werden!");
		}

		// Fenster soll stehen bleiben, um evtl. weitere Schüler hinzuzufügen
	}

}
