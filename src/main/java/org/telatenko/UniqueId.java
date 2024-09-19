package org.telatenko;


//Класс с уникальным идентификатором
//Необходимо написать код класса,
//каждый экземпляр которого будет возвращать свой уникальный целочисленный идентификатор.
//Один и тот же экземпляр этого класса всегда должен возвращать один и тот же идентификатор,
//и у каждого экземпляра класса этот идентификатор должен быть уникален,
//не должно быть экземпляров с одинаковыми идентификаторами.
public class UniqueId {

    private static int nextId = 1;

    private final int id;

    public UniqueId() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        UniqueId uniqueId1 = new UniqueId();
        UniqueId uniqueId2 = new UniqueId();
        UniqueId uniqueId3 = new UniqueId();

        System.out.println(uniqueId1.getId());
        System.out.println(uniqueId2.getId());
        System.out.println(uniqueId3.getId());

    }
}
