package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactDataGanarator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGanarator ganarator = new ContactDataGanarator();
        JCommander jCommander = new JCommander(ganarator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        ganarator.run();

    }

    private void run() throws IOException {
        List<ContactDate> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsCsv(List<ContactDate> contacts, File file) throws IOException {
            System.out.println(new File(".").getAbsolutePath());
            try (Writer writer = new FileWriter(file)){
                for (ContactDate contact : contacts) {
                    writer.write(String.format("%s;%s;%s;%s\n",
                            contact.getFirstname(),
                            contact.getLastname(),
                            contact.getAddress(),
                            contact.getNickname(),
                            contact.getEmail(),
                            contact.getEmail2(),
                            contact.getEmail3(),
                            contact.getCompany(),
                            contact.getHomePhone(),
                            contact.getWorkPhone(),
                            contact.getMobilePhone()));
            }
            }

    }

    private void saveAsXml(List<ContactDate> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactDate.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(xml);
        }

    }

    private List<ContactDate> generateContacts(int count) {
        List<ContactDate> contacts = new ArrayList<ContactDate>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactDate()
                    .withFirstname(String.format("Ivanov %s", i))
                    .withLastname(String.format("Ivan %s", i))
                    .withAddress(String.format("RF Samara %s", i))
                    .withNickname(String.format("Iv %s", i))
                    .withEmail(String.format("test@test.ru", i))
                    .withEmail2(String.format("test@test2.ru", i))
                    .withEmail3(String.format("test@test3.ru", i))
                    .withCompany(String.format("LK %s", i))
                    .withHomePhone(String.format("8917811223%s", i))
                    .withWorkPhone(String.format("8917811224%s", i))
                    .withMobilePhone(String.format("8917811225%s", i)));

        }
        return contacts;
    }
}
