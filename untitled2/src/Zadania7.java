
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


class Zadania7{
    public static void zad1() throws IOException {
        System.out.println("Zad1");
        int[] threeValues = liczZnakiiSlowa("src/okej");
        System.out.println("Liczba znakow: " + threeValues[0] + " Liczba bialych znakow: " + threeValues[1] + " Liczba slow: " + threeValues[2]);
    }
    private static int wordCount(String text) { //z pdf5
        int wordCount = 0;
        boolean wordEnded = false;
        for (int i = 0; i < text.length(); i++) {
            if (wordCount == 0 && !Character.isWhitespace(text.charAt(i))) wordCount++;
            if (wordCount > 0 && !wordEnded && Character.isWhitespace(text.charAt(i))){
                wordEnded = true;
            }
            if (wordCount > 0 && wordEnded && !Character.isWhitespace(text.charAt(i))) {
                wordEnded = false;
                wordCount++;
            }
        }
        return wordCount;
    }

    public static void szukaj(String nazwaPlikWe, String nazwaPlikWy,String slowo){
        BufferedReader fileread =null;
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(nazwaPlikWe)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int[] liczZnakiiSlowa(String filePath) throws IOException {
        int charCount = 0, whiteCharCount = 0, wordCount = 0;
        int[] threeValues = new int[3];
        String text = "";
        try{
            text = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println(text);
            char[] charArr = text.toCharArray();
            for (int i = 0; i < charArr.length; i++){
                charCount++;
                if(charArr[i] == ' ' || charArr[i] == '\n' || charArr[i] == '\t') whiteCharCount++;
            }
            wordCount = wordCount(text);
        } catch (IOException e) {
            System.out.println("Wystapil blad czytania pliku!");
        }
        threeValues[0] = charCount;
        threeValues[1] = whiteCharCount;
        threeValues[2] = wordCount;
        return threeValues;
    }
}