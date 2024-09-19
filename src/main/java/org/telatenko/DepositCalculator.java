package org.telatenko;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
Реализовать калькулятор вкладов -
на вход приложение получает сумму вклада в рублях (может быть дробной, например, 1450.85 рублей),
количество месяцев вклада (целое число) и
годовой процент (может быть дробным, например, 14,5).
На выходе программа должна выдать сумму на вкладе,
которая у клиента будет через указанное количество месяцев.

Причем считаем, что капитализация вклада происходит каждый месяц - то есть,
по истечении каждого месяца клиенту выплачиваются на счет проценты за прошедший месяц.
*/
public class DepositCalculator {
    public static void main(String[] args) {
        BigDecimal depositAmount = new BigDecimal("1450.85");
        int quantityMonths = 10;
        BigDecimal annualPercentage = new BigDecimal("14.5");
        BigDecimal totalAmount = calculat(depositAmount, quantityMonths, annualPercentage);

        System.out.println("Total amount: " + totalAmount);
    }

    private static BigDecimal calculat(BigDecimal depositAmount, int quantityMonths, BigDecimal annualPercentage) {
        BigDecimal months = new BigDecimal("12");
        BigDecimal Amount = depositAmount.multiply(annualPercentage.divide(months, quantityMonths, RoundingMode.HALF_UP).divide(new BigDecimal("100"), quantityMonths, RoundingMode.HALF_UP)).multiply(new BigDecimal(quantityMonths));
        BigDecimal totalAmount = depositAmount.add(Amount);
        return totalAmount;
    }
}
