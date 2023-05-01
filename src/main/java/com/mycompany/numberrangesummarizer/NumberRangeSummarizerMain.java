/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.toCollection;

/**
 *
 * @author Riasha
 */



public class NumberRangeSummarizerMain implements NumberRangeSummarizer{
//implementing the collect method of the NumberRangeSummarizer interface
   @Override
   public Collection<Integer> collect(String input){
       List<Integer> result = new ArrayList<>();
// If the input is null or empty, return an empty list
       if (input == null || input.isEmpty()) { 
            return new ArrayList<Integer>();
        }
            // Remove all whitespace characters from the input string
        input = input.replace(" ", "");
         
        
         // Split the input string by commas and convert each resulting string to an integer,
        // then store the resulting integers in an array
        int[] numbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        
       numbers = this.removeDuplicates(numbers);
       
       for(int number : numbers){
           result.add(number);
       }
        
       return result;
   }
   
   @Override
   public String summarizeCollection(Collection<Integer> input){
       
       if(input.isEmpty()){
           return "";
       }
       
       ArrayList<Integer> newList = input.stream().collect(toCollection(ArrayList::new));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.size()) {
            int start = i;
            
            while (i < newList.size() - 1 && newList.get(i + 1) == newList.get(i) + 1) {
                i++;
            }
            // If the current number is not sequential with the previous number, append it to the result
            if (start == i) { // No Sequential numbers
                sb.append(newList.get(i));
            } else { // If the current number is sequential with the previous number, append a range to the result
                sb.append(newList.get(start)).append("-").append(newList.get(i));
            }
            sb.append(", ");
            i++;
            
        }
        return sb.toString().trim().substring(0, sb.length() - 2);
       
    }
   
   public int[] removeDuplicates(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        Arrays.sort(numbers); // sort the array in ascending order
        int[] result = new int[numbers.length];
        int index = 0;
        result[index++] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) { // check if the current number is different from the previous one
                result[index++] = numbers[i];
            } 
        }
        return Arrays.copyOf(result, index); // trim the result array to the actual size
    }
    public static void main(String[] args) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        
        NumberRangeSummarizerMain obj = new NumberRangeSummarizerMain();
        
        Collection<Integer> output = obj.collect(input);
        System.out.println(obj.summarizeCollection(output));
        

    }
    
}
