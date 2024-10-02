/**
 * NeueKlasseGUI.java
 * 13.08.2020
 */
package _01_ADV_Verwaltung.guiSchicht;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import _01_ADV_Verwaltung.fachlicheSchicht.ADV;
import _01_ADV_Verwaltung.fachlicheSchicht.Klasse;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author kds
 *
 *
 *         Kurzbeschreibung:
 */
public class NeueKlasseGUI extends JDialog implements ActionListener
{
	private JTextField txtKlasse;
	private JTextField txtLehrer;
	private JTextField txtRaum;

	/**
	 * Create the dialog.
	 * Dieser Dialog soll "modal" sein. Das bedeutet, dass das aufrufende
	 * Fenster solange inaktiv ist und wartet, bis das modale Fenster
	 * wieder geschlossen wird.
	 */
	public NeueKlasseGUI(Dialog owner, boolean modality)
	{
		super(owner, modality);
		setBounds(100, 100, 450, 218);
		this.setTitle("Neue Klasse anlegen");
		getContentPane().setLayout(new BorderLayout());
		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPanel.setLayout(new GridLayout(0, 2, 0, 10));
		JLabel lblKlasse = new JLabel("Bezeichnung");
		lblKlasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblKlasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblKlasse);

		txtKlasse = new JTextField();
		txtKlasse.setText("Ixx");
		txtKlasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKlasse.setColumns(10);
		contentPanel.add(txtKlasse);

		JLabel lblLehrer = new JLabel("Klassenlehrer/-in");
		lblLehrer.setHorizontalAlignment(SwingConstants.LEFT);
		lblLehrer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblLehrer);

		txtLehrer = new JTextField();
		txtLehrer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLehrer.setColumns(10);
		contentPanel.add(txtLehrer);

		JLabel lblRaum = new JLabel("Raum");
		lblRaum.setHorizontalAlignment(SwingConstants.LEFT);
		lblRaum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(lblRaum);

		txtRaum = new JTextField();
		txtRaum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRaum.setColumns(10);
		contentPanel.add(txtRaum);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("\u00DCbernehmen");
		okButton.addActionListener(this);
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

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
		if (e.getActionCommand().equals("OK"))
		{
			this.datenUebernehmen();
		}
		else
		{
			dispose();
		}
	}

	private void datenUebernehmen()
	{
		// zusätzlich könnte vorher noch geprüft werden, ob der Benutzer
		// alle Angaben korrekt gemacht hat
		Klasse neueKlasse = new Klasse(txtKlasse.getText(), txtLehrer.getText(), txtRaum.getText());
		if (ADV.hinzufuegenKlasse(neueKlasse))
			JOptionPane.showMessageDialog(this, "Daten übernommen\nEs können weitere Klassen erfasst werden!");

		else
			JOptionPane.showMessageDialog(this, "Klasse existiert bereits!");

		// Fenster soll stehen bleiben, um evtl. weitere Klassen hinzuzufügen
	}

}
