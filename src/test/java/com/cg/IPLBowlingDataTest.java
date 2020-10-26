package com.cg;

import java.util.List;

import org.junit.Test;

import com.cg.dto.CsvFileLoader;
import com.cg.dto.IPLBowling;
import com.cg.dto.IPLException;

import junit.framework.Assert;

public class IPLBowlingDataTest {

	public static final String BOWLING_DATA_FILE_PATH = "D:/javaworkspace/IPLAnalysis/DataFiles/BowlingData.csv";
	
	@Test
	public void givenBowlingData_shouldRetuenList() throws IPLException {
		CsvFileLoader csvFileLoader = new CsvFileLoader();
		List<IPLBowling> bowlingList = csvFileLoader.loadCsvFile(BOWLING_DATA_FILE_PATH, IPLBowling.class);
		Assert.assertEquals(99, bowlingList.size());
	}
}
