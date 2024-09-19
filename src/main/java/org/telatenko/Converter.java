package org.telatenko;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

//Преобразование коллекций

//Реализовать универсальный метод преобразования коллекции объектов
//одного типа в коллекцию другого типа (например коллекцию String преобразовать в коллекцию Integer).
//Метод должен принимать коллекцию и функцию преобразования одного типа в другой.
public class Converter {

    public <T, R> List<R> convertStringToInteger(Collection<T> collection, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : collection) {
            result.add(function.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Converter converter = new Converter();
        var result = converter.convertStringToInteger(list, Integer::parseInt);
        System.out.println(result);
    }
}
