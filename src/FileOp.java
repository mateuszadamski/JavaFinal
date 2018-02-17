import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class FileOp {
    List<String> dataList = new ArrayList<>();
    static String fileName = "data";
    public void FileRead(){
        try {
            Scanner in = new Scanner(new File(fileName +".txt"));
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
                //dataList.add(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }

    }
    public void AddToFile(String addStrToFile){
        try {
            PrintWriter pw = new PrintWriter("data.txt");
            pw.println(addStrToFile);
            pw.close();
            pw.flush();
        }catch(FileNotFoundException e){
            System.out.println("brak pliku");
        }
    }

    public int countWords(String word){
        int counter = 0;
        String test;
        try {
            Scanner in = new Scanner(new File("data.txt"));
            while (in.hasNextLine()) {
                test = in.next();
                if(test.equals(word)){
                    counter++;
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }


        return counter;
    }
    public int countChars(char letter){
        int counter = 0;
        char scanner;
        try {
            Scanner in = new Scanner(new File("data.txt"));
            //scanner = in.next();
            /*while(){

            }*/

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }


        return counter;

    }

    public void deleteString(String delStr){
        try {
            //potrzebuje liste z pliku zeby usunac i zapisac od nowa?
            Scanner in = new Scanner(new File("data.txt"));
            PrintWriter pw = new PrintWriter(new File("dane.txt"));
            String del = in.nextLine();
            //scanner = in.next();
            if (!del.trim().equals(delStr)) {
                pw.println();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }


    }
    public void modify(String modStr,String modMod){
        try {
            Scanner in = new Scanner(new File("data.txt"));
            String rep = in.nextLine();
            //scanner = in.next();
            rep = rep.replace(modStr,modMod);

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }

    }
}
