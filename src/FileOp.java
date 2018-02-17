import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

public class FileOp {
    //List<String> dataList = new ArrayList<>();
    static String fileName = "data";

    public void FileRead() {
        try {
            Scanner in = new Scanner(new File(fileName + ".txt"));
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }

    }

    public int countWords(String word) {
        int counter = 0;
        String test;
        try {
            Scanner in = new Scanner(new File(fileName + ".txt"));
            while (in.hasNext()) {
                test = in.nextLine();
                //System.out.println(test);
                if (test.equals(word)) {
                    counter++;
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }


        return counter;
    }

    public int countChars(char letter) {
        int chars = 0;
        int ch;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
            while ((ch = reader.read()) != -1) {
                if ((char) ch == letter) {
                    chars++;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("brak pliku");
        }


        return chars;

    }

    public void deleteStringToNewFile(String delStr) {
        File tempFile = new File(delStr + "_temp" + ".txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(delStr)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));

            }
            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteStringToSameFile(String delStr) {
        File mainFile = new File(fileName + ".txt");
        File tempFile = new File(delStr + "_temp" + ".txt");
        deleteStringToNewFile(delStr);
        // Files.deleteIfExists(fileName);
        mainFile.delete();
        tempFile.renameTo(mainFile);

    }

    public void modify(String modStr, String modMod) { //??
        File tempFile = new File(modStr + "_temp" + ".txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String modLine = currentLine.trim();
                if (modLine.equals(modStr)) {
                    writer.write(modMod + System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }

            }
            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortAsc() {
        try {
            ArrayList<String> rows = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

            String s;
            while ((s = reader.readLine()) != null)
                rows.add(s);

            Collections.sort(rows);

            FileWriter writer = new FileWriter(fileName + "sortAsc" + ".txt");
            for (String cur : rows)
                writer.write(cur + System.getProperty("line.separator"));

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("exception");
        }
    }

    public void sortDsc() {
        try {
            ArrayList<String> rows = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

            String s;
            while ((s = reader.readLine()) != null)
                rows.add(s);

            Collections.sort(rows, Collections.reverseOrder());
            // Collections.reverseOrder();

            FileWriter writer = new FileWriter(fileName + "sortDsc" + ".txt");
            for (String cur : rows)
                writer.write(cur + System.getProperty("line.separator"));

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("exception");
        }
    }

    public void insertInto(String what, int where) {
        File tempFile = new File(fileName + "_insertInto" + ".txt");
        int lineCounter = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (lineCounter == where) {
                    writer.write(what + System.getProperty("line.separator"));
                }
                writer.write(currentLine + System.getProperty("line.separator"));
                lineCounter++;
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readURL() {
        try {
            int countWords = 0;
            int countLetters = 0;
            URL url = new URL("http://www.puzzlers.org/pub/wordlists/pocket.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                System.out.println(currentLine);
                countWords++;
                countLetters+=currentLine.length();
            }
            in.close();
            System.out.println(countWords);
            System.out.println(countLetters);
        } catch (IOException e) {
            System.out.println("exception in URL reading");
        }
    }
}
