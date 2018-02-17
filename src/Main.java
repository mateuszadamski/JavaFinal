import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String addThis = "add this";
        String countThis = "Janek";
        Scanner sc = new Scanner(System.in);
        String check;
        System.out.println("Zapis do pliku data.txt = 1 a do innego = 2");
        check = sc.nextLine();
        if(check.equals("1")){
            FileOp.fileName = "data";
        }else if(check.equals("2")){
            System.out.println("Podaj nowa nazwe pliku");
            FileOp.fileName = sc.nextLine();
            try {
                PrintWriter pw = new PrintWriter(FileOp.fileName+".txt");
                pw.close();
                pw.flush();
            }catch(FileNotFoundException e){
                System.out.println("brak pliku");
            }
        }else{
            System.out.println("nie ma takiego numeru");
            return;
        }
        FileOp fileReader = new FileOp();
        fileReader.FileRead();
        /*fileReader.AddToFile(addThis);
        fileReader.FileRead();*/
       // fileReader.countWords(countThis);

    }
}
