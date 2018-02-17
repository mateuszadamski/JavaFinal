import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String addThis = "add this";
        String deleteThis = "Janek";
        String countThis = "Janek";
        String s1 = "Asia";
        String s2 = "Kasia";
        char countChar = 'a';
        int count;
        FileOp fileReader = new FileOp();
        int s;
        int check1;
        Scanner sc = new Scanner(System.in);
        System.out.println("podaj liczbe: ");
        System.out.println("1: zliczenie slowa " +countThis);
        System.out.println("2: zliczenie znaku " +countChar);
        System.out.println("3: usuwanie ciagu z zapisem do nowego pliku "+ deleteThis);
        System.out.println("4: zamiana ciagu na inny " +s1 +" na "+s2);
        System.out.println("5: dodanie we wskazanym miejscu ciagu"+ addThis);
        System.out.println("6: sortowanie rosnaco");
        System.out.println("7: sortowanie malejaco");
        System.out.println("8: przeczytaj URL i policz wszystkie slowa i wszystkie litery");
        System.out.println("0 aby wyjsc");
        s = sc.nextInt();

            switch (s) {
                case 1: {
                    count = fileReader.countWords(countThis);
                    System.out.println(count);
                    break;
                }
                case 2: {
                    count = fileReader.countChars(countChar);
                    System.out.println(count);
                    break;
                }
                case 3: {
                    fileReader.deleteStringToNewFile(deleteThis);
                    System.out.println("zapisac do instniejacego pliku (1) czy do nowego pliku (2)");
                    check1 = sc.nextInt();
                    if (check1 == 1) {
                        fileReader.deleteStringToSameFile(deleteThis);
                    }
                    break;
                }
                case 4: {
                    fileReader.modify(s1, s2);

                    break;
                }
                case 5: {
                    System.out.println("Podaj w ktore miejsce (integer)");
                    int place = sc.nextInt();
                    fileReader.insertInto(addThis,place);
                    break;
                }
                case 6: {
                    fileReader.sortAsc();

                    break;
                }
                case 7: {
                    fileReader.sortDsc();
                    break;
                }
                case 8: {
                    fileReader.readURL();
                    break;
                }

            }
        }
    }
