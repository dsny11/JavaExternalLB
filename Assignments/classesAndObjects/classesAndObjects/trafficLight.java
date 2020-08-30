package classesAndObjects;

public enum trafficLight {
	
    RED(50), 
    
    GREEN(20), 
    
    YELLOW(5); 

	private int duration;	  
 
    public int getDuration() 
    { 
        return this.duration; 
    }  
      
    private trafficLight(int duration) 
    { 
        this.duration = duration; 
    }
    
    public static void main(String args[]) 
    { 
    	trafficLight[] trafficLights = trafficLight.values();
    	for (trafficLight trafficLight : trafficLights) 
        {             
    		System.out.println("LightColor : " + trafficLight.name() + "----- Duration : " + trafficLight.getDuration()+" seconds" ); 
        } 
    }    
}
