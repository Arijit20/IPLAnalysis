package com.cg.service;

import java.util.Comparator;

import com.cg.dto.IPLAllRounder;

public class AllRounderDataSorter {

	public static Comparator<IPLAllRounder> BEST_BATTING_AND_BOWLING_AVG = Comparator.comparing(player -> player.getAverageRuns() * player.getAverageWickets());

    public static Comparator<IPLAllRounder> BEST_ALL_ROUNDER = Comparator.comparing(player -> player.getWickets() * player.getRuns());
}
