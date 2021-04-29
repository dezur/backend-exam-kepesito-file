package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        try {
            if(contacts == null) {
                throw new IllegalArgumentException();
            }
            File file = new File(output);

            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bf.write(entry.getKey() + ": " + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}