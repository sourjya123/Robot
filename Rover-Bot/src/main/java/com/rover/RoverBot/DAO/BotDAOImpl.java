package com.rover.RoverBot.DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.rover.RoverBot.DTO.Position;

@Repository
public class BotDAOImpl implements BotDAO {

	private static final Logger log = LoggerFactory.getLogger(BotDAOImpl.class);

	@SuppressWarnings("deprecation")
	@Override
	public List<Position> getPosition() {
		// TODO Auto-generated method stub
		ColumnPositionMappingStrategy<Position> strategy = new ColumnPositionMappingStrategy<Position>();

		strategy.setType(Position.class);

		String[] columns = new String[] { "direction", "x", "y" };

		strategy.setColumnMapping(columns);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("Cordinates.csv"));
		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CsvToBean<Position> csvToBean = new CsvToBean<Position>();

		List<Position> position = csvToBean.parse(strategy, csvReader);
		// print details of Bean object

		log.info(position.toString());
		return position;

	}

	@Override
	public void moveAndAddPosition(Position position) {

		final String CSV_LOCATION = "Cordinates.csv ";

		try {

			FileWriter writer = new FileWriter(CSV_LOCATION);

			// Create Mapping Strategy to arrange the
			// column name in order
			ColumnPositionMappingStrategy<Position> mappingStrategy = new ColumnPositionMappingStrategy<Position>();
			mappingStrategy.setType(Position.class);

			// Arrange column name as provided in below array.
			String[] columns = new String[] { "direction", "x", "y" };
			mappingStrategy.setColumnMapping(columns);

			// Creating StatefulBeanToCsv object
			StatefulBeanToCsvBuilder<Position> builder = new StatefulBeanToCsvBuilder<Position>(writer);
			StatefulBeanToCsv<Position> beanWriter = builder.withMappingStrategy(mappingStrategy).build();

			// Write list to StatefulBeanToCsv object
			beanWriter.write(position);
			log.info("Data saved to CSV");

			// closing the writer object
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
