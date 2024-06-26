package seedu.address.model.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.Calendar;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyCalendar;
import seedu.address.model.event.Event;
import seedu.address.model.event.Heading;
import seedu.address.model.event.Time;
import seedu.address.model.person.Address;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.NextOfKin;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                Optional.of(new Address("Blk 30 Geylang Street 29, #06-40")),
                    Optional.of(new Description("Suffers from blood disorder")),
                Optional.of(new NextOfKin("Bob Yeoah")),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    Optional.of(new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18")),
                    Optional.of(new Description("Suffers from diabetes")),
                    Optional.of(new NextOfKin("Choon Yu")),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    Optional.of(new Address("Blk 11 Ang Mo Kio Street 74, #11-04")),
                    Optional.of(new Description("Has asthama")),
                    Optional.of(new NextOfKin("David Oliveiro")),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    Optional.of(new Address("Blk 436 Serangoon Gardens Street 26, #16-43")),
                    Optional.of(new Description("Has Huntington's Disease")),
                    Optional.of(new NextOfKin("Elliot Li")),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    Optional.of(new Address("Blk 47 Tampines Street 20, #17-35")),
                    Optional.of(new Description("Suffers from Crohn's disease")),
                    Optional.of(new NextOfKin("Ilyasa Ibrahim")),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    Optional.of(new Address("Blk 45 Aljunied Street 85, #11-31")),
                    Optional.of(new Description("Suffers from erectile dysfunction")),
                    Optional.of(new NextOfKin("Pam Balakrishnan")),
                getTagSet("colleagues"))
        };
    }

    public static Event[] getSampleEvents() {
        return new Event[] {
            new Event(new Heading("Client Checkin"),
                    new Time(LocalDateTime.of(2024, Month.APRIL, 12, 10, 30)),
                    new Description("Discuss future plans and medical support"),
                    new Name("David Li")),
            new Event(new Heading("House Visit"),
                    new Time(LocalDateTime.of(2024, Month.APRIL, 15, 14, 30)),
                    new Description("Check if safety stipulations are met"),
                    new Name("Irfan Ibrahim")),
            new Event(new Heading("Financial Assistance Meeting"),
                    new Time(LocalDateTime.of(2024, Month.APRIL, 20, 15, 30)),
                    new Description("Walk through government programmes"),
                    new Name("Charlotte Oliveiro")),
            new Event(new Heading("Monthly Appointment"),
                    new Time(LocalDateTime.of(2024, Month.MAY, 1, 10, 0)),
                    new Description("Discuss family therapy"),
                    new Name("Alex Yeoh")),
            new Event(new Heading("Discharge Planning Meeting"),
                    new Time(LocalDateTime.of(2024, Month.MAY, 2, 17, 30)),
                    new Description("Discuss future outpatient care services and financial planning"),
                    new Name("Bernice Yu"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static ReadOnlyCalendar getSampleCalendar() {
        Calendar sampleCalendar = new Calendar();
        for (Event event : getSampleEvents()) {
            sampleCalendar.addEvent(event);
        }
        return sampleCalendar;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
