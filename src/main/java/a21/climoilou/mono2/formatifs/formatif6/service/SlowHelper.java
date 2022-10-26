package a21.climoilou.mono2.formatifs.formatif6.service;

import java.util.Random;

public interface SlowHelper {

	public static void slow(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("de retour du sleep par annulation");
			//NOP
		}
	}

	public static void slowRandom(int minMillis, int maxMillis) {
		SlowHelper.slow(new Random().nextInt(maxMillis - minMillis) + minMillis);
	}
}
