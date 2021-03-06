package me.thehutch.cubiverse.utils;

import java.awt.Color;
import static me.thehutch.cubiverse.components.entity.GravityComponent.GRAV_CONST;

/**
 * @author thehutch
 */
public class Utils {

	/**
	 * Converts the wavelength given in nanometers to a colour of visible light.<br><br>
	 * Wavelengths outside of the visible spectrum return black
	 *
	 * @param wavelength
	 *			Nanomater wavelength between 380nm (inclusive) and 780nm (exclusive)
	 * @return
	 *			Colour of the wavelength in RGB
	 */
	public static Color convertWavelengthToRGB(float wavelength) {
		if (wavelength < 380) {
			return new Color(0.0f, 0.0f, 0.0f);
		}
		if (wavelength < 440) {
			return new Color(-(wavelength - 440.0f) / (440.0f - 380.0f), 0.0f, 1.0f);
		}
		if (wavelength < 490) {
			return new Color(0.0f, (440.0f - wavelength) / (490.0f - 440.0f), 1.0f);
		}
		if (wavelength < 510) {
			return new Color(0.0f, 1.0f, -(wavelength - 510.0f) / (510.0f - 490.0f));
		}
		if (wavelength < 580) {
			return new Color((wavelength - 510.0f) / (510.0f - 490.0f), 1.0f, 0.0f);
		}
		if (wavelength < 645) {
			return new Color(1.0f, -(wavelength - 645.0f) / (645.0f - 580.0f), 0.0f);
		}
		if (wavelength < 780) {
			return new Color(1.0f, 0.0f, 0.0f);
		}
		return new Color(0.0f, 0.0f, 0.0f);
	}

	/**
	 * Calculate the light intensity using the formula:
	 *
	 * F = L / 4πd²
	 * 
	 * @param luminosity
	 *			Luminosity of the star
	 * @param distance
	 *			Distance from the star
	 * @return
	 *			Light intensity (Flux)
	 */
	public static double calculateLightIntensity(double luminosity, double distance) {
		return luminosity / (4 * Math.PI * (distance * distance));
	}

	/**
	 * Calculate the gravitational force between an entity and planet
	 *
	 * @param massEntity
	 *			Mass of the entity
	 * @param massPlanet
	 *			Mass of the planet
	 * @param distance
	 *			Distance between the two relative to their center of mass
	 * @return
	 *			Force (N)
	 */
	public static double calculateForce(double massEntity, double massPlanet, double distance) {
		return (GRAV_CONST * massPlanet * massEntity) / (distance * distance);
	}
}