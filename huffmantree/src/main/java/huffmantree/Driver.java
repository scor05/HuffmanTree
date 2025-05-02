package huffmantree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase principal que deja cargar archivos y los muestra comprimidos y descomprimidos.
 */
public class Driver{
    public static void main( String[] args ){
        
    }

    public ArrayList<String> readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> tokens = new ArrayList<>();
        while((line = br.readLine()) != null) {
            tokens.add(line);
        }
        br.close();
        return tokens;
    }
}
