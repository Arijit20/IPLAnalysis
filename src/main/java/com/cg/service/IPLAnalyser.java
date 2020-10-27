package com.cg.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.dto.CsvFileLoader;
import com.cg.dto.IPLAllRounder;
import com.cg.dto.IPLBatting;
import com.cg.dto.IPLBowling;
import com.cg.dto.IPLException;

public class IPLAnalyser {
    
	public <E> List<E> loadCsvFile(String csvFilePath, Class<E> csvClass) throws IPLException {
		return new CsvFileLoader().loadCsvFile(csvFilePath, csvClass);
	}
	
	public List<IPLBatting> sortBattingData(List<IPLBatting> battingList, Comparator<IPLBatting> comparator){
		return (List<IPLBatting>) battingList.stream().sorted(comparator).collect(Collectors.toList());
	}
	
	public List<IPLBowling> sortBowlingData(List<IPLBowling> bowlingList, Comparator<IPLBowling> comparator){
		return (List<IPLBowling>) bowlingList.stream().sorted(comparator).collect(Collectors.toList());
	}
	
	public List<IPLAllRounder> sortAllRounderData(List<IPLBatting> battingList, List<IPLBowling> bowlingList, Comparator<IPLAllRounder> comparator){
		List<IPLAllRounder> allRounderList = getAllRounderPlayers( battingList, bowlingList);
		Collections.reverse(allRounderList);
		return (List<IPLAllRounder>) allRounderList.stream().sorted(comparator).collect(Collectors.toList());
	}

	private List<IPLAllRounder> getAllRounderPlayers(List<IPLBatting> battingList, List<IPLBowling> bowlingList) {
		List<IPLAllRounder> allRounderList = new ArrayList<>();
		battingList.stream().forEach(batsman -> {
			IPLBowling bowlers = bowlingList.stream()
					.filter(bowler -> bowler.getPlayer().equalsIgnoreCase(batsman.getPlayer())).findFirst()
					.orElse(null);
			if (bowlers != null) {
				allRounderList.add(new IPLAllRounder(batsman.getPlayer(), batsman.getRuns(), bowlers.getNoOfWickets(),
						batsman.getAverage(), bowlers.getAverage()));
			}
		});
		return allRounderList;
	}
}
