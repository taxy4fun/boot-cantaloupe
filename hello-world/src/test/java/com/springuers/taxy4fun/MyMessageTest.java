package com.springuers.taxy4fun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MyMessageTest {

    static final String MESSAGE_SUBJECT = "message subject";
    private MyMessage message;
    private LocalDateTime now;
    private LocalDateTime DATE_20170101 = LocalDate.of(2017, 1, 1).atStartOfDay();

    @BeforeEach
    void init() {
        this.now = LocalDateTime.now();
        message = new MyMessage(MESSAGE_SUBJECT, now);
    }

    @Test
    @DisplayName("testing with Applicative behaviour")
    void testGroupedAssertions() {
        assertAll("message",
                () -> assertEquals(1, 1 + 0),
                () -> assertEquals(2, 1 + 1), // change 2 -> 1
                () -> assertEquals(3, 1 + 2),
                () -> assertEquals(5, 2 + 3), // change 5 -> 4
                () -> assertEquals(7, 5 + 2)
        );
    }

    @Test
    @DisplayName("testing with Monadic behaviour")
    void testDependentAssertions() {
        assertAll("properties",
                () -> {
                    String subject = this.message.getSubject();
                    assertNotNull(subject);

                    // Executed only if the previous assertion is valid.
                    assertAll("subject",
                            () -> assertTrue(subject.startsWith("m"), "startsWith"),
                            () -> assertTrue(subject.endsWith("t"), "endsWith")
                    );
                },
                () -> {
                    LocalDateTime dateTime = this.message.getDateTime();
                    assertNotNull(dateTime);

                    // Executed only if the previous assertion is valid.
                    assertAll("dateTime",
                            () -> assertTrue(dateTime.isAfter(DATE_20170101), "year begining"),
                            () -> assertTrue(dateTime.minusMonths(6).isAfter(DATE_20170101), "six months before")
                    );
                }
        );
    }
}
