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
		
		Clip clip = AudioSystem.getClip();//CREATING AN INSTANCE OF THE CLASS CLIP
		clip.open(audioStream);//USING THE OBJECT CLIP TO ACCESS THE AUDIO STREAM
		
		
		String response ="";
		while(!response.equals("Q")) {
			System.out.println("P = play");
			System.out.println("S = Stop");
			System.out.println("R = Reset");
			System.out.println("Q=  Quit");		
			System.out.print("Enter your choice\t");
			
			response  = input.nextLine().toUpperCase();
			
			switch(response) {
			case "P" ->clip.start();//TO PLAY THE SUPPORTED MUSIC FILE 
			case "S" ->clip.stop();//TO STOP PLAYING NUSIC
			case "R"->clip.setMicrosecondPosition(0);//RESTART THE MUSIC FROM 0 MS
			case"Q"->clip.close();//CLOSE THE MUSIC FILE 
			default ->System.out.println("Invalid response");//IF THE USER ENTERS ANYTHING ELSE BUT P,S,r,q
			}
		}
		 
		
		
		
	}

	//EXCEPTION HANDLING IF THE AUDIO FILE CANNOT BE IMPORTED INTO THE PROGRAM
	catch(FileNotFoundException e) {
		System.out.println("Couldn't import file");
	}

	//CATCHES EXCEPTION WHEN USER TRIES TO OPEN UNACCEPTED FILES TYPE WITH EXTENSION OTHER THAN .WAV, .AU, .AIFF	
	catch(UnsupportedAudioFileException e) {
		System.out.println("Audio file is not supported");
	}

	//CATCHES EXCEPTIONS WHEN THE APPLICATION FAILS TO ACCESS THE AUDIO RESOUCES, NOT READABLE BY THE PROGRAM 
	catch(LineUnavailableException e) {
		System.out.println("Unable to access audio resource");
	}

	//CATCHES EXCEPTION IF THE USER ENTER INVALID INPUT 
	catch(IOException e) {
		System.out.println("Something went wrong");
	}
		
	finally {
		System.out.println("Bye");
	}
}

}
