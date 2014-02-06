package edu.grinnell.csc207.callaway.utils;

import java.util.ArrayList;

/**
 * A class designed with methods to split a string into elements of an array, to
 * change some "leet" characters into normal characters, and to produce a verse
 * of a song that can rhyme with (almost) any name.
 * 
 * @author Erin Callaway
 * @version 1.0 of February 5, 2014
 * 
 * Help Accepted: The idea to use ArrayLists in the splitCSV method
 * came from Alex Greenberg.
 */
public class StringUtils
{
  /**
   * "splitAt" takes the specified string and splits it into substrings in an
   * array based on the separator character that is given.
   */
  public static String[] splitAt(String str, char separator)
  {
    int k = 0, j = 0, count = 0, size = 1;

    for (int i = 0; i < str.length(); i++)
      {
        if (str.charAt(i) == separator)
          size++;
      }// for(i<str.length)

    String newArray[] = new String[size];

    if (size == 1)
      newArray[0] = str;
    else
      {
        for (j = 0; j < str.length(); j++)
          {
            if (str.charAt(j) == separator)
              {
                if (k > 0)
                  count--;
                newArray[k] = str.substring(j - count, j);
                k++;
                count = 0;
              }// if(str.char=separator)
            else if (j == str.length() - 1)
              {
                newArray[k] = str.substring(j - count + 1);
              }// else if (j=str.length-1)
            count++;
          }// for(j)
      }// else
    if (str.charAt(str.length() - 1) == separator)
      newArray[k] = "";

    return newArray;
  }// splitAt(string, char)

  /**
   * "rmvDoubleQts" is a helper method for the "splitCSV" method. It takes the
   * given word and replaces any double quotation marks with a single quotation
   * mark.
   */
  public static String rmvDoubleQts(String word)
  {
    String newWord = "";
    for (int l = 0; l < word.length(); l++)
      {
        if (l < (word.length() - 1) && word.charAt(l) == '"'
            && word.charAt(l + 1) == '"')
          l++;

        newWord += word.charAt(l);
      }// for(l=0, l<=word.length)
    return newWord;
  }

  /**
   * "splitCSV" takes the given string and produces an array containing
   * substrings that were separated by a comma. However, if the comma is within
   * two quotation marks along with other characters it is considered part of
   * the substring element in the array.
   */
  public static String[] splitCSV(String str)
  {
    int k = 0;
    
    ArrayList<String> newArrLst = new ArrayList<String>();

    for (int i = 0; i < str.length(); i++)
      {
        if (i == 0 && str.charAt(0) != '"')
          {
            while (k < (str.length()) && !(str.charAt(k) == ','))
              k++;

            newArrLst.add(rmvDoubleQts(str.substring(i, k)));
            i = k - 1;
          }// if(i=0, str.charAt(0) != ")
        else if (str.charAt(i) == '"')
          {
            i++;
            k = i;
            while (k < (str.length() - 1)
                   && !((str.charAt(k) == '"') && (str.charAt(k + 1) == ',')))
              k++;

            newArrLst.add(rmvDoubleQts(str.substring(i, k)));

            i = k;
          }// if(")
        else if (str.charAt(i) == ',')
          {
            i++;
            k = i;
            if (str.charAt(k) != '"')
              {
                while (k < (str.length()) && !(str.charAt(k) == ','))
                  k++;
                newArrLst.add(rmvDoubleQts(str.substring(i, k)));
                i = k - 1;
              }// if (str.char != ")
            else
              i--;
          } // else if (str.char = ',')

      }// for (i)

    return newArrLst.toArray(new String[newArrLst.size()]);
  }// splitCSV

  /**
   * "deLeet" takes the given string of "leet" text and returns the more
   * standard form (alphabet characters).
   */
  public static String deLeet(String str)
  {
    String leet = "";
    for (int i = 0; i < str.length(); i++)
      {
        if (str.charAt(i) == '@')
          leet = leet.concat("a");
        else if (str.charAt(i) == '+')
          leet = leet.concat("t");
        else if (str.charAt(i) == '1')
          leet = leet.concat("l");
        else if (str.charAt(i) == '0')
          leet = leet.concat("o");
        else if ((i + 3 <= str.length())
                 && (str.substring(i, i + 3)).equals("|\\|"))
          {
            leet = leet.concat("n");
            i += 2;
          }// else if(n)
        else if ((i + 2 <= str.length())
                 && (str.substring(i, i + 2)).equals("|3"))
          {
            leet = leet.concat("b");
            i++;
          }// else if (b)
        else if (str.charAt(i) == '3')
          leet = leet.concat("e");
        else
          leet = leet.concat(str.substring(i, i + 1));
      }// for
    return leet;
  }// deLeet

  /**
   * Preconditions: Parameter must be a valid string. Names given must not begin
   * with a vowel. Otherwise the rhyme cannot be guaranteed.
   * 
   * Postconditions: A verse from Shirley Ellis's algorithm "The Name Game" will
   * be returned. The verse will rhyme with the name given as the parameter.
   */
  public static String nameGame(String str)
  {
    String namPart = "";
    String verse = "";
    if (!(str.charAt(1) == 'a' || str.charAt(1) == 'e' || str.charAt(1) == 'i'
          || str.charAt(1) == 'o' || str.charAt(1) == 'u' || str.charAt(1) == 'y'))
      namPart = str.substring(2);
    else
      namPart = str.substring(1);
    verse =
        str + "!\n" + str + ", " + str + " bo B" + namPart
            + " Bonnana fanna fo F" + namPart + "\nFee fi fo M" + namPart
            + ", " + str + "!";
    return verse;
  }// nameGame

}// StringUtils
