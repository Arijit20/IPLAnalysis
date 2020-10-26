package com.cg;

import java.util.List;

import org.junit.Test;

import com.cg.dto.CsvFileLoader;
import com.cg.dto.IPLBatting;
import com.cg.dto.IPLException;

import junit.framework.Assert;

public class IPLBattingDataTest {

public static final String BOWLING_DATA_FILE_PATH = "D:/javaworkspace/IPLAnalysis/DataFiles/BattingData.csv";
	
	@Test
	public void givenBowlingData_shouldRetuenList() throws IPLException {
		CsvFileLoader csvFileLoader = new CsvFileLoader();
		List<IPLBatting> battingList = csvFileLoader.loadCsvFile(BOWLING_DATA_FILE_PATH, IPLBatting.class);
		Assert.assertEquals(101, battingList.size());
	}
}
