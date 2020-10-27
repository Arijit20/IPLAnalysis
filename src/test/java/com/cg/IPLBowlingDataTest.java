package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.dto.CsvFileLoader;
import com.cg.dto.IPLBatting;
import com.cg.dto.IPLBowling;
import com.cg.dto.IPLException;
import com.cg.service.BattingDataSorter;
import com.cg.service.BowlingDataSorter;
import com.cg.service.IPLAnalyser;

import junit.framework.Assert;

public class IPLBowlingDataTest {

	public static final String BOWLING_DATA_FILE_PATH = "D:/javaworkspace/IPLAnalysis/DataFiles/BowlingData.csv";
	private IPLAnalyser iplAnalyser;
	List<IPLBowling> bowlingList = new ArrayList<IPLBowling>();
	List<IPLBowling> sortedList;
	
	@Before
	public void initialize() throws IPLException {
		iplAnalyser = new IPLAnalyser();
		bowlingList = iplAnalyser.loadCsvFile(BOWLING_DATA_FILE_PATH, IPLBowling.class);
		sortedList = new ArrayList<IPLBowling>();
	}
	
	@Test
	public void givenBowlingData_shouldRetuenList() throws IPLException {
		Assert.assertEquals(99, bowlingList.size());
	}
	
	@Test
	public void givenBowlingData_shouldReturnTopBowlingAvg() {
		sortedList = iplAnalyser.sortBowlingData(bowlingList, BowlingDataSorter.TOP_BOWLING_AVG);
		Assert.assertEquals("Krishnappa Gowtham", sortedList.get(98).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnTopStrikeRate() {
		sortedList = iplAnalyser.sortBowlingData(bowlingList, BowlingDataSorter.TOP_BOWLING_STRIKE_RATE);
		Assert.assertEquals("Krishnappa Gowtham", sortedList.get(98).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnTopEconomyRate() {
		sortedList = iplAnalyser.sortBowlingData(bowlingList, BowlingDataSorter.TOP_ECONOMY_RATE);
		Assert.assertEquals("Ben Cutting", sortedList.get(98).getPlayer());
	}
	
	@Test
	public void givenBowlingData_shouldReturnTopStrikeRateWith5And4Wickets() {
		sortedList = iplAnalyser.sortBowlingData(bowlingList, BowlingDataSorter.TOP_SR_WITH_5W_AND_4W);
		Assert.assertEquals("Krishnappa Gowtham", sortedList.get(98).getPlayer());
	}
}
