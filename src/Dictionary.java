import java.io.*;
import java.util.ArrayList;

//***********************************
// Ryan Hughes
//
// This class reads the file pointed to by the dictionary
// and stores each line as a dictionary entry. The file
// it points to should have one word per line with no punctuation.
// Dictionary then stores each line in an ArrayList for future
// access. it has only one method that is used for checking
// whether a string is in the dictionary.
//***********************************

public class Dictionary
{
  private ArrayList<String> dict;

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

  public boolean contains(String query) {return dict.contains(query.toLowerCase());}
}
