package pl.kostrowski.mtga.MakeTasksGreatAgain;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Branch;
import pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa.BranchRespository;

import java.io.FileReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class MakeTasksGreatAgainApplication  {
    final static Logger logger = LoggerFactory.getLogger(MakeTasksGreatAgainApplication.class);

    @Autowired
    BranchRespository branchRespository;


    public static void main(String[] args) {
        logger.info("Aplikacja wystartowała");
        SpringApplication.run(MakeTasksGreatAgainApplication.class, args);
    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Branch branch = new Branch();
//        List<Branch> branches = new LinkedList<>();
//
////        try (Reader input = new FileReader("csv/filie.csv")){
////            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("Id", "Branch").parse(input);
////
////            for (CSVRecord record : records) {
////                branch.setName(record.get("Branch"));
////                branch.setId(record.get("Id"));
////                branches.add(branch);
////            }
////        }
////        branchRespository.save(branches);
//
//    }
}
