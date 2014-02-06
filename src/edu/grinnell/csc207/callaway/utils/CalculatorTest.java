package edu.grinnell.csc207.callaway.utils;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

public class CalculatorTest
{
  @Test
  public void eval0Test()
  {
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
    assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
    assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    assertEquals(BigInteger.valueOf(1), Calculator.eval0("1 - 2 + 4 / 3"));
    assertEquals(BigInteger.valueOf(-2), Calculator.eval0("1 - 5 / 2"));
    assertEquals(BigInteger.valueOf(27), Calculator.eval0("1 + 2 ^ 3"));
  }// eval0Test

}
