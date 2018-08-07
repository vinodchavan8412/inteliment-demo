package com.inteliment.demo.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.models.Storage;
import com.inteliment.demo.repositories.FileRepository;
import com.inteliment.demo.util.MultiColumnCsvSortExtended;

@Service("ParseService")
public class ParseServiceImpl implements ParseService {

	@Autowired
	public FileRepository fileRepository;

	private static final String COLUMN_SEPARATOR = ",";

	@Override
	public Storage parse(MultipartFile file, String type) {
		StringBuilder sb = new StringBuilder();
		Reader in;
		int count = 0;
		String recordString = "";
		try {
			in = new InputStreamReader(file.getInputStream());
			for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {

				count = 0;
				for (String field : record) {
					if (count < record.size()) {
						recordString = recordString + field + ",";
					}

				}
				recordString = recordString + "\n";
			}
			sb.append(recordString);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return fileRepository.save(new Storage(sb.toString(), type));

	}

	// i am considering string data filter in ascending order descending order
	@Override
	public Storage filter(MultipartFile file, String criteria) {

		List<List<String>> lines = null;
		try {
			lines = MultiColumnCsvSortExtended.readCsv(file.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Create a comparator that compares the elements from column 0,
		// in ascending order
		Comparator<List<String>> c0 = MultiColumnCsvSortExtended.createAscendingComparator(0);

		// Create a comparator that compares the elements from column 2,
		// in descending order
		Comparator<List<String>> c1 = MultiColumnCsvSortExtended.createDesendingComparator(2);

		// Create a comparator that compares primarily by using c0,
		// and secondarily by using c1
		Comparator<List<String>> comparator = MultiColumnCsvSortExtended.createComparator(c0, c1);
		Collections.sort(lines, comparator);

		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("output.csv");

			String header = "";
			try {
				return MultiColumnCsvSortExtended.writeCsv(header, lines, outputStream);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
