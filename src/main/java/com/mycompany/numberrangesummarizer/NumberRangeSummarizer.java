package com.mycompany.numberrangesummarizer;

import java.util.Collection;


/**
 *
 * @author user
 */
interface NumberRangeSummarizer {

    //collect the input
    Collection<Integer> collect(String input);

    //get the summarized string
    String summarizeCollection(Collection<Integer> input);
        
}
