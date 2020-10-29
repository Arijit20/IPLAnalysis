package com.cg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.dto.IPLAllRounder;
import com.cg.dto.IPLBatting;
import com.cg.dto.IPLBowling;
import com.cg.dto.IPLException;
import com.cg.service.AllRounderDataSorter;
import com.cg.service.IPLAnalyser;

import junit.framework.Assert;

public class IPLAllRounderDataTest {
	
	public static final String BATTING_DATA_FILE_PATH = "D:/javaworkspace/IPLAnalysis/DataFiles/BattingData.csv";
	public static final String BOWLING_DATA_FILE_PATH = "D:/javaworkspace/IPLAnalysis/DataFiles/BowlingData.csv";
	private IPLAnalyser iplAnalyser;
	List<IPLBatting> battingList = new ArrayList<IPLBatting>();
	List<IPLBowling> bowlingList = new ArrayList<IPLBowling>();
	List<IPLAllRounder> sortedList;
	
	@Before
	public void initialize() throws IPLException {
		iplAnalyser = new IPLAnalyser();
		battingList = iplAnalyser.loadCsvFile(BATTING_DATA_FILE_PATH, IPLBatting.class);
		bowlingList = iplAnalyser.loadCsvFile(BOWLING_DATA_FILE_PATH, IPLBowling.class);
		sortedList = new ArrayList<IPLAllRounder>();
	}
	
	@Test
	public void givenBattingAndBowlingData_ShouldReturnBestAvg() {
		sortedList = iplAnalyser.sortAllRounderData(battingList, bowlingList, AllRounderDataSorter.BEST_BATTING_AND_BOWLING_AVG);
		Collections.reverse(sortedList);
		Assert.assertEquals("Marcus Stoinis", sortedList.get(0).getPlayer());
	}
	
	@Test
	public void givenBattingAndBowlingData_ShouldReturnBestAllRounder() {
		sortedList = iplAnalyser.sortAllRounderData(battingList, bowlingList, AllRounderDataSorter.BEST_ALL_ROUNDER);
	    Collections.reverse(sortedList);
		Assert.assertEquals("Hardik Pandya", sortedList.get(0).getPlayer());
	}
}
