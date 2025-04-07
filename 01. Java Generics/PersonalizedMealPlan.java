interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() { return "Vegetarian"; }
}

class VeganMeal implements MealPlan {
    public String getMealType() { return "Vegan"; }
}

class KetoMeal implements MealPlan {
    public String getMealType() { return "Keto"; }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() { return "High-Protein"; }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;
    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }
    public String getMealName() { return mealName; }
    public T getMealType() { return mealType; }
    public String toString() { return mealName + " (" + mealType.getMealType() + ")"; }
}

class MealPlanUtils {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generating your personalized meal plan: " + meal);
    }
    public static <T extends MealPlan> boolean validateMealPlan(Meal<T> meal) {
        return meal.getMealType() != null;
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VegetarianMeal> salad = new Meal<>("Salad", new VegetarianMeal());
        Meal<VeganMeal> tofu = new Meal<>("Tofu Stir Fry", new VeganMeal());
        Meal<KetoMeal> steak = new Meal<>("Grilled Steak", new KetoMeal());
        Meal<HighProteinMeal> chicken = new Meal<>("Chicken Breast", new HighProteinMeal());

        MealPlanUtils.generateMealPlan(salad);
        MealPlanUtils.generateMealPlan(tofu);
        MealPlanUtils.generateMealPlan(steak);
        MealPlanUtils.generateMealPlan(chicken);

        System.out.println("\nMeal Plan Validation:");
        System.out.println("Salad: " + MealPlanUtils.validateMealPlan(salad));
        System.out.println("Tofu Stir Fry: " + MealPlanUtils.validateMealPlan(tofu));
        System.out.println("Grilled Steak: " + MealPlanUtils.validateMealPlan(steak));
        System.out.println("Chicken Breast: " + MealPlanUtils.validateMealPlan(chicken));
    }
}