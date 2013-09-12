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
        private static  JFrame frame;
        
        private static Database database;
        
        private static OpenSplash splash;
        
        private static Mailer mailer;
        
        private static String password = "password";
        
        /**
         * The {@link MainManu} for the program
         */
        private static MainMenu menu;
        
        private static String version = "1.0 Release Version";
        
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
         * Opens the MainMenu for the program, a JPanel
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
         * 
         * @return {@link GuestMaster#version}
         */
        public static String getVersion()
        {
        	return version;
        }
        
        public static String getPassword()
        {
        	return password;
        }
        
        public static void setPassword(String input)
        {
        	password = input;
        }
        
        
        public static Mailer getMailer()
        {
        	return mailer;
        }
        
        /**
         * 
         * @return {@link GuestMaster#menu}
         */
        public static MainMenu getMainMenu()
        {
        	return menu;
        }
        
        /**
         * 
         * @return {@link GuestMaster#frame}
         */
        public static JFrame getFrame()
        {
        	return frame;
        }
        
        /**
         * 
         * @return {@link GuestMaster#database}
         */
        public static Database getDatabase()
        {
        	return database;
        }
        
        /**
         * 
         * @param args
         * @throws IOException
         */
        public static void main(String args[]) throws IOException
        {
        	createAndShowGui();
        	
        	
        }
}
