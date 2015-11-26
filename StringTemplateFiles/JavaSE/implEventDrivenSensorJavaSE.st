package $SensorDriver.deviceImplPackageName$;


import framework.*;
import com.google.gson.JsonObject;
import iotsuite.java.extended.sensor.factory.*;
import iotsuite.localmiddleware.IDataListener;
import iotsuite.localmiddleware.PubSubsSensingFramework;
import iotsuite.semanticmodel.Device;


public class JavaSE$SensorDriver.name$ implements I$SensorDriver.name$,IDataListener {

       
  $SensorDriver.allEventDivenFields:{eventDrivenField | 
  $eventDrivenField.type;format="capital"$ $eventDrivenField.name$;
  }$

  private PubSubsSensingFramework pubSubSensingFramework = null;
   $SensorDriver.allGeneratedInfo:{ generatedInfo | 
     private Listener$generatedInfo.name$ handler$generatedInfo.name$;
  }; separator="\n"$
  
   public JavaSE$SensorDriver.name$(Device deviceInfo) { 
	  
	 pubSubSensingFramework = PubSubsSensingFramework.getInstance();
	 $SensorDriver.allGeneratedInfo:{ generatedInfo | 
     pubSubSensingFramework.registerForSensorData(this, "$generatedInfo.name;format="avoidCapital"$");
     }; separator="\n"$
     SensorFactory.initializeSensingFramework("$SensorDriver.name$");
     
      JsonObject publishData = new JsonObject();
      
     $SensorDriver.allEventDivenFields:{eventDrivenField | 
       publishData.addProperty("$eventDrivenField.name$", $eventDrivenField.name$);
   
  }$
    
     
    
    pubSubSensingFramework.publish("$SensorDriver.name$", publishData);
  
     
    
  } 
  
 
  $SensorDriver.allGeneratedInfo:{ generatedInfo | 
   @Override
   public void get$generatedInfo.name; format="avoidCapital"$(Listener$generatedInfo.name$ handler){
    handler$generatedInfo.name$=handler;     
   }   
        
  /* @Override
   public  $generatedInfo.type$ get$generatedInfo.name; format="avoidCapital"$(){
       return null;
   }*/
}; separator="\n"$

  
  
  
  
  @Override
public void onDataReceived(String eventName, JsonObject data) {
    
    
     $SensorDriver.allGeneratedInfo:{ generatedInfo | 
     if(eventName.equals("$generatedInfo.name; format="avoidCapital"$"))
     {
    
     $SensorDriver.allEventDivenFields:{eventDrivenField | 
  $eventDrivenField.name$=data.get("$eventDrivenField.name$").getAs$eventDrivenField.type$();
  }$
   handler$generatedInfo.name$.onNew$generatedInfo.name$(new  $generatedInfo.type$ ($SensorDriver.allEventDivenFields:{eventDrivenField |  $eventDrivenField.name$};separator="," $) );
    }    
      }; separator="\n"$
       
  
}
  
  @Override
  public boolean isEventDriven() {
    return true;
  }

}