import java.io.File; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner; 
 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
 
public class SpotifyLikeApp { 
 
    // global variables for the app 
    String status; 
    Long position; 
    static Clip audioClip; 
static HashMap<String, String> song = new HashMap<>(); 
private static HashMap<String, Song> songs; 
private static boolean Playing; 
 
 
     
// "main" make this class a java app that can be executed 
public static void main(String[] args) { 
    Song s = new Song(); 
            s.setArtist("Ava_Luna"); 
            s.setTitle("cement"); 
            s.setYear("2015"); 
            s.setGenre("Pop"); 
            s.setFilePath("./Song/Ava_Luna_-_02_-_Cement_Lunch.wav"); 
 
            s = new Song(); 
            s.setArtist("Bisou"); 
            s.setTitle("Journey"); 
            s.setYear("2016"); 
            s.setGenre("Pop"); 
            s.setFilePath("./Song/Bisou_-_04_-_Journey_of_King.wav"); 
 
            s = new Song(); 
            s.setArtist("Checkie_Brown"); 
            s.setTitle("Tanzen"); 
            s.setYear("2015"); 
            s.setGenre("Pop"); 
            s.setFilePath("./Song/Checkie_Brown_-_10_-_Tanzen_CB_003.wav"); 
 
            s = new Song(); 
            s.setArtist("Checkie_Brown"); 
            s.setTitle("Wirklich_Wichtig"); 
            s.setYear("2015"); 
            s.setGenre("Pop"); 
            s.setFilePath("./Song/Checkie_Brown_-_11_-_Wirklich_Wichtig_CB_27.wav"); 
        // create a scanner for user input 
        Scanner input = new Scanner(System.in); 
 
        String userInput = ""; 
        while (!userInput.equals("q")){ 
 
            menu(); 
 
         
            // get input 
            userInput = input.nextLine(); 
 
            // accept upper or lower case commands  
            userInput.toLowerCase(); 
 
            // do something  
            handleMenu(userInput); 
             
 
        } 
 
        // close the scanner  
        input.close(); 
     
} 
 
private static void menu() { 
 
    System.out.println("---- SpotifyLikeApp ----"); 
        System.out.println("[H]ome"); 
        System.out.println("[S]earch by title"); 
        System.out.println("[L]ibrary"); 
        System.out.println("[P]lay"); 
        System.out.println("[Q]uit"); 
        System.out.println(""); 
 
        System.out.println(""); 
        System.out.print("Enter q to quit:"); 
} 
 
private static void handleMenu(String userInput) { 
    switch(userInput){ 
        case "h": 
             System.out.println("-->Home<--"); 
             break; 
        case "s": 
            System.out.println("-->Search by Title<--"); 
            Scanner input = new Scanner(System.in); 
            System.out.println("Please enter the Title:"); 
            String title = input.nextLine(); 
            Song playlist = songs.get(title); 
            System.out.println(playlist);
 /*
            if (song !=null) 
            { 
                System.out.println("Your current selection is now playing"); 
                 
                play(song.getFilePath()); 
 
            }else { 
                System.out.println("sorry, please search again."); 
 
                break; 
 
            } 
            */
        case "l": 
            System.out.println("-->Library<--"); 
            for(Map.Entry<String, Song> s : songs.entrySet()){ 
                System.out.println("Title: " + s.getValue().getTitle()); 
                System.out.println("Artist: " + s.getValue().getArtist()); 
                System.out.println("Gemre: " + s.getValue().getGenre()); 
                System.out.println("Year: " + s.getValue().getYear()); 
                System.out.println(""); 
            } 
            break; 
        case "p": 
            System.out.println("-->Play<--"); 
            break; 
        case "q": 
            System.out.println("-->Quit<--"); 
            break;


default: 
            break; 
    } 
 
} 
 
/* 
* plays an audio file 
*/ 
 
private static void play(String filePath) { 
    // open the audio file 
    File file = new File(filePath); 
    try { 
         if (Playing == true) 
         { 
             audioClip.stop(); 
             Playing = false; 
         } 
 
        // create clip  
        audioClip = AudioSystem.getClip(); 
        // get input stream 
        final AudioInputStream in = getAudionInputStream(file); 
        audioClip.open(in); 
        audioClip.setMicrosecondPosition(0); 
        audioClip.loop(Clip.LOOP_CONTINUOUSLY); 
        Playing = true; 
    } catch(Exception e) { 
        e.printStackTrace();  
    } 
     
} 
public static void Rewind()  
    { 
        Scanner input = new Scanner(System.in); 
        audioClip.stop(); 
        System.out.println(audioClip.getMicrosecondPosition()); 
        System.out.println("How far back would you like to go? + \n"); 
        Long Rewound = (input.nextLong()*1000); 
        Long CurrentTime = audioClip.getMicrosecondPosition(); 
        Long NewTime = CurrentTime - Rewound; 
        audioClip.setMicrosecondPosition(NewTime); 
        audioClip.loop(Clip.LOOP_CONTINUOUSLY); 
        System.out.println(audioClip.getMicrosecondPosition()); 
    } 
     
 
private static AudioInputStream getAudionInputStream(File file) { 
    return null; 
} 
 
     
 
 
}