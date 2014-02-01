package edu.grinnell.csc207.callaway.utils;

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
}//StringUtils
