package com.learn.spring.schedulling.utils;

import com.learn.spring.schedulling.model.Information;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BufferReader {


    public List<Information> parseFileToList(InputStream inputStream) throws Exception {
        List<Information> informationList = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                // skip header line
                br.readLine();
                String line;
                while ((line = br.readLine()) != null) {
                    informationList.add(delimeter(line));
                }
                return informationList;
            }
        } catch (final IOException e) {
            log.error("Failed to parse CSV file {}"+ e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }

    public static Information delimeter(String line) {
        final String[] data = line.split(",");
        final Information Information = new Information();
        Information.setName(data[0]);
        Information.setEmail(data[1]);
        Information.setPhone(data[2]);
        Information.setAddress(data[3]);
       return Information;
    }

}
