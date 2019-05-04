package main_task;

import java.util.EnumSet;
import java.util.Iterator;

public class Pizza {
	String namePizza;
	final int  numberOfOrderPizza;
    static int generationNumberOfOrderPizza=10000;
        
    public int getNumberOfOrderPizza() {
		return numberOfOrderPizza;
	}	
   
    public String getNamePizza() {
		return namePizza;
	}

	EnumSet<BaseForPizza> base=EnumSet.noneOf(BaseForPizza.class);    
    EnumSet<Ingredients> ingredients=EnumSet.noneOf(Ingredients.class);
    
    Pizza(String namePizza, String nameBaseForPizza,String ...nameOfIngredients){
    	numberOfOrderPizza=generationNumberOfOrderPizza++; 
    	base.add(BaseForPizza.addBase(nameBaseForPizza));
    	
    	if (namePizza.length()>4&&namePizza.length()<20) {
			this.namePizza=namePizza; 
		} else {
    	this.namePizza="Client"+numberOfOrderPizza;
		}
    	
    for (String name : nameOfIngredients) {    	
    	if (ingredients.contains(Ingredients.addIngredient(name))) {    		
			System.out.println("Вы пытаетесь добавить ингредиенты который уже есть: "+name);			
		}    	
	    ingredients.add(Ingredients.addIngredient(name));
	    if (ingredients.size()>=Ingredients.values().length) {	    	
    		System.out.println("Пицца уже ПОЛНА! все ингредиенты уже добавили");    			
    	}
	}      
    }
 
    void addIngredientInPizza(String ingredient) {
    	if (ingredients.size()>=Ingredients.values().length) {
			System.out.println("Пицца уже ПОЛНА! все ингредиенты уже добавил");
		}    	
    	
    	for (Ingredients elementIngredient : ingredients) {
			if (elementIngredient.getIngredient().equals(ingredient)) {
			System.out.println("Вы пытаетесь добавить ингредиенты который уже есть: "+ingredient);
			System.out.println("Проверьте заказ, еще раз");
			return;
			}
			}
    	ingredients.add(Ingredients.addIngredient(ingredient));
    	System.out.println("вы добавили ингридиет:"+ingredient+"В пиццу с названием:"+namePizza);    	
    
    	}	
       double sumPricePizza() {
    	   double sumIngredients=0;
    	   double sumBase=0;
    	   Iterator<Ingredients> iterator =ingredients.iterator();
    	   while (iterator.hasNext()) {
    		   Ingredients ingredients =iterator.next();
    		   sumIngredients+=ingredients.getPrice();			
		   }
    	   Iterator<BaseForPizza> iterat =base.iterator();
    	   while (iterat.hasNext()) {
    		   BaseForPizza baseForPizza =iterat.next();
    		   sumBase+=baseForPizza.getPrice();			
		   }
    	   return sumIngredients+sumBase;    	 
       }
       
     @Override
     public boolean equals(Object obj) {
    	 Pizza p;
    	 if (!(obj  instanceof Pizza)) {
    		 return false;			
    	 } else {
    		 p=(Pizza)obj;
    		 if (this.namePizza.equals(p.getNamePizza()))
    			 return true;
    	 }
	 return false;
     }
     
    @Override
	public String toString() {		
		return getNamePizza()+base+"\n"+ingredients;
	}
     

}
