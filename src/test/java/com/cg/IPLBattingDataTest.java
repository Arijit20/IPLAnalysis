package com.cg;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.cg.dto.IPLBatting;
import com.cg.dto.IPLException;
import com.cg.service.BattingDataSorter;
import com.cg.service.IPLAnalyser;

import junit.framework.Assert;

public class IPLBattingDataTest {

public static final String BATTING_DATA_FILE_PATH = "D:/javaworkspace/IPLAnalysis/DataFiles/BattingData.csv";
private IPLAnalyser iplAnalyser;
List<IPLBatting> battingList = new ArrayList<IPLBatting>();
List<IPLBatting> sortedList;

@Before
public void initialize() throws IPLException {
	iplAnalyser = new IPLAnalyser();
	battingList = iplAnalyser.loadCsvFile(BATTING_DATA_FILE_PATH, IPLBatting.class);
	sortedList = new ArrayList<IPLBatting>();
}
	
	@Test
	public void givenBattingData_shouldRetuenList() throws IPLException {
		Assert.assertEquals(101, battingList.size());
	}
	
	@Test
	public void givenBattingData_shouldReturnTopBattingAvg() {
		sortedList = iplAnalyser.sortBattingData(battingList, BattingDataSorter.TOP_BATTING_AVG);
		Assert.assertEquals("MS Dhoni", sortedList.get(100).getPlayer());
	}
	
	@Test
	public void givenBattingData_shouldReturnTopStrikingRate() {
		sortedList = iplAnalyser.sortBattingData(battingList, BattingDataSorter.TOP_STRIKING_RATE);
		Assert.assertEquals("Ishant Sharma", sortedList.get(100).getPlayer());
	}
	
}
