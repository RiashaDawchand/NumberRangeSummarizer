/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.numberrangesummarizer.NumberRangeSummarizerMain;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberRangeSummarizerTest {

    @Test
    public void testFormatRangeWithSampleInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        
        NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        String actualOutput = obj.summarizeCollection(obj.collect(input));
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testFormatRangeWithEmptyInput() {
        String input = "";
        String expectedOutput = "";
         NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        String actualOutput = obj.summarizeCollection(obj.collect(input));
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testFormatRangeWithSingleNumber() {
        String input = "24";
        String expectedOutput = "24";
        NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        String actualOutput = obj.summarizeCollection(obj.collect(input));
        assertEquals(expectedOutput, actualOutput);
    }
    
//    @Test
//    public void testFormatRangeWithTwoNonSequentialNumbers() {
//        String input = "3, 9";
//        String expectedOutput = "3, 9";
//        String actualOutput = NumberRangeSummarizerMain.formatRange(input);
//        assertEquals(expectedOutput, actualOutput);
//    }
    
    @Test
    public void testFormatRangeWithTwoSequentialNumbers() {
        String input = "5, 6";
        String expectedOutput = "5-6";
         NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        String actualOutput = obj.summarizeCollection(obj.collect(input));
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testFormatRangeWithNegativeNumbers() {
        String input = "-5,-4,-3,0,1,2";
        String expectedOutput = "-5--3, 0-2";
         NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        String actualOutput = obj.summarizeCollection(obj.collect(input));
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testFormatRangeWithDuplicateNumbers() {
      String input = "1,1,3,5,7,9,11,12,12,13,14,16";
      String expectedOutput = "1, 3, 5, 7, 9, 11-14, 16";
   NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        String actualOutput = obj.summarizeCollection(obj.collect(input));
        assertEquals(expectedOutput, actualOutput);
    }
    
   @Test
public void testFormatRangeWithLetters() {
    String input = "1,3,a,7,8";
    
    NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
    assertThrows(IllegalArgumentException.class, () -> {
        obj.summarizeCollection(obj.collect(input));
    });
}
}