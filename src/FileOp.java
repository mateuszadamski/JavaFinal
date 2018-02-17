import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class FileOp {
    List<String> dataList = new ArrayList<>();
    public void FileRead(){
        try {
            Scanner in = new Scanner(new File("data.txt"));
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
            while (in.hasNext()) {
              /*  if(in == letter){
                    counter++;
                }*/
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }


        return counter;

    }

    public void deleteString(String delStr){

    }
    public void modify(String modStr){

    }
}
