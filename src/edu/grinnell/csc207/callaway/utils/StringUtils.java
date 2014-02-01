package edu.grinnell.csc207.callaway.utils;
import java.util.*;

public class StringUtils {
    public static String[] splitAt (String str, char seperator)
    {
	int size=1;
    
	for(int i=0; i<str.length(); i++)
	    {
		if (str.charAt(i) == seperator)
		{ size++;}}
	String newArray[] = new String[size];
	int k=0;
	int count=0;
	    for(int i=0; i<str.length(); i++)
	    {
		if (str.charAt(i) == seperator)
		{
		    if (k>0)
			count--;
		    newArray[k] = str.substring(i-count, i);
		    k++;
		    count=0;	
		}
		else if (i == str.length()-1)
		{
		    newArray[k] = str.substring(i-count+1);
		}
		count++;
	    }
	return newArray;
    }   
    
    public static void main(String[] args)
    {
	System.out.println(Arrays.toString(splitAt("as34:bzd:cdsf:sdf", ':')));
    }
}
