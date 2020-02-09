import java.io.*;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        FileWriter outputStream=null;
       System.out.print("Insert name to find:");
       boolean ok = false;
       String findName = new Scanner(System.in).nextLine();
       Scanner scannerText=null;
        try {
            outputStream= new FileWriter("outputPhonebook.txt");
            scannerText = new Scanner(new BufferedReader(new FileReader("phonebook.txt")));
            while (scannerText.hasNext())
            {
                String line = scannerText.nextLine();
                if (line.toLowerCase().contains(findName.toLowerCase())) {
                    System.out.println("Phone number of " + findName + " - " + line.substring(line.length()-10));
                    ok=true;
                    outputStream.write(line.substring(line.length() - 10));
                }
            }
        }
         finally {
            if(scannerText !=null)
                scannerText.close();
            if(!ok) {
                System.out.println(findName + " not found in file");
                outputStream.write(findName + " not found in file");
            }
            }
        outputStream.close();
    }
}

/*By using Scanner, find the phone number of a specific name. PhoneBook is persisted in the "phonebook.txt".

phonebook.txt

Abby 0321323132

Jolly 0313212222

Marius-Silviu Jilca 0313221222

Yey Ronaldo Perez 0231332211

Andrei Mladin 0731299212

Input

Marius

Output

0313221222

 */