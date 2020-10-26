package com.cg.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.dto.CsvFileLoader;
import com.cg.dto.IPLBatting;
import com.cg.dto.IPLException;

public class IPLAnalyser {
	
	BattingDataSorter battingDataSorter = new BattingDataSorter();
    
	public <E> List<E> loadCsvFile(String csvFilePath, Class<E> csvClass) throws IPLException {
		return new CsvFileLoader().loadCsvFile(csvFilePath, csvClass);
	}
	
	public List<IPLBatting> sortBattingData(List<IPLBatting> battingList, Comparator<IPLBatting> comparator){
		return (List<IPLBatting>) battingList.stream().sorted(comparator).collect(Collectors.toList());
	}
}
