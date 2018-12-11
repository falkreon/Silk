package io.github.prospector.silk.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.Facing;

public interface FluidContainer {
	boolean canInsertFluid(Facing fromSide, Fluid fluid, int amount);

	boolean canExtractFluid(Facing fromSide, Fluid fluid, int amount);

	default boolean tryInsertFluid(Facing fromSide, Fluid fluid, int amount) {
		if (canInsertFluid(fromSide, fluid, amount)) {
			insertFluid(fromSide, fluid, amount);
			return true;
		}
		return false;
	}

	default boolean tryExtractFluid(Facing fromSide, Fluid fluid, int amount) {
		if (canExtractFluid(fromSide, fluid, amount)) {
			extractFluid(fromSide, fluid, amount);
			return true;
		}
		return false;
	}

	void insertFluid(Facing fromSide, Fluid fluid, int amount);

	void extractFluid(Facing fromSide, Fluid fluid, int amount);

	void setFluid(Facing fromSide, FluidInstance instance);

	FluidInstance[] getFluids(Facing fromSide);
}