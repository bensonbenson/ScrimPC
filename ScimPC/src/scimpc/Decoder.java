package scimpc;

// File imports.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Regex imports
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Container imports.
import java.util.ArrayList;
import java.util.TreeMap;

public class Decoder {
    
    Decoder()
    {
    }
    
    boolean LoadInstructions(String scrimFileName, ArrayList iMem, TreeMap labels) {
        try {
            // Check if the image is a .scrim file.
            final String fileExtension = "([^\\s]+(\\.(?i)(scrim))$)";
            Matcher matcher;
            Pattern pattern;
            pattern = Pattern.compile(fileExtension);
            matcher = pattern.matcher(scrimFileName);
            if(matcher.matches()) {
                System.out.println("Invalid source file specified: Must be a .scrim file.");
                return false;
            }            
            
            // Open the file and load into buffer.
            File scrimFile = new File(scrimFileName);            
            FileReader scrimFileReader = new FileReader(scrimFile);            
            BufferedReader bufferedReader = new BufferedReader(scrimFileReader);
            
            // Read file to eof. Insert each line into instruction memory.
            String instruction;            
            while((instruction = bufferedReader.readLine()) != null) {
                iMem.add(instruction);
            }
        } catch (IOException exception) {
            System.out.println("File '" + scrimFileName + "' not found.");
            return false;
        }        
        return true;
    }
    
}
