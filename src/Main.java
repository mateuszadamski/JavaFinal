public class Main {

    public static void main(String[] args) {
        String addThis = "add this";
        String countThis = "Janek";
        FileOp fileReader = new FileOp();
        fileReader.FileRead();
        /*fileReader.AddToFile(addThis);
        fileReader.FileRead();*/
        fileReader.countWords(countThis);

    }
}
