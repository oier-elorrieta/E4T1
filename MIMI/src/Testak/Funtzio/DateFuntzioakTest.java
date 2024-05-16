package Testak.Funtzio;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import funtzioak.DateFuntzioak;

public class DateFuntzioakTest {

    @Test
    public void testLocalDateFormatua() {
        LocalDate testDate = LocalDate.of(2024, 5, 16);
        DateTimeFormatter formatter = DateFuntzioak.LocalDateFormatua();

        String formattedDate = testDate.format(formatter);
        assertEquals("2024-05-16", formattedDate);
    }
}
