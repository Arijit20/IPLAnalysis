package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBatting;

public class BattingDataSorter {

	public static Comparator<IPLBatting> TOP_BATTING_AVG = Comparator.comparing(IPLBatting::getAverage);
	
	public static Comparator<IPLBatting> TOP_STRIKING_RATE = Comparator.comparing(IPLBatting::getStrikeRate);
	
	public static Comparator<IPLBatting> MAX_SIXES_AND_FOURS = Comparator.comparing(batsman -> batsman.getNoOfSixes() + batsman.getNoOfFours());

    public static Comparator<IPLBatting> BEST_SR_WITH_MAX_SIXES_AND_FOURS = MAX_SIXES_AND_FOURS.thenComparing(IPLBatting::getStrikeRate);

    public static Comparator<IPLBatting> AVG_WITH_BEST_SR = TOP_BATTING_AVG.thenComparing(IPLBatting::getStrikeRate);

    public static Comparator<IPLBatting> MAX_RUN_WITH_BEST_AVG = Comparator.comparing(IPLBatting::getRuns).thenComparing(TOP_BATTING_AVG );
}
