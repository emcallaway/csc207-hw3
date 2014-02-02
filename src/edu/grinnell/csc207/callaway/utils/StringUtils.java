package edu.grinnell.csc207.callaway.utils;
import java.util.*;

public class StringUtils {
    public static String[] splitAt(String str, char seperator) {
	int k = 0, j = 0, count = 0, size = 1;

	for (int i = 0; i < str.length(); i++) {
	    if (str.charAt(i) == seperator) {
		size++;
	    }//if
	}//for(i)

	String newArray[] = new String[size];
	if (size == 1)
	    newArray[0] = str;
	else {
	    for (j = 0; j < str.length(); j++) {
		if (str.charAt(j) == seperator) {
		    if (k > 0)
			count--;
		    newArray[k] = str.substring(j - count, j);
		    k++;
		    count = 0;
		}//if(str==sep) 
		else if (j == str.length() - 1) {
		    newArray[k] = str.substring(j - count + 1);
		}//else if
		count++;
	    }//for(j)
	}//else
	if (str.charAt(str.length() - 1) == seperator)
	    newArray[k] = "";
	
	return newArray;
    }//splitAt(string, char)

    public static String[] splitCSV(String str)
    {
	String newArray[] = new String[10];
	char seperator = ',';
	int k=0, count=0;
	
	for(int i=0; i<str.length(); i++)
	{
	    if (str.charAt(i) == '"')
	    {
		i++;
		int temp = i;
		while(str.charAt(i)!='"')
		{
		    count++;
		    i++;
		}//while
		    
		if (i== str.length()-1)
		{
		    i=temp;
		}
		newArray[k] = str.substring(i - count, i);    
		count=0;
		k++;
		
	    }//if
	    else if (str.charAt(i) == seperator) 
	    {
		if (k > 0)
			count--;
		newArray[k] = str.substring(i - count, i);
		k++;
		count = 0;
	    }//else if(str==sep) 
	    else if (i == str.length() - 1) {
		    newArray[k] = str.substring(i - count + 1);
		}//else if
	    count++;
	}//for
	
	return newArray;
    }//splitCSV
    
    public static void main(String[]args)
    {
	System.out.println(Arrays.toString(splitCSV("a,\"b,b\"\"\",c")));
    }
}//StringUtils
