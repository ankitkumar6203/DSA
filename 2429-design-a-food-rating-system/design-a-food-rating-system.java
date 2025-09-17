import java.util.*;

public class FoodRatings {
    private Map<String, Integer> foodToRating;
    private Map<String, String> foodToCuisine;
    private Map<String, TreeSet<Food>> cuisineMap;

    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            foodToRating.put(f, r);
            foodToCuisine.put(f, c);

            cuisineMap.putIfAbsent(c, new TreeSet<>(new Comparator<Food>() {
                @Override
                public int compare(Food a, Food b) {
                    if (a.rating != b.rating) {
                        return Integer.compare(b.rating, a.rating); 
                    }
                    return a.name.compareTo(b.name);
                }
            }));

            cuisineMap.get(c).add(new Food(f, r));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeSet<Food> set = cuisineMap.get(cuisine);
        set.remove(new Food(food, oldRating));   
        
        foodToRating.put(food, newRating);
        set.add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> set = cuisineMap.get(cuisine);
        return set.first().name;
    }
}


