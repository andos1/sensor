package thundersensor;

import java.io.IOException;

import ch.quantasy.tinkerforge.tinker.agency.implementation.TinkerforgeStackAgency;
import ch.quantasy.tinkerforge.tinker.agent.implementation.TinkerforgeStackAgentIdentifier;



public class Test0 {

	public final static TinkerforgeStackAgentIdentifier FOO_SENSOR = new TinkerforgeStackAgentIdentifier(
		"localhost");

	
	public static void  main(String [] args) throws IOException{
		
		FooApp foo =new FooApp();
		TinkerforgeStackAgency.getInstance().getStackAgent(FOO_SENSOR)
		.addApplication(foo);
		
		System.in.read();
		
		TinkerforgeStackAgency.getInstance().getStackAgent(FOO_SENSOR)
		.removeApplication(foo);
	}
}
