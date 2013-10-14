package TFLib;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TFSound 
{
	private Clip clip;
	private AudioInputStream input;
	private FloatControl volumecontrol;
	private String state = "stopped";
	private long startpoint = 0;
	
	public TFSound(File audiofile)
	{
			try {
				input = AudioSystem.getAudioInputStream(audiofile);
		        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
		                      AudioSystem.NOT_SPECIFIED,
		                      16, 2, 4,
		                      AudioSystem.NOT_SPECIFIED, true);
		        DataLine.Info info = new DataLine.Info(Clip.class, format);
		        System.out.println(AudioSystem.getLine(info));
		        clip = (Clip)AudioSystem.getLine(info);
		       
		        clip.open(input);
				System.out.println(5);
				volumecontrol = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
				/**/
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public <get> String getState()
	{
		return state;
	}
	
	public void play()
	{
		clip.start();
		clip.setMicrosecondPosition(startpoint);
		state = "playing";
		startpoint = 0;
	}
	
	public void stop()
	{
		startpoint = 0;
		clip.stop();
		state = "stopped";
	}
	
	public void pause()
	{
		startpoint = clip.getMicrosecondPosition();
		clip.stop();
		state = "paused";
	}
	
	public void adjustVolume(float adjustment)
	{
		if (volumecontrol.getValue() + adjustment >= volumecontrol.getMinimum() &&
			volumecontrol.getValue() + adjustment <= volumecontrol.getMaximum())
		{
			volumecontrol.setValue(volumecontrol.getValue() + adjustment);
		}
	}
}
