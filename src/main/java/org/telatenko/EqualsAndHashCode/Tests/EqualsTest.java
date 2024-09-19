package org.telatenko.EqualsAndHashCode.Tests;

import org.junit.Test;
import org.telatenko.EqualsAndHashCode.Gender;
import org.telatenko.EqualsAndHashCode.Human;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsTest {

    @Test
    public void testEquals_SameObject() {
        Human person = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        assertTrue(person.equals(person));
    }

    @Test
    public void testEquals_NullObject() {
        Human person = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        assertFalse(person.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        Human person = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        Object obj = new Object();
        assertFalse(person.equals(obj));
    }

    @Test
    public void testEquals_SameFields() {
        Human person1 = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human person2 = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        assertTrue(person1.equals(person2));
    }

    @Test
    public void testEquals_DifferentName() {
        Human person1 = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human person2 = new Human("Jane Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        assertFalse(person1.equals(person2));
    }

    @Test
    public void testEquals_DifferentDateOfBirth() {
        Human person1 = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human person2 = new Human("John Doe", LocalDate.of(1992, 8, 20), Gender.MALE);
        assertFalse(person1.equals(person2));
    }

    @Test
    public void testEquals_DifferentGender() {
        Human person1 = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human person2 = new Human("John Doe", LocalDate.of(1990, 5, 15), Gender.FEMALE);
        assertFalse(person1.equals(person2));
    }
}

