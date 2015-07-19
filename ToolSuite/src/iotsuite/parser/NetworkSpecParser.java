// $ANTLR 3.5.1 S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g 2015-07-19 22:20:22

package iotsuite.parser;
import iotsuite.compiler.*; 
import iotsuite.semanticmodel.*;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class NetworkSpecParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CAPITALIZED_ID", "ID", "MOBILEFLAG", 
		"WS", "','", "':'", "';'", "'devices'", "'mobile'", "'region'", "'resources'", 
		"'type'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int CAPITALIZED_ID=4;
	public static final int ID=5;
	public static final int MOBILEFLAG=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public NetworkSpecParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public NetworkSpecParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return NetworkSpecParser.tokenNames; }
	@Override public String getGrammarFileName() { return "S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g"; }


	  //Initialize the context
	  private SymbolTable context; 



	// $ANTLR start "networkspec"
	// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:23:1: networkspec : 'devices' ':' ( device_def )* ;
	public final void networkspec() throws RecognitionException {
		try {
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:23:12: ( 'devices' ':' ( device_def )* )
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:24:7: 'devices' ':' ( device_def )*
			{
			match(input,11,FOLLOW_11_in_networkspec58); 
			match(input,9,FOLLOW_9_in_networkspec60); 
			 context = new SymbolTable();
			      
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:27:8: ( device_def )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= CAPITALIZED_ID && LA1_0 <= ID)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:27:9: device_def
					{
					pushFollow(FOLLOW_device_def_in_networkspec78);
					device_def();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "networkspec"



	// $ANTLR start "device_def"
	// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:30:1: device_def : deviceName= ( ID | CAPITALIZED_ID ) ':' 'region' ':' ( location_def )* 'type' ':' ( device_type )* ';' 'resources' ':' ( abilities_def )? ';' ;
	public final void device_def() throws RecognitionException {
		Token deviceName=null;

		try {
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:30:11: (deviceName= ( ID | CAPITALIZED_ID ) ':' 'region' ':' ( location_def )* 'type' ':' ( device_type )* ';' 'resources' ':' ( abilities_def )? ';' )
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:31:4: deviceName= ( ID | CAPITALIZED_ID ) ':' 'region' ':' ( location_def )* 'type' ':' ( device_type )* ';' 'resources' ':' ( abilities_def )? ';'
			{
			deviceName=input.LT(1);
			if ( (input.LA(1) >= CAPITALIZED_ID && input.LA(1) <= ID) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,9,FOLLOW_9_in_device_def114); 
			 
			   context.currentNetwork = new DeviceCompiler();
			   context.currentNetwork.setDeviceName((deviceName!=null?deviceName.getText():null));
			   
			match(input,13,FOLLOW_13_in_device_def128); 
			match(input,9,FOLLOW_9_in_device_def130); 
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:36:18: ( location_def )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==CAPITALIZED_ID) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:36:19: location_def
					{
					pushFollow(FOLLOW_location_def_in_device_def133);
					location_def();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,15,FOLLOW_15_in_device_def142); 
			match(input,9,FOLLOW_9_in_device_def144); 
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:37:16: ( device_type )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==CAPITALIZED_ID) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:37:17: device_type
					{
					pushFollow(FOLLOW_device_type_in_device_def147);
					device_type();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,10,FOLLOW_10_in_device_def151); 
			match(input,14,FOLLOW_14_in_device_def157); 
			match(input,9,FOLLOW_9_in_device_def159); 
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:38:21: ( abilities_def )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==CAPITALIZED_ID) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:38:22: abilities_def
					{
					pushFollow(FOLLOW_abilities_def_in_device_def162);
					abilities_def();
					state._fsp--;

					}
					break;

			}

			match(input,10,FOLLOW_10_in_device_def167); 
			 context.currentNetwork.addDeviceObj();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "device_def"



	// $ANTLR start "location_def"
	// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:45:1: location_def : CAPITALIZED_ID ':' ID ';' ;
	public final void location_def() throws RecognitionException {
		Token CAPITALIZED_ID1=null;
		Token ID2=null;

		try {
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:45:14: ( CAPITALIZED_ID ':' ID ';' )
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:47:5: CAPITALIZED_ID ':' ID ';'
			{
			CAPITALIZED_ID1=(Token)match(input,CAPITALIZED_ID,FOLLOW_CAPITALIZED_ID_in_location_def196); 
			match(input,9,FOLLOW_9_in_location_def198); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_location_def200); 
			match(input,10,FOLLOW_10_in_location_def202); 
			context.currentNetwork.addRegionLabel((CAPITALIZED_ID1!=null?CAPITALIZED_ID1.getText():null));
			    context.currentNetwork.addRegionValue((ID2!=null?ID2.getText():null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "location_def"



	// $ANTLR start "device_type"
	// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:53:1: device_type : CAPITALIZED_ID ;
	public final void device_type() throws RecognitionException {
		Token CAPITALIZED_ID3=null;

		try {
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:53:13: ( CAPITALIZED_ID )
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:54:6: CAPITALIZED_ID
			{
			CAPITALIZED_ID3=(Token)match(input,CAPITALIZED_ID,FOLLOW_CAPITALIZED_ID_in_device_type227); 
			context.currentNetwork.setDeviceType((CAPITALIZED_ID3!=null?CAPITALIZED_ID3.getText():null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "device_type"



	// $ANTLR start "abilities_def"
	// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:59:1: abilities_def : CAPITALIZED_ID ( ',' abilities_def )? ;
	public final void abilities_def() throws RecognitionException {
		Token CAPITALIZED_ID4=null;

		try {
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:59:15: ( CAPITALIZED_ID ( ',' abilities_def )? )
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:60:4: CAPITALIZED_ID ( ',' abilities_def )?
			{
			CAPITALIZED_ID4=(Token)match(input,CAPITALIZED_ID,FOLLOW_CAPITALIZED_ID_in_abilities_def247); 
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:60:19: ( ',' abilities_def )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==8) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:60:20: ',' abilities_def
					{
					match(input,8,FOLLOW_8_in_abilities_def250); 
					pushFollow(FOLLOW_abilities_def_in_abilities_def252);
					abilities_def();
					state._fsp--;

					}
					break;

			}

			context.currentNetwork.addDeviceAbilities((CAPITALIZED_ID4!=null?CAPITALIZED_ID4.getText():null));
			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "abilities_def"



	// $ANTLR start "mobileFlag_def"
	// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:66:1: mobileFlag_def : 'mobile' ':' MOBILEFLAG ;
	public final void mobileFlag_def() throws RecognitionException {
		Token MOBILEFLAG5=null;

		try {
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:66:16: ( 'mobile' ':' MOBILEFLAG )
			// S:\\Thesis\\DevelopmentFramework\\IoTSuite\\ToolSuite\\src\\iotsuite\\parser\\NetworkSpec.g:67:4: 'mobile' ':' MOBILEFLAG
			{
			match(input,12,FOLLOW_12_in_mobileFlag_def271); 
			match(input,9,FOLLOW_9_in_mobileFlag_def273); 
			MOBILEFLAG5=(Token)match(input,MOBILEFLAG,FOLLOW_MOBILEFLAG_in_mobileFlag_def275); 
			context.currentNetwork.setMobileFlag((MOBILEFLAG5!=null?MOBILEFLAG5.getText():null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "mobileFlag_def"

	// Delegated rules



	public static final BitSet FOLLOW_11_in_networkspec58 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_networkspec60 = new BitSet(new long[]{0x0000000000000032L});
	public static final BitSet FOLLOW_device_def_in_networkspec78 = new BitSet(new long[]{0x0000000000000032L});
	public static final BitSet FOLLOW_set_in_device_def108 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_device_def114 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_device_def128 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_device_def130 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_location_def_in_device_def133 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_15_in_device_def142 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_device_def144 = new BitSet(new long[]{0x0000000000000410L});
	public static final BitSet FOLLOW_device_type_in_device_def147 = new BitSet(new long[]{0x0000000000000410L});
	public static final BitSet FOLLOW_10_in_device_def151 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_device_def157 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_device_def159 = new BitSet(new long[]{0x0000000000000410L});
	public static final BitSet FOLLOW_abilities_def_in_device_def162 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_device_def167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAPITALIZED_ID_in_location_def196 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_location_def198 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_location_def200 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_location_def202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAPITALIZED_ID_in_device_type227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAPITALIZED_ID_in_abilities_def247 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_8_in_abilities_def250 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_abilities_def_in_abilities_def252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_mobileFlag_def271 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_mobileFlag_def273 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_MOBILEFLAG_in_mobileFlag_def275 = new BitSet(new long[]{0x0000000000000002L});
}
