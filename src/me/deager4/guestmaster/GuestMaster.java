package me.deager4.guestmaster;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import me.deager4.guestmaster.database.Database;
import me.deager4.guestmaster.email.Mailer;
import me.deager4.guestmaster.gui.MainMenu;
import me.deager4.guestmaster.gui.OpenSplash;

/**
 * 
 * @author deager4
 *
 */
public class GuestMaster
{
		/**
		 * The {@link JFrame} for the program
		 */
        private static  JFrame frame;
        
        /**
         * The {@link Database} for the program
         */
        private static Database database;
        
        
        /**
         * The {@link OpenSplash} for the GUI
         */
        private static OpenSplash splash;
        
        /**
         * The {@link Mailer} for the program
         */
        private static Mailer mailer;
        
        /**
         * The password to edit the database
         */
        private static String password = "password";
        
        /**
         * The {@link MainMenu} for the program
         */
        private static MainMenu menu;
        
        
        /**
         * version text
         */
        private static String version = "1.0: Release Version";
        
        /**
         * 
         * @throws IOException
         */
        private static void createAndShowGui() throws IOException
        {
        	ImageIcon img = new ImageIcon("Icons\\largeIcon.jpg");
        	mailer = new Mailer();
        	frame = new JFrame("RESC Guest Tracker");
        	frame.setIconImage(img.getImage());
        	database = new Database();
        	database.importDatabase();
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	splash = new OpenSplash();
        	frame.getContentPane().add(splash);
        	frame.pack();
        	frame.setLocationRelativeTo(null);
        	frame.setVisible(true);
        	
        }
        
        /**
         * Opens the MainMenu for the program, a {@link JPanel}
         * 
         */
        public static void openMainMenu()
        {
        	frame.setLocationRelativeTo(splash);
        	frame.getContentPane().remove(splash);
        	menu = new MainMenu();
        	frame.getContentPane().add(menu);
        	frame.pack();
        	frame.setVisible(true);
        	
        }
        
        /**
         * Public getter for {@link GuestMaster#version}
         * @return {@link GuestMaster#version}
         */
        public static String getVersion()
        {
        	return version;
        }
        
        /**
         * Public getter for {@link GuestMaster#password}
         * @return {@link GuestMaster#password}
         */
        public static String getPassword()
        {
        	return password;
        }
        
        /**
         * Public setter for {@link Guestmaster#password}
         * @param input the new password formatted as a {@link String}
         */
        public static void setPassword(String input)
        {
        	password = input;
        }
        
        /**
         * Public getter for {@link GuestMaster#mailer}
         * @return {@link GuestMaster#mailer}
         */
        public static Mailer getMailer()
        {
        	return mailer;
        }
        
        /**
         * Public getter for the {@link GuestMaster#menu}
         * @return {@link GuestMaster#menu}
         */
        public static MainMenu getMainMenu()
        {
        	return menu;
        }
        
        /**
         * Public getter for {@link GuestMaster#frame}
         * @return {@link GuestMaster#frame}
         */
        public static JFrame getFrame()
        {
        	return frame;
        }
        
        /**
         * Public getter for {@link GuestMaster#database}
         * @return {@link GuestMaster#database}
         */
        public static Database getDatabase()
        {
        	return database;
        }
        
        /**
         * Main Method
         * @param args
         * @throws IOException
         */
        public static void main(String args[]) throws IOException
        {
        	createAndShowGui();
        }
}
