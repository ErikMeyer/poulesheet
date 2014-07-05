package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import poulesheet.Poulesheet;
import java.awt.GridBagConstraints;

public class poulesheetFrame extends JFrame implements TreeSelectionListener {
	private Poulesheet poulesheet = new Poulesheet();
	private JTree tree;
	private static final long serialVersionUID = -3628709339921918793L;
	private JPanel contentPane;
	
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					poulesheetFrame frame = new poulesheetFrame();
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
	public poulesheetFrame() {
		myInit();
		setTitle("Poulesheet 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
				
		GridBagConstraints gbc_treeView = new GridBagConstraints();
		gbc_treeView.fill = GridBagConstraints.BOTH;
		gbc_treeView.gridx = 0;
		gbc_treeView.gridy = 4;
		
		
		//Create the nodes
		DefaultMutableTreeNode equipe = new DefaultMutableTreeNode("No equipe");
		createNodes(equipe);
		
		//Create a tree that allows one selection at a time
		tree = new JTree(equipe);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		//Listen for when the selection changes
		tree.addTreeSelectionListener(this);
		
		//Create the scroll pane and add the tree to it
		JScrollPane treeView = new JScrollPane(tree);
		contentPane.add(treeView, gbc_treeView);
		//Sizes
		//Dimension minimumSize = new Dimension(100, 50);
		//treeView.setMinimumSize(minimumSize);
	
		
	}
	
	private void myInit() {
		
	}
	
	private void addEquipe(String equipeName, String equipeClub) {
		DefaultMutableTreeNode newEquipe = new DefaultMutableTreeNode(equipeName);
		createNodes(newEquipe);
		//Or add to existing tree?
	}
	
	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode fencer = null;
		
		//fencer = new DefaultMutableTreeNode();
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
