package com.ex.democsv.controller;

import com.ex.democsv.model.CsvData;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class CsvController {

    @PostMapping("/import/csv")
    public ResponseEntity<?> importCsv() {

        try {
            Path path = Paths.get("D:\\DTAX_V3\\testcsv\\testfile.csv");

            Reader reader = Files.newBufferedReader(path);

            CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder<CsvData>(reader)
                    .withType(CsvData.class)
                    .withSeparator('|')
                    .build();

            List<CsvData> csvDataList = csvToBean.parse();

            if (csvDataList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("csv is empty");
            }
            return ResponseEntity.ok(csvDataList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error : " + e.getMessage());
        }
    }
}
