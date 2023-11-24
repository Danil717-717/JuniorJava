package sem1.task02.goods;

import sem1.task02.Snack;

/**
 * Шоколадный батончик
 */
public class ChocolateBar implements Snack {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Шоколадный батончик";
    }
}