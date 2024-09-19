package org.telatenko.EqualsAndHashCode.Tests;


import org.junit.Test;
import org.telatenko.EqualsAndHashCode.Gender;
import org.telatenko.EqualsAndHashCode.Human;
import org.telatenko.EqualsAndHashCode.SearchForHuman;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SearchForHumanTest {

    @Test
    public void testSearchHumansSortedByName() {
        List<Human> result = SearchForHuman.searchHumans(
                new SearchForHuman.HumanSearchBuilder()
                        .withSortBy(SearchForHuman.SortField.NAME)
                        .build()
        );

        assertEquals(4, result.size());
        assertEquals("Anna Petrova", result.get(0).getName());
        assertEquals("Ivan Petrov", result.get(1).getName());
        assertEquals("Ivan Sidorov", result.get(2).getName());
        assertEquals("Maria Stepina", result.get(3).getName());
    }

    @Test
    public void testSearchHumansSortedByAge() {
        List<Human> result = SearchForHuman.searchHumans(
                new SearchForHuman.HumanSearchBuilder()
                        .withSortBy(SearchForHuman.SortField.AGE)
                        .build()
        );

        assertEquals(4, result.size());
        assertEquals("Anna Petrova", result.get(0).getName());
        assertEquals("Ivan Sidorov", result.get(1).getName());
        assertEquals("Ivan Petrov", result.get(2).getName());
        assertEquals("Maria Stepina", result.get(3).getName());
    }

    @Test
    public void testGetAge() {
        Human human = new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE);
        assertEquals(34, human.getAge());
    }

    @Test
    public void testEquals() {
        Human human1 = new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human human2 = new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE);

        assertEquals(human1, human2);
    }

    @Test
    public void testEqualsNotEqual() {
        Human human1 = new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human human2 = new Human("Maria Stepina", LocalDate.of(1985, 8, 20), Gender.FEMALE);

        assertNotEquals(human1, human2);
    }

    @Test
    public void testHashCode() {
        Human human1 = new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE);
        Human human2 = new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE);

        assertEquals(human1.hashCode(), human2.hashCode());
    }
}
