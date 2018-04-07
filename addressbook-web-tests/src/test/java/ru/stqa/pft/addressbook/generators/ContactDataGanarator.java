package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGanarator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGanarator ganarator = new ContactDataGanarator();
        JCommander jCommander = new JCommander(ganarator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        ganarator.run();

    }

    private void run() throws IOException {
        List<ContactDate> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactDate> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactDate contact : contacts) {
            writer.write(String.format("%s;%s\n", contact.getFirstname(), contact.getLastname()));
        }
        writer.close();

    }

    private List<ContactDate> generateContacts(int count) {
        List<ContactDate> contacts = new ArrayList<ContactDate>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactDate().withFirstname(String.format("Ivanov %s", i))
                    .withLastname(String.format("Ivan %s", i)));
        }
        return contacts;
    }
}
