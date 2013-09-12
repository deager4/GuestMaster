package me.deager4.guestmaster.sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import me.deager4.guestmaster.GuestMaster;

public enum Sounds 
{
	BUTTON_ON("Sounds\\Button On.wav");
	private Clip clip;
	
	Sounds(String soundFileLocation)
	{
		AudioInputStream audioInputStream;
		try
		{
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundFileLocation).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		}
		catch(UnsupportedAudioFileException e)
		{
			JOptionPane.showMessageDialog(GuestMaster.getFrame(), "Internal Audio System Error!!!" + '\n' + "UnsupportedAudioFileException", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(GuestMaster.getFrame(), "Internal Audio System Error!!!" + '\n' + "File Not Found!!!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(LineUnavailableException e)
		{
			JOptionPane.showMessageDialog(GuestMaster.getFrame(), "Internal Audio System Error!!!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void play(float vol)
	{
		if(vol < -80 || vol > 6)
		{
			throw new IllegalArgumentException("Volume must be between 1 and 100, inclusive");
		}
		if(clip.isRunning())
		{
			clip.stop();
		}
		clip.setFramePosition(0);
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(vol);
		clip.start();
			
	}
}
