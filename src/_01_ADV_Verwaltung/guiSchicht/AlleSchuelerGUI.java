/**
 * NeueKlasseGUI.java
 * 13.08.2020
 */
package _01_ADV_Verwaltung.guiSchicht;

import _01_ADV_Verwaltung.fachlicheSchicht.ADV;
import _01_ADV_Verwaltung.fachlicheSchicht.Klasse;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * @author kds
 *
 *
 *         Kurzbeschreibung:
 */
public class AlleSchuelerGUI extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtKlasse;
	private JTextArea textArea;

	/**
	 * Create the dialog.
	 */
	public AlleSchuelerGUI()
	{
		setBounds(100, 100, 450, 441);
		this.setTitle("Neuen Schüler/Schülerin anlegen");
		getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(10, 20, 10, 20));
		panel.setLayout(new GridLayout(0, 2, 0, 10));

		JLabel lblKlasse = new JLabel("Klasse eingeben:");
		lblKlasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblKlasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblKlasse);

		txtKlasse = new JTextField();
		txtKlasse.setText("Ixx");
		txtKlasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKlasse.setColumns(10);
		panel.add(txtKlasse);
		contentPanel.setBorder(new EmptyBorder(5, 15, 5, 15));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton btnAnzeigen = new JButton("Anzeigen");
		buttonPane.add(btnAnzeigen);
		btnAnzeigen.addActionListener(this);
		btnAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnzeigen.setActionCommand("OK");

		getRootPane().setDefaultButton(btnAnzeigen);

		JButton btnCancel = new JButton("Abbrechen");
		buttonPane.add(btnCancel);
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setActionCommand("Cancel");
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
			this.datenAnzeigen();
		}
		else
		{
			dispose();
		}
	}

	private void datenAnzeigen()
	{
		Klasse klasse = ADV.suchenKlasse(txtKlasse.getText());
		if (klasse == null)
			JOptionPane.showMessageDialog(this, "Klasse " + txtKlasse.getText() + " ex. nicht!");
		else
		{
			textArea.setText("");
			String[] alleSchueler = klasse.getAlleSchueler();
			for (int i = 0; i < klasse.getAnzahlSchueler(); i++)
			{
				textArea.append("\n" + alleSchueler[i]);
			}
		}

	}

}
