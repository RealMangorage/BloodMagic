package wayoftime.bloodmagic.common.data.recipe.builder;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import wayoftime.bloodmagic.api.SerializerHelper;
import wayoftime.bloodmagic.common.data.recipe.BloodMagicRecipeBuilder;
import wayoftime.bloodmagic.util.Constants;

public class BloodAltarRecipeBuilder extends BloodMagicRecipeBuilder<BloodAltarRecipeBuilder>
{
	private final Ingredient input;
	private final ItemStack output;
	private final int minimumTier;
	private final int syphon;
	private final int consumeRate;
	private final int drainRate;

	protected BloodAltarRecipeBuilder(Ingredient input, ItemStack output, int minimumTier, int syphon, int consumeRate, int drainRate)
	{
		super(bmSerializer("altar"));
		this.input = input;
		this.output = output;
		this.minimumTier = minimumTier;
		this.syphon = syphon;
		this.consumeRate = consumeRate;
		this.drainRate = drainRate;
	}

	public static BloodAltarRecipeBuilder altar(Ingredient input, ItemStack output, int minimumTier, int syphon, int consumeRate, int drainRate)
	{
		return new BloodAltarRecipeBuilder(input, output, minimumTier, syphon, consumeRate, drainRate);
	}

	@Override
	protected BloodAltarRecipeResult getResult(ResourceLocation id)
	{
		return new BloodAltarRecipeResult(id);
	}

	public class BloodAltarRecipeResult extends RecipeResult
	{
		protected BloodAltarRecipeResult(ResourceLocation id)
		{
			super(id);
		}

		@Override
		public void serialize(@Nonnull JsonObject json)
		{
			json.add(Constants.JSON.INPUT, input.serialize());
			json.add(Constants.JSON.OUTPUT, SerializerHelper.serializeItemStack(output));
			json.addProperty(Constants.JSON.ALTAR_TIER, minimumTier);
			json.addProperty(Constants.JSON.ALTAR_SYPHON, syphon);
			json.addProperty(Constants.JSON.ALTAR_CONSUMPTION_RATE, consumeRate);
			json.addProperty(Constants.JSON.ALTAR_DRAIN_RATE, drainRate);
		}
	}
}
