import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class WordReader {
  private Scanner scanner;

  public WordReader(String filename) {
    try {
      this.scanner = new Scanner(new File(filename), "UTF-8");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public WordReader(Readable in) {
    this.scanner = new Scanner(in);
  }

  public String read() {
    if (this.scanner == null)
      return null;
    if (this.scanner.hasNext())
      return scanner.next();

    return null;
  }

}
