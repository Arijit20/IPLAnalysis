package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBatting;

public class BattingDataSorter {

	public static Comparator<IPLBatting> TOP_BATTING_AVG = Comparator.comparing(IPLBatting::getAverage);
	
	public static Comparator<IPLBatting> TOP_STRIKING_RATE = Comparator.comparing(IPLBatting::getStrikeRate);
}
