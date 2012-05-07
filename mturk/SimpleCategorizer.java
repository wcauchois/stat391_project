import org.knallgrau.utils.textcat.TextCategorizer;
import java.io.*;

public class SimpleCategorizer {
   public static void main(String[] args) throws IOException {
      TextCategorizer guesser = new TextCategorizer();
      BufferedReader inputReader = new BufferedReader(
                                     new InputStreamReader(System.in));
      String line = inputReader.readLine();
      if(line == null) {
        System.out.println("unknown");
      } else {
        String category = guesser.categorize(line);
        System.out.println(category);
      }
   }
}

