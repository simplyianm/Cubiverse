package me.thehutch.cubiverse.universe;

import me.thehutch.cubiverse.data.Storable;
import org.spout.api.component.impl.DatatableComponent;
/**
 * @author thehutch
 */
public abstract class CelestialObject implements Storable {

	private final String name;
	private int radius;

	public CelestialObject(String name, int radius) {
		this.name = name;
		this.radius = radius;
	}

	public String getName() {
		return name;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public void save(DatatableComponent datatable) {
		
	}

	@Override
	public void load(DatatableComponent datatable) {
		
	}
}