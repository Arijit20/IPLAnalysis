package com.cg.dto;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileLoader {

	public <E> List<E> loadCsvFile(String csvFilePath, Class<E> csvClass) throws IPLException {
		if (!csvFilePath.contains(".csv"))
			throw new IPLException("Not .csv file", IPLException.ExceptionType.WRONG_TYPE);
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			com.cg.csvbuilder.ICsvBuilder csvBuilder = com.cg.csvbuilder.CsvBuilderFactory.createCsvBuilder();
			List<E> iplDataList = csvBuilder.getCsvFileIList(reader, csvClass);
			return iplDataList;
		} catch (IOException e) {
			throw new IPLException("File not found", IPLException.ExceptionType.WRONG_CSV);
		} catch (NullPointerException e) {
			throw new IPLException("File is empty", IPLException.ExceptionType.NO_DATA);
		} catch (RuntimeException e) {
			throw new IPLException("File internal data not proper", IPLException.ExceptionType.INTERNAL_ISSUE);
		} catch (com.cg.csvbuilder.CsvException e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}
