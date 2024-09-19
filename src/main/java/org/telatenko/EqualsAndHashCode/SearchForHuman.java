package org.telatenko.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
Есть коллекция людей из предыдущей задачи.
Необходимо реализовать метод, который будет производить поиск людей по этой коллекции по любым полям.
В фильтре можно указать имя, возраст и пол.
Например, нужно найти всех людей, у кого имя включает Иван и возраст больше 25 лет.
Метод необходимо покрыть unit-тестами.
*/
public class SearchForHuman {
    public static List<Human> humanList = List.of(
            new Human("Ivan Petrov", LocalDate.of(1990, 5, 15), Gender.MALE),
            new Human("Maria Stepina", LocalDate.of(1985, 8, 20), Gender.FEMALE),
            new Human("Ivan Sidorov", LocalDate.of(1995, 3, 10), Gender.MALE),
            new Human("Anna Petrova", LocalDate.of(2000, 1, 1), Gender.FEMALE)
    );

    public static void main(String[] args) {
        List<Human> result = searchHumans(
                new HumanSearchBuilder()
                        .withNameContaining("Ivan")
                        .withAgeGreaterThan(25)
                        .withGender(Gender.MALE)
                        .withSortBy(SortField.AGE)
                        .build()
        );
        System.out.println(result);
    }

    public static List<Human> searchHumans(SearchCriteria criteria) {
        return humanList.stream()
                .filter(criteria.getFilter())
                .sorted(criteria.getComparator())
                .collect(Collectors.toList());
    }

    public static class HumanSearchBuilder {
        private String nameFilter;
        private Integer ageFilter;
        private Gender genderFilter;
        private SortField sortField;

        public HumanSearchBuilder withNameContaining(String name) {
            this.nameFilter = name;
            return this;
        }

        public HumanSearchBuilder withAgeGreaterThan(int age) {
            this.ageFilter = age;
            return this;
        }

        public HumanSearchBuilder withGender(Gender gender) {
            this.genderFilter = gender;
            return this;
        }

        public HumanSearchBuilder withSortBy(SortField sortField) {
            this.sortField = sortField;
            return this;
        }

        public SearchCriteria build() {
            Predicate<Human> filter = human -> (nameFilter == null || human.getName().contains(nameFilter)) &&
                    (ageFilter == null || human.getAge() > ageFilter) &&
                    (genderFilter == null || human.getGender() == genderFilter);

            Comparator<Human> comparator = null;
            if (sortField != null) {
                switch (sortField) {
                    case NAME:
                        comparator = Comparator.comparing(Human::getName);
                        break;
                    case AGE:
                        comparator = Comparator.comparing(Human::getAge);
                        break;
                }
            }

            return new SearchCriteria(filter, comparator);
        }
    }

    public static class SearchCriteria {
        private final Predicate<Human> filter;
        private final Comparator<Human> comparator;

        public SearchCriteria(Predicate<Human> filter, Comparator<Human> comparator) {
            this.filter = filter;
            this.comparator = comparator;
        }

        public Predicate<Human> getFilter() {
            return filter;
        }

        public Comparator<Human> getComparator() {
            return comparator;
        }
    }

    public enum SortField {
        NAME, AGE
    }
}

