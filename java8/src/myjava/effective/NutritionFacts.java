package myjava.effective;


// NutritionFacts2 Pattern
// Immutable
// thread unsafe
public class NutritionFacts {
	private int servingSize = -1;
	private int servings = -1;
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public NutritionFacts() {}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts cocacola = new NutritionFacts();

		cocacola.setServingSize(240);
		cocacola.setFat(240);
		cocacola.setServings(8);
		cocacola.setCalories(100);
		cocacola.setSodium(4);
		cocacola.setCarbohydrate(27);
	}
}
