package edu.grinnell.csc207.callaway.utils;

import static org.junit.Assert.*;
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
   
    @Test
    public void testSplitCSV() {
	assertArrayEquals ("1",new String[] { "a", "b", "c" },
                StringUtils.splitCSV("a,b,c"));
	assertArrayEquals ("2",new String[] { "a,b", "c" },
                StringUtils.splitCSV("\"a,b\",c"));
	assertArrayEquals ("3",new String[] { "a", "b,b\"", "c" },
                StringUtils.splitCSV("a,\"b,b\"\"\",c"));
	assertArrayEquals ("4",new String[] { "a", "b,b\"", "c,d" },
	                   StringUtils.splitCSV("a,\"b,b\"\"\",\"c,d\""));
	assertArrayEquals ("5", new String[] { "axs", "34\"", "sd" },
                           StringUtils.splitCSV("axs,34\"\",\"sd\""));

    }
    
    @Test
    public void deLeetTest() {
    	assertEquals ("e", StringUtils.deLeet ("3"));
    	assertEquals ("leet", StringUtils.deLeet ("133+"));
    	assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
    	assertEquals ("eat dd |xeacnan", StringUtils.deLeet ("3@+ dd |x3@c|\\|@|\\|"));
    }//deLeetTest
    
    
    

}
