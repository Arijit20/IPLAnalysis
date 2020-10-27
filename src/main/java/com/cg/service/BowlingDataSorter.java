package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBowling;

public class BowlingDataSorter {
	
	public static Comparator<IPLBowling> TOP_BOWLING_AVG = Comparator.comparing(IPLBowling::getAverage);

	public static Comparator<IPLBowling> TOP_BOWLING_STRIKE_RATE = Comparator.comparing(IPLBowling::getStrikeRate);
	
	public static Comparator<IPLBowling> TOP_ECONOMY_RATE = Comparator.comparing(IPLBowling::getEconomy);
	
	public static Comparator<IPLBowling> TOP_SR_WITH_5W_AND_4W = TOP_BOWLING_STRIKE_RATE.thenComparing(bowler -> bowler.getFiveWickets()+bowler.getFourWickets());

    public static Comparator<IPLBowling> TOP_AVG_WITH_BEST_SR = TOP_BOWLING_AVG.thenComparing(IPLBowling::getStrikeRate);
    
    public static Comparator<IPLBowling> MAX_WICKET_WITH_BEST_BOWLING_AVG = Comparator.comparing(IPLBowling::getNoOfWickets).thenComparing(TOP_BOWLING_AVG);
}
