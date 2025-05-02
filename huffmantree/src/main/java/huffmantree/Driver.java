package huffmantree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que deja cargar archivos y los muestra comprimidos y descomprimidos.
 */
public class Driver{
    public static void main( String[] args ){
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("--------------------------------");
            System.out.println("\tÁrbol de Huffman");
            System.out.println("--------------------------------");
            System.out.print("\n\nIngrese el nombre del archivo que desea comprimir (Asegúrese que esté dentro de la carpeta 'huffmantree'): \nR/ ");
            String fileName = input.nextLine();
            ArrayList<String> data = new ArrayList<>();
            try{
                data = readFile(fileName);
            }catch (IOException E){
                System.out.println("Hubo un error al leer el archivo, pruebe otra vez." + E.getMessage());
            }

            HuffmanTree<String> ht = new HuffmanTree();
        } while (loop);
    }

    public static ArrayList<String> readFile(String fileName) throws IOException {
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
