package dev.fox.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class SaveOutput {

	private String outputFile;
	private String originalFile;
	
	public SaveOutput(String originalFile, String outputFile) {
		this.setOriginalFile(originalFile);
		this.setOutputFile(outputFile);
	}
	
	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public void save(List<String[]> records) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(originalFile), ';', '"');
		List<String[]> currentLines = reader.readAll();
		CSVWriter writer = new CSVWriter(new FileWriter(outputFile), ';', '"');
		writer.writeAll(currentLines);
		writer.writeAll(records);
		writer.flush();
		writer.close();
		reader.close();
	}
	
}
