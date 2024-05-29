package task5;

import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        Safe safe = new Safe(80);
        Item[] allTtems = {
                new Item(11, 38),
                new Item(24, 44),
                new Item(50, 26),
                new Item(19, 17),
                new Item(26, 23),
                new Item(31, 18)
        };

        safe.fillWithMaxValue(allTtems);

        for (Item item : safe.items) {
            System.out.println("Объем: " + item.volume + ", Ценность: " + item.value);
        }

    }
}

class Item {
    int volume;
    int value;

    Item(int volume, int value) {
        this.volume = volume;
        this.value = value;
    }
}

class Safe {
    int volume;
    ArrayList<Item> items;

    Safe(int volume) {
        this.volume = volume;
        this.items = new ArrayList<>();
    }

    public void fillWithMaxValue(Item[] allItems) {
        //Храним максимальную ценность, которую можно получить, используя первые i предметов
        int[][] dp = new int[allItems.length + 1][volume + 1];
        //Цикл по предметам
        for (int i = 1; i <= allItems.length; i++) {
            //Цикл по объемам сейфа
            for (int j = 0; j <= volume; j++) {
                //Если объем предмета больше текущего объема сейфа, мы не можем добавить его
                if (allItems[i - 1].volume > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    //Добавляем или не добавляем
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - allItems[i - 1].volume] + allItems[i - 1].value);
            }
        }
        //После алгоритма макс. ценность находится в dp[allItems.length][volume]

        //Добавляем предметы в сейф
        int res = dp[allItems.length][volume];
        int v = volume;
        for (int i = allItems.length; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][v]) {
                this.items.add(allItems[i - 1]);
                res -= allItems[i-1].value;
                v -= allItems[i-1].volume;
            }
        }

        System.out.println("Максимальная ценность набора: " + dp[allItems.length][volume]);
    }
}

