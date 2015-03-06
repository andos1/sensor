package thundersensor;

import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.BrickletSoundIntensity;
import com.tinkerforge.BrickletSoundIntensity.IntensityReachedListener;
import com.tinkerforge.Device;
import com.tinkerforge.BrickletAmbientLight.IlluminanceReachedListener;

import ch.quantasy.tinkerforge.tinker.agent.definition.Agent;
import ch.quantasy.tinkerforge.tinker.agent.implementation.TinkerforgeStackAgent;
import ch.quantasy.tinkerforge.tinker.application.definition.TinkerforgeApplication;
import ch.quantasy.tinkerforge.tinker.application.implementation.AbstractTinkerforgeApplication;
import ch.quantasy.tinkerforge.tinker.core.implementation.TinkerforgeDevice;

public class FooApp extends AbstractTinkerforgeApplication implements IntensityReachedListener{

	private BrickletSoundIntensity soundBricklet;

	@Override
	public void deviceConnected(
			final TinkerforgeStackAgent tinkerforgeStackAgent,
			final Device device) {
		if (TinkerforgeDevice.getDevice(device) == TinkerforgeDevice.SoundIntensity) {
			if (this.soundBricklet != null) {
				return;
			}
			this.soundBricklet = (BrickletSoundIntensity) device;
			this.soundBricklet.addIntensityReachedListener(this);
		}
	}

	@Override
	public void deviceDisconnected(
			final TinkerforgeStackAgent tinkerforgeStackAgent,
			final Device device) {
		if ((TinkerforgeDevice.getDevice(device) == TinkerforgeDevice.SoundIntensity)
				&& device.equals(this.soundBricklet)) {
			((BrickletSoundIntensity) device)
			.removeIntensityReachedListener(this);
			this.soundBricklet = null;
		}
	}

	@Override
	public boolean equals(Object obj) {

		return this==obj;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void intensityReached(int intensity) {
		System.out.print(intensity+":");		
	}


}
