package com.example.TournamentProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CSVExportService {
    @Autowired
    private TournamentManagement tournamentManagement;

    public void saveInTXTFile() {
        String tournamentInTXTFile = tournamentManagement.createTournamentName() + ".txt";

        System.out.println("If you want save results enter 'Save Tournament'");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tournamentInTXTFile))) {
                String line;
                while ((line = reader.readLine()).equalsIgnoreCase("Save Tournament")) {
                    writer.write(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
