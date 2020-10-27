package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBowling;

public class BowlingDataSorter {
	
	public static Comparator<IPLBowling> TOP_BOWLING_AVG = Comparator.comparing(IPLBowling::getAverage);

	public static Comparator<IPLBowling> TOP_BOWLING_STRIKE_RATE = Comparator.comparing(IPLBowling::getStrikeRate);
	
	public static Comparator<IPLBowling> TOP_ECONOMY_RATE = Comparator.comparing(IPLBowling::getEconomy);
}
