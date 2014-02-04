package edu.grinnell.csc207.callaway.utils;

import java.math.BigInteger;

public class Calculator {

    public static BigInteger eval0(String str)
    {
	int j=0, k=0;
	while (j<(str.length()) && str.charAt(j)!= ' ')
	    j++;
	BigInteger num = BigInteger.valueOf(Long.parseLong(str.substring(0, j)));
	
	for(int i=0; i<str.length(); i++)
	{
	    if (str.charAt(i)== ' ')
	    {
		i++;
		k=i+2;
		if (str.charAt(i)=='+')
		{
    			while (k<(str.length()) && !(str.charAt(k)==' '))
    			    k++;
    			num= num.add(BigInteger.valueOf(Long.parseLong(str.substring(i+2, k))));
    			k=0;
		}//if(+)
		else if (str.charAt(i)=='-')
		{
		    while (k<(str.length()) && !(str.charAt(k)==' '))
			    k++;
			num= num.subtract(BigInteger.valueOf(Long.parseLong(str.substring(i+2, k))));
			k=0;
		}//if(-)
		else if (str.charAt(i)=='*')
		{
		    while (k<(str.length()) && !(str.charAt(k)==' '))
			    k++;
			num= num.multiply(BigInteger.valueOf(Long.parseLong(str.substring(i+2, k))));
			k=0;
		}//if(*)
		else if (str.charAt(i)=='/')
		{
		    while (k<(str.length()) && !(str.charAt(k)==' '))
			    k++;
			num= num.divide(BigInteger.valueOf(Long.parseLong(str.substring(i+2, k))));
			k=0;
		}//if(/)
		else if (str.charAt(i)=='^')
		{
		    while (k<(str.length()) && !(str.charAt(k)==' '))
			    k++;
			num= num.pow(Integer.parseInt(str.substring(i+2, k)));//(Long.parseLong(str.substring(i+2, k))));
			k=0;
		}//if(^)
		
	    }//if(' ')
	}//for
	return num;
    }//eval0
    
    public static void main(String[]args)
    {
	System.out.println(eval0("44 - 23 + 434 * 2 / 4 ^ 5"));
    }
}//Calculator
