package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBatting;

public class BattingDataSorter {

	public static Comparator<IPLBatting> TOP_BATTING_AVG = Comparator.comparing(IPLBatting::getAverage);
	
	public static Comparator<IPLBatting> TOP_STRIKING_RATE = Comparator.comparing(IPLBatting::getStrikeRate);
	
	public static Comparator<IPLBatting> MAX_SIXES_AND_FOURS = Comparator.comparing(
			                                                  batsman -> batsman.getNoOfSixes() + batsman.getNoOfFours());

    public static Comparator<IPLBatting> BEST_SR_WITH_MAX_SIXES_AND_FOURS = MAX_SIXES_AND_FOURS
    		                                                                .thenComparing(IPLBatting::getStrikeRate);

    public static Comparator<IPLBatting> AVG_WITH_BEST_SR = TOP_BATTING_AVG.thenComparing(IPLBatting::getStrikeRate);

    public static Comparator<IPLBatting> MAX_RUN_WITH_BEST_AVG = Comparator.comparing(IPLBatting::getRuns)
    		                                                     .thenComparing(TOP_BATTING_AVG );

    public static Comparator<IPLBatting> MAX_HUNDRED_WITH_BEST_AVG = Comparator.comparing(IPLBatting::getCentury)
    		                                                         .thenComparing(TOP_BATTING_AVG);
    
    public static Comparator<IPLBatting> ZER0_HALF_OR_FULL_CENTURY_NUT_BEST_AVG = Comparator.comparing(batsman -> 
    		                                ( batsman.getCentury() == 0 && batsman.getHalfCentury() == 0)?batsman.getAverage(): 0.0);             
    	                                                                       
}
