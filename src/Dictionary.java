import java.io.*;
import java.util.ArrayList;

public class Dictionary
{
  private ArrayList<String> dict;
  BufferedReader reader;

  public Dictionary()
  {
    try
    {
      dict = new ArrayList<>();
      BufferedReader reader = new BufferedReader(new FileReader(new File(Reference.DICTIONARY)));
      if(reader != null)
      {
        String line;
        while((line = reader.readLine()) != null)
        {
          if(line.length() > 2)
          {
            dict.add(line);
          }
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  public boolean contains(String query) {return dict.contains(query);}
}
