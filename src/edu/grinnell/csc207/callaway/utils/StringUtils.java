package edu.grinnell.csc207.callaway.utils;

import java.util.*;

public class StringUtils {

	public static String[] splitAt(String str, char seperator) {
		int k = 0, j = 0, count = 0, size = 1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == seperator) {
				size++;
			}// if
		}// for(i)

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
				}// if(str==sep)
				else if (j == str.length() - 1) {
					newArray[k] = str.substring(j - count + 1);
				}// else if
				count++;
			}// for(j)
		}// else
		if (str.charAt(str.length() - 1) == seperator)
			newArray[k] = "";

		return newArray;
	}// splitAt(string, char)

	public static String[] splitCSV1(String str) {
		String newArray[] = new String[10];
		char seperator = ',';
		int k = 0, count = 0, num = 1, x = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '"' && (num % 2 != 0)) {
				if (x == 0) {
					x++;
					num--;
				}
				num++;
				i++;
				int temp = i;

				while (i < str.length() && str.charAt(i) != '"') {
					count++;
					i++;
				}// while
				if (str.charAt(i) == '"')
					num++;
				/*
				 * if (i== str.length()-1) { i=temp+1; }
				 */
				if (k == 0)
					newArray[k] = str.substring(i - count, i);
				else {
					newArray[k] = str.substring(i - count + 1, i + 1);

				}

				count = 0;
				k++;

			}// if
			else if (str.charAt(i) == seperator) {
				if (k > 0)
					count--;
				newArray[k] = str.substring(i - count, i);
				// if (k==0)
				k++;
				count = 0;

			}// else if(str==sep)
			else if (i == str.length() - 1) {
				newArray[k] = str.substring(i - count + 1);
			}// else if
			count++;
		}// for

		return newArray;
	}// splitCSV

	public static String[] splitCSV(String str) {
		String newArray[] = new String[10];
		char seperator = ',';
		int k = 0, count = 0, num = 0;
		// num: removes the quote at the end of a quoted section
		for (int i = 0; i < str.length(); i++) {
			if ((i == 0 && str.charAt(i) == '"')
					|| (str.charAt(i) == '"' && str.charAt(i - 1) == ',')) {
				while (!(str.charAt(i) == ',')) {
					if (str.charAt(i) == '"') { // removes the beginning quote
												// from a quoted section
						count = 0;
						if (str.charAt(i + 1) == '"') /** !!!!!!!!!! */
						{

						}
					}
					count++; // makes sure all parts before the last quote are
								// added
					i++;
				}// while
				if (str.charAt(0) == '"') // removes the beginning quote from a
											// quoted section at 0
					count--;
				num++; // removes the quote at the end of a quoted section
			}// if
			else if (str.charAt(i) == seperator) {
				if (k > 0)
					count--; // removes extra spaces that sometimes occur

				newArray[k] = str.substring(i - count, i - num);
				k++; // moves to next element in the array
				count = 0; // resets the count so that new info can be read
				num = 0; // makes sure that the parts without quotes don't
							// remove the extra element where a " would be

			}// else if(str==sep)
			else if (i == str.length() - 1) { // accounts for the last element
												// that is added
				newArray[k] = str.substring(i - count + 1);
			}// else if
			count++;
		}// for

		return newArray;
	}// splitCSV

	public static String deLeet(String str) {
		String leet = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '@')
				leet = leet.concat("a");
			else if (str.charAt(i) == '+')
				leet = leet.concat("t");
			else if (str.charAt(i) == '1')
				leet = leet.concat("l");
			else if (str.charAt(i) == '0')
				leet = leet.concat("o");
			else if ((i + 3 <= str.length())
					&& (str.substring(i, i + 3)).equals("|\\|")) {
				leet = leet.concat("n");
				i += 2;
			}// else if(n)
			else if ((i + 2 <= str.length())
					&& (str.substring(i, i + 2)).equals("|3")) {
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

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(new String[] {"a", "b,b\"", "c"
		// }));
		// System.out.println(Arrays.toString(splitCSV("a,\"b,b\"\"c\"\"\",c,l,m.")));
		// System.out.println(Arrays.toString(splitCSV("\"a,b\",c")));
		// System.out.println(Arrays.toString(splitCSV("a,b,c")));
		System.out.println(("rt3r3|\\|+@3"));
		System.out.println(deLeet("rjhg |3 r 3 |\\| + @ 3 dsgf"));
	}
}// StringUtils
