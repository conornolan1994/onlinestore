package io.conor.category;

public class CategoryFactory {
	 
	   public static Category getCategory(String categoryType){
	      if(categoryType == null){
	         return null;
	      }		
	      if(categoryType.equalsIgnoreCase("Home")){
	         return new Home(categoryType);
	         
	      } else if(categoryType.equalsIgnoreCase("TV")){
	         return new TV(categoryType);
	      }
	      else if(categoryType.equalsIgnoreCase("Phone"))
	      {
	    	  return new Phone(categoryType);
	      }
	      
	      return null;
	   }

}
