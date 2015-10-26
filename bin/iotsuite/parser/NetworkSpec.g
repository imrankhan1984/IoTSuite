grammar NetworkSpec;

options {
  language = Java;
}

@lexer::header {
  package iotsuite.parser; 
}

@parser::header {
package iotsuite.parser;
import iotsuite.compiler.*; 
import iotsuite.semanticmodel.*;  
} 

@members {
  //Initialize the context
  private SymbolTable context; 
}
  

networkspec: 
      'devices' ':'
      { context = new SymbolTable();
      }
       (device_def)*     
    ;
    
device_def:
   deviceName = (ID|CAPITALIZED_ID) ':' 
   { 
   context.currentNetwork = new DeviceCompiler();
   context.currentNetwork.setDeviceName($deviceName.text);
   }  
    'region' ':' (location_def)* 
    'platform' ':' (device_type)* ';' 
    'resources' ':' (abilities_def)?  ';'
    'protocol' ':' (protocol_value)* ';' 
    { context.currentNetwork.addDeviceObj();}
;

location_def :
    CAPITALIZED_ID ':' ID ';'
    {context.currentNetwork.addRegionLabel($CAPITALIZED_ID.text);
    context.currentNetwork.addRegionValue($ID.text);}    
;

// Device Type
device_type :
     CAPITALIZED_ID 
    {context.currentNetwork.setDeviceType($CAPITALIZED_ID.text);}
;

abilities_def :
   CAPITALIZED_ID (',' abilities_def)?
  {context.currentNetwork.addDeviceAbilities($CAPITALIZED_ID.text);
  }
;

protocol_value:
  ID
  {context.currentNetwork.setProtocol($ID.text);}
;
 
MOBILEFLAG :  'true' | 'false'
   ; 

ID  : ('a'..'z'  ('a'..'z' | 'A'..'Z' )* ('0'..'9')*)| '0'..'9'('0'..'9')*|'*' ; 
 

CAPITALIZED_ID: 'A'..'Z' ('a'..'z' | 'A'..'Z' )* ('0'..'9')*;

WS: ('\t' | ' ' | '\r' | '\n' | '\u000C')+ {$channel = HIDDEN;};