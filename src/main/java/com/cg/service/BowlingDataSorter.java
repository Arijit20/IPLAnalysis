package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBowling;

public class BowlingDataSorter {
	
	public static Comparator<IPLBowling> TOP_BOWLING_AVG = Comparator.comparing(IPLBowling::getAverage);

}
