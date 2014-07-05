package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import poulesheet.Equipe;
import poulesheet.Fencer;
import poulesheet.Fencer.Weapon;
import poulesheet.Poulesheet;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CopyOfpoulesheetFrame extends JFrame {
	Poulesheet poulesheet = new Poulesheet();
	DefaultListModel fencerListModel = new DefaultListModel();
	DefaultListModel equipeListModel = new DefaultListModel();

	/**
	 * 
	 */
	private static final long serialVersionUID = -3628709339921918793L;
	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyOfpoulesheetFrame frame = new CopyOfpoulesheetFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CopyOfpoulesheetFrame() {
		myInit();
		setTitle("Poulesheet 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{87, 198, 85, 359, 0};
		gbl_contentPane.rowHeights = new int[]{51, 23, 471, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		final JList listEquipes = new JList(equipeListModel);
		listEquipes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				fencerListModel.clear();
				for (Fencer fencer: poulesheet.equipes.get(listEquipes.getSelectedIndex()).fencers) {
					fencerListModel.addElement(""+fencer.getFirstName()+" "+fencer.getLastName().toUpperCase());
					
					
				}
			}
		});
		listEquipes.setSelectedIndex(0);
		
		JButton btnAddFencer = new JButton("Add fencer");
		btnAddFencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fencerInput();
			}
		});
		
		JButton btnAddEquipe = new JButton("Add equipe");
		btnAddEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipeInput();
			}
		});
		GridBagConstraints gbc_btnAddEquipe = new GridBagConstraints();
		gbc_btnAddEquipe.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddEquipe.gridx = 0;
		gbc_btnAddEquipe.gridy = 1;
		contentPane.add(btnAddEquipe, gbc_btnAddEquipe);
		
		JButton btnDeleteEquipe = new JButton("Delete equipe");
		GridBagConstraints gbc_btnDeleteEquipe = new GridBagConstraints();
		gbc_btnDeleteEquipe.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDeleteEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteEquipe.gridx = 1;
		gbc_btnDeleteEquipe.gridy = 1;
		contentPane.add(btnDeleteEquipe, gbc_btnDeleteEquipe);
		GridBagConstraints gbc_btnAddFencer = new GridBagConstraints();
		gbc_btnAddFencer.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddFencer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddFencer.gridx = 2;
		gbc_btnAddFencer.gridy = 1;
		contentPane.add(btnAddFencer, gbc_btnAddFencer);
		
		JButton btnDeleteFencer = new JButton("Delete fencer");
		GridBagConstraints gbc_btnDeleteFencer = new GridBagConstraints();
		gbc_btnDeleteFencer.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDeleteFencer.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteFencer.gridx = 3;
		gbc_btnDeleteFencer.gridy = 1;
		contentPane.add(btnDeleteFencer, gbc_btnDeleteFencer);
		GridBagConstraints gbc_listEquipes_1 = new GridBagConstraints();
		gbc_listEquipes_1.fill = GridBagConstraints.BOTH;
		gbc_listEquipes_1.insets = new Insets(0, 0, 0, 5);
		gbc_listEquipes_1.gridwidth = 2;
		gbc_listEquipes_1.gridx = 0;
		gbc_listEquipes_1.gridy = 2;
		contentPane.add(listEquipes, gbc_listEquipes_1);
		
		JList listFencers = new JList(fencerListModel);
		GridBagConstraints gbc_listFencers_1 = new GridBagConstraints();
		gbc_listFencers_1.fill = GridBagConstraints.BOTH;
		gbc_listFencers_1.gridwidth = 2;
		gbc_listFencers_1.gridx = 2;
		gbc_listFencers_1.gridy = 2;
		contentPane.add(listFencers, gbc_listFencers_1);
		
		/* Create an array of equipe names */
		for (Equipe equipe: poulesheet.equipes) {
			equipeListModel.addElement(""+equipe.getEquipeName());
		}
		
	}
	
	private void myInit() {
		
	}
	
	private void fencerInput() {
		JTextField fencerFNameField = new JTextField();
		JTextField fencerLNameField = new JTextField();
		JTextField fencerCNameField = new JTextField();  
		JTextField fencerCountryField = new JTextField();  
		Object[] message = new Object[] { "First name", fencerFNameField, "Last name", fencerLNameField, "Club", fencerCNameField, "Country", fencerCountryField };
		int r = JOptionPane.showConfirmDialog(this, message, "Add fencer ", JOptionPane.OK_CANCEL_OPTION); 
		   
		if (r == JOptionPane.OK_OPTION) {
			poulesheet.equipes.get(0).addFencerToEquipe(fencerFNameField.getText(), fencerLNameField.getText(), Weapon.EPEE, fencerCountryField.getText(), fencerCNameField.getText());
			fencerListModel.addElement(""+fencerFNameField.getText()+" "+fencerLNameField.getText().toUpperCase());
		}
	}
	
	private void equipeInput() {
		JTextField equipeNameField = new JTextField();
		JTextField equipeClubField = new JTextField();
		Object[] message = new Object[] { "Equipe name", equipeNameField, "Club", equipeClubField };
		int r = JOptionPane.showConfirmDialog(this, message, "Add equipe ", JOptionPane.OK_CANCEL_OPTION); 
		   
		if (r == JOptionPane.OK_OPTION) {
			poulesheet.addEquipe(equipeNameField.getText(), equipeClubField.getText());
			equipeListModel.addElement(""+equipeNameField.getText());
		}
	}
	
	
}
