/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.deager4.guestmaster.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JOptionPane;

import me.deager4.guestmaster.GuestMaster;
import me.deager4.guestmaster.database.Guest;
import me.deager4.guestmaster.database.Sponsor;
import me.deager4.guestmaster.sounds.Sounds;

/**
 *
 * @author Stephen
 */
public class removeGuestPasswordDialog extends javax.swing.JDialog {

    /**
     * Creates new form removeGuestPasswordDialog
     */
    public removeGuestPasswordDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please Enter The Administrative Password");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					submitButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_submitButtonActionPerformed
    	Sounds.BUTTON_ON.play(1);
    	if(GuestMaster.getPassword().equals(new String(passwordField.getPassword())))
    	{
    		Set<String> keyList = GuestMaster.getDatabase().getSponsorList().keySet();
    		Object[] array = keyList.toArray();
    		ArrayList<Sponsor> newSponsorList = new ArrayList<Sponsor>();
    		for(int count = 0; count < keyList.size(); count ++)
    		{
    			newSponsorList.add(GuestMaster.getDatabase().getSponsorList().get((String)array[count]));
    		}
    		for(int count1 = 0; count1 < newSponsorList.size(); count1 ++)
    		{
    			
    			for(int count2 = 0; count2 < newSponsorList.get(count1).getVisits().size(); count2 ++)
    			{
    				if(MainMenu.selectedGuest.getName().equals(newSponsorList.get(count1).getVisits().get(count2).getGuestName()))
    				{
    					GuestMaster.getDatabase().getSponsorList().get(newSponsorList.get(count1).getName()).getVisits().remove(newSponsorList.get(count1).getVisits().get(count2));
    				}
    			}
    		}
    		GuestMaster.getDatabase().removeGuest(MainMenu.selectedGuest);
    		GuestMaster.getDatabase().exportDatabase();
    		GuestMaster.getMainMenu().updateDisplay();
    		this.dispose();
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(GuestMaster.getFrame(), "Incorrect Password", "Warning", JOptionPane.WARNING_MESSAGE);
    		passwordField.setText("");
    	}
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(removeGuestPasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeGuestPasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeGuestPasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeGuestPasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                removeGuestPasswordDialog dialog = new removeGuestPasswordDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
