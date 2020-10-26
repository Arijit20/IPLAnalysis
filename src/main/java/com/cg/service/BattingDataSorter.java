package com.cg.service;

import java.util.Comparator;
import com.cg.dto.IPLBatting;

public class BattingDataSorter {

	public final static Comparator<IPLBatting> TOP_BATTING_AVG = Comparator.comparing(IPLBatting::getAverage);
}
