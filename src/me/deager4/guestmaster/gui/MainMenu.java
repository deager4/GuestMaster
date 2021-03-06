/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.deager4.guestmaster.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;

import me.deager4.guestmaster.GuestMaster;
import me.deager4.guestmaster.database.Guest;
import me.deager4.guestmaster.database.Sponsor;
import me.deager4.guestmaster.sounds.Sounds;


/**
 *
 * @author deager4
 */
public class MainMenu extends javax.swing.JPanel {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        ArrayList<Guest> list = GuestMaster.getDatabase().getGuestFromName(jTextField1.getText());
        DefaultListModel<Guest> model = new DefaultListModel<Guest>();
        for(int count = 0; count < list.size(); count ++)
        {
     	   model.addElement(list.get(count));
        }
        jlist = new JList<Guest>(model);
        jlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlist);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jToggleButton1 = new javax.swing.JToggleButton();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlist = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        editSelectedButton = new javax.swing.JButton();
        addAGuestButton = new javax.swing.JButton();
        removeAGuestButton = new javax.swing.JButton();
        backupDatabaseButton = new javax.swing.JButton();
        restoreDatabaseButton = new javax.swing.JButton();
        emailSponsorRecordsButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jToggleButton1.setText("jToggleButton1");

        button1.setLabel("button1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("RESC Guest Tracker");

        jlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlist);

        jLabel2.setText("Search:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        editSelectedButton.setText("Edit Selected");
        editSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectedButtonActionPerformed(evt);
            }
        });

        addAGuestButton.setText("Add A Guest");
        addAGuestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAGuestButtonActionPerformed(evt);
            }
        });

        removeAGuestButton.setText("Remove Selected Guest");
        removeAGuestButton.setHideActionText(true);
        removeAGuestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					removeAGuestButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        backupDatabaseButton.setText("Back Up Database");
        backupDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					backupDatabaseButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        restoreDatabaseButton.setText("Restore Database");
        restoreDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					restoreDatabaseButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        emailSponsorRecordsButton.setText("Email Sponsor Records");
        emailSponsorRecordsButton.setToolTipText("");
        emailSponsorRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailSponsorRecordsButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setText("Change Password");
        changePasswordButton.setToolTipText("");
        changePasswordButton.setActionCommand("");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailSponsorRecordsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editSelectedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(backupDatabaseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addAGuestButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeAGuestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restoreDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(changePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editSelectedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAGuestButton)
                    .addComponent(removeAGuestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backupDatabaseButton)
                    .addComponent(restoreDatabaseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailSponsorRecordsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePasswordButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void editSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectedButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	this.selectedGuest = (Guest) jlist.getSelectedValue();
        EditSelectedGuestDialog dialog = new EditSelectedGuestDialog(GuestMaster.getFrame(), true);
        dialog.show();
        
    }//GEN-LAST:event_editSelectedButtonActionPerformed

    
    private void addAGuestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAGuestButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	AddAGuestDialog dialog = new AddAGuestDialog(GuestMaster.getFrame(), true);
        dialog.show();
    }//GEN-LAST:event_addAGuestButtonActionPerformed

   
    public void updateDisplay()
    {
    	ArrayList<Guest> list = GuestMaster.getDatabase().getGuestFromName(jTextField1.getText());
        DefaultListModel<Guest> model = new DefaultListModel<Guest>();
        for(int count = 0; count < list.size(); count ++)
        {
     	   model.addElement(list.get(count));
        }
        jlist = new JList<Guest>(model);
        jlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlist);
    }
    
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        ArrayList<Guest> list = GuestMaster.getDatabase().getGuestFromName(jTextField1.getText());
       DefaultListModel<Guest> model = new DefaultListModel<Guest>();
       for(int count = 0; count < list.size(); count ++)
       {
    	   model.addElement(list.get(count));
       }
       jlist = new JList<Guest>(model);
       jlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
       jScrollPane1.setViewportView(jlist);
       
    }//GEN-LAST:event_jTextField1KeyTyped

   
    
    private void removeAGuestButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_removeAGuestButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	this.selectedGuest = (Guest) jlist.getSelectedValue();
    	removeGuestPasswordDialog dialog = new removeGuestPasswordDialog(GuestMaster.getFrame(), true);
    	dialog.show();
    }//GEN-LAST:event_removeAGuestButtonActionPerformed

    private void backupDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_backupDatabaseButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	JFileChooser backupDatabaseFileChooser = new JFileChooser();
    	int returnVal = backupDatabaseFileChooser.showDialog(MainMenu.this, "Backup");
    	backupDatabaseFileChooser.setApproveButtonText("Backup To File");
    	int result = backupDatabaseFileChooser.showSaveDialog(this);
    	if (result == JFileChooser.APPROVE_OPTION) {
    		GuestMaster.getDatabase().backupDatabase(backupDatabaseFileChooser.getSelectedFile());
    	       GuestMaster.getMainMenu().updateDisplay();
    	} 
    	else if (result == JFileChooser.CANCEL_OPTION) {
    	}
    	
    }//GEN-LAST:event_backupDatabaseButtonActionPerformed

    private void restoreDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_restoreDatabaseButtonActionPerformed
        Sounds.BUTTON_ON.play(1);
    	GuestMaster.getDatabase().clearGuests();
    	JFileChooser restoreFileChooser = new JFileChooser();
    	int returnVal = restoreFileChooser.showDialog(MainMenu.this, "Restore");
    	restoreFileChooser.setApproveButtonText("Restore From File");
        int result = restoreFileChooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION)
        {
        	GuestMaster.getDatabase().restoreDatabase(restoreFileChooser.getSelectedFile());
        	GuestMaster.getMainMenu().updateDisplay();
        }
        else if(result == JFileChooser.CANCEL_OPTION)
        {
        	
        }
        GuestMaster.getDatabase().exportDatabase();
        
    }//GEN-LAST:event_restoreDatabaseButtonActionPerformed

    private void emailSponsorRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailSponsorRecordsButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	String message = "";
    	message = message + "Guest Sponsor Records" + '\n' + '\n';
    	Set<String> keyList = GuestMaster.getDatabase().getSponsorList().keySet();
		Object[] array = keyList.toArray();
		ArrayList<Sponsor> newSponsorList = new ArrayList<Sponsor>();
		for(int count = 0; count < keyList.size(); count ++)
		{
			newSponsorList.add(GuestMaster.getDatabase().getSponsorList().get((String)array[count]));
		}
		for(int count3 = 0; count3 < newSponsorList.size(); count3 ++)
		{
			message = message + (newSponsorList.get(count3).getName() + '\n');
			for(int count2 = 0; count2 < newSponsorList.get(count3).getVisits().size(); count2 ++)
			{
				String payment = "Credit";
				if(newSponsorList.get(count3).getVisits().get(count2).getPass() == true)
				{
					payment = "Guest Pass";
				}
				message = message + ("visit " + (count2 + 1) + ": " + "Guest Name - " + newSponsorList.get(count3).getVisits().get(count2).getGuestName() + "; Date - " + newSponsorList.get(count3).getVisits().get(count2).getDate().toString() +  "; Payment Type - " + payment + '\n');
				
			}
			message = message + '\n';
		}
		GuestMaster.getMailer().sendMail(message, "Guest Sponsor Records");
    }//GEN-LAST:event_emailSponsorRecordsButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	ChangePasswordDialog dialog = new ChangePasswordDialog(GuestMaster.getFrame(), true);
    	dialog.show();
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    public static Guest selectedGuest;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAGuestButton;
    private javax.swing.JButton backupDatabaseButton;
    private java.awt.Button button1;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton editSelectedButton;
    private javax.swing.JButton emailSponsorRecordsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JList jlist;
    private javax.swing.JButton removeAGuestButton;
    private javax.swing.JButton restoreDatabaseButton;
    // End of variables declaration//GEN-END:variables
}
