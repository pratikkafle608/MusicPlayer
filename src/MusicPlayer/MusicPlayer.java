package MusicPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayer {
	public static void main(String[] args) {
	
	//HOW TO PLAY AUDIO WITH JAVA(.WAV, .AU, .AIFF)
	
	String filePath = "C:/Users/prati/Music/Maestro Chives, Egzod, Neoni - Royalty [NCS Release].wav";
	File file = new File(filePath);
	
	try(Scanner input=  new Scanner(System.in);AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);) {
		
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		
		String response ="";
		while(!response.equals("Q")) {
			System.out.println("P = play");
			System.out.println("S = Stop");
			System.out.println("R = Reset");
			System.out.println("Q=  Quit");		
			System.out.print("Enter your choice\t");
			
			response  = input.nextLine().toUpperCase();
			
			switch(response) {
			case "P" ->clip.start();
			case "S" ->clip.stop();
			case "R"->clip.setMicrosecondPosition(0);
			case"Q"->clip.close();
			default ->System.out.println("Invalid response");
			}
		}
		 
		
		
		
	}
	
	catch(FileNotFoundException e) {
		System.out.println("Couldn't import file");
	}
	
	catch(UnsupportedAudioFileException e) {
		System.out.println("Audio file is not supported");
	}
	
	catch(LineUnavailableException e) {
		System.out.println("Unable to access audio resource");
	}
	
	catch(IOException e) {
		System.out.println("Something went wrong");
	}
	finally {
		System.out.println("Bye");
	}
}

}
