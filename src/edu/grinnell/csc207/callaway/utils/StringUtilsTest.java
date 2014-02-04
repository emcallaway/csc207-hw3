package edu.grinnell.csc207.callaway.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void splitAtTest() {
	assertArrayEquals("1", new String[] { "a", "b", "c" },
		StringUtils.splitAt("a:b:c", ':'));
	assertArrayEquals("2",new String[] { "a", "b", "c" },
		StringUtils.splitAt("a b c", ' '));
	assertArrayEquals("3", new String[] { "a:b:c" },
		StringUtils.splitAt("a:b:c", ' '));
	assertArrayEquals("one field", new String[] { "a" },
		StringUtils.splitAt("a", ':'));
	assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
		StringUtils.splitAt("a::c", ':'));
	assertArrayEquals("leading empty field", new String[] { "", "a" },
		StringUtils.splitAt(":a", ':'));
	assertArrayEquals("trailing empty field", new String[] { "a", "" },
		StringUtils.splitAt("a:", ':'));
    }//splitAtTest
  /*  
    @Test
    public void testSplitCSV() {
	assertArrayEquals (new String[] { "a", "b", "c" },
                StringUtils.splitCSV("a,b,c"));
//	assertArrayEquals (new String[] { "a,b", "c" },
//                StringUtils.splitCSV("\"a,b\",c"));
	assertArrayEquals (new String[] { "a", "b,b\"", "c" },
                StringUtils.splitCSV("a,\"b,b\"\"\",c"));
    }*/
    
    @Test
    public void deLeetTest() {
    	assertEquals ("e", StringUtils.deLeet ("3"));
    	assertEquals ("leet", StringUtils.deLeet ("133+"));
    	assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
    	assertEquals ("eat dd |xeacnan", StringUtils.deLeet ("3@+ dd |x3@c|\\|@|\\|"));
    }//deLeetTest
    
    @Test
    public void eval0Test() {
	assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("0"));
	assertEquals (BigInteger.valueOf (2), Calculator.eval0 ("1 + 1"));
	assertEquals (BigInteger.valueOf (4), Calculator.eval0 ("1 + 2 + 1"));
	assertEquals (BigInteger.valueOf (9), Calculator.eval0 ("1 + 2 * 3"));
	assertEquals (BigInteger.valueOf (1), Calculator.eval0 ("1 - 2 + 4 / 3"));
	assertEquals (BigInteger.valueOf (-2), Calculator.eval0 ("1 - 5 / 2"));
	assertEquals (BigInteger.valueOf (27), Calculator.eval0 ("1 + 2 ^ 3"));
	
    }//eval0Test
    

}
