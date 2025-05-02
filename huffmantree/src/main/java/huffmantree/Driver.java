package huffmantree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase principal que deja cargar archivos y los muestra comprimidos y descomprimidos.
 */
public class Driver{
    public static void main( String[] args ){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("--------------------------------");
            System.out.println("\tÁrbol de Huffman");
            System.out.println("--------------------------------");
            System.out.print("\nIngrese el nombre del archivo que desea comprimir (Asegúrese que esté dentro de la carpeta 'huffmantree', incluya también la extensión del archivo .txt) \n(Ingrese 's' para salir): \nR/ ");
            String fileName = input.nextLine();
            if (fileName.equals("s")){
                break;
            }
            StringBuilder data = new StringBuilder();
            try{
                data = readFile(fileName);
            }catch (IOException E){
                System.out.println("Hubo un error al leer el archivo, pruebe otra vez. Error: " + E.getMessage());
            }

            String text = data.toString();
            HuffmanTree ht = new HuffmanTree();
            ht.build(text);

            System.out.println("--------------------------------");
            System.out.println("\t Entrada original");
            System.out.println("--------------------------------");
            System.out.println(text);

            String encoded = ht.encode(text);
            System.out.println("--------------------------------");
            System.out.println("\t Texto codificado");
            System.out.println("--------------------------------");
            System.out.println(encoded);

            String decoded = ht.decode(encoded);
            System.out.println("--------------------------------");
            System.out.println("\t Texto decodificado");
            System.out.println("--------------------------------");
            System.out.println(decoded);

            System.out.println("--------------------------------");
            System.out.println("\t Tabla de caracteres");
            System.out.println("--------------------------------");
            HashMap<Character, String> m = (HashMap<Character, String>) ht.getCodes();
            for (Character c : m.keySet()){
                System.out.println("'" + c + "' : " + m.get(c));
            }
            
            
        } while (true);
        System.out.println("Gracias por utilizar nuestro código :D");
    }

    public static StringBuilder readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder b = new StringBuilder();
        while((line = br.readLine()) != null) {
            b.append(line).append("\n");
        }
        br.close();
        return b;
    }
}
