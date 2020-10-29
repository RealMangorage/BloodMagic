package wayoftime.bloodmagic.common.data;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import wayoftime.bloodmagic.BloodMagic;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;
import wayoftime.bloodmagic.common.data.recipe.BaseRecipeProvider;
import wayoftime.bloodmagic.common.item.BloodMagicItems;
import wayoftime.bloodmagic.core.recipe.IngredientBloodOrb;

public class GeneratorBaseRecipes extends BaseRecipeProvider
{
	public GeneratorBaseRecipes(DataGenerator gen)
	{
		super(gen, BloodMagic.MODID);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
	{
		addVanillaRecipes(consumer);
		addBloodOrbRecipes(consumer);
	}

	private void addVanillaRecipes(Consumer<IFinishedRecipe> consumer)
	{
		ShapedRecipeBuilder.shapedRecipe(BloodMagicItems.SACRIFICIAL_DAGGER.get()).key('g', Tags.Items.GLASS).key('G', Tags.Items.INGOTS_GOLD).key('i', Tags.Items.INGOTS_IRON).patternLine("ggg").patternLine(" Gg").patternLine("i g").addCriterion("has_glass", hasItem(Items.GLASS)).build(consumer, BloodMagic.rl("sacrificial_dagger"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.BLOOD_ALTAR.get()).key('a', Tags.Items.STONE).key('b', Items.FURNACE).key('c', Tags.Items.INGOTS_GOLD).key('d', BloodMagicItems.MONSTER_SOUL_RAW.get()).patternLine("a a").patternLine("aba").patternLine("cdc").addCriterion("has_will", hasItem(BloodMagicItems.MONSTER_SOUL_RAW.get())).build(consumer, BloodMagic.rl("blood_altar"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.SOUL_FORGE.get()).key('s', Tags.Items.STONE).key('g', Tags.Items.INGOTS_GOLD).key('i', Tags.Items.INGOTS_IRON).key('o', Tags.Items.STORAGE_BLOCKS_IRON).patternLine("i i").patternLine("sgs").patternLine("sos").addCriterion("has_gold", hasItem(Items.GOLD_INGOT)).build(consumer, BloodMagic.rl("soul_forge"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicItems.SOUL_SNARE.get(), 4).key('r', Tags.Items.DUSTS_REDSTONE).key('s', Tags.Items.STRING).key('i', Tags.Items.INGOTS_IRON).patternLine("sis").patternLine("iri").patternLine("sis").addCriterion("has_redstone", hasItem(Items.REDSTONE)).build(consumer, BloodMagic.rl("soul_snare"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicItems.BASE_RITUAL_DIVINER.get()).key('a', BloodMagicItems.AIR_INSCRIPTION_TOOL.get()).key('s', Tags.Items.RODS_WOODEN).key('d', Tags.Items.GEMS_DIAMOND).key('e', BloodMagicItems.EARTH_INSCRIPTION_TOOL.get()).key('f', BloodMagicItems.FIRE_INSCRIPTION_TOOL.get()).key('w', BloodMagicItems.WATER_INSCRIPTION_TOOL.get()).patternLine("dfd").patternLine("ase").patternLine("dwd").addCriterion("has_scribe", hasItem(BloodMagicItems.AIR_INSCRIPTION_TOOL.get())).build(consumer, BloodMagic.rl("ritual_diviner_0"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicItems.DUSK_RITUAL_DIVINER.get()).key('S', BloodMagicItems.DEMONIC_SLATE.get()).key('t', BloodMagicItems.DUSK_INSCRIPTION_TOOL.get()).key('d', BloodMagicItems.BASE_RITUAL_DIVINER.get()).patternLine(" S ").patternLine("tdt").patternLine(" S ").addCriterion("has_demon_slate", hasItem(BloodMagicItems.DEMONIC_SLATE.get())).build(consumer, BloodMagic.rl("ritual_diviner_1"));
	}

	private void addBloodOrbRecipes(Consumer<IFinishedRecipe> consumer)
	{
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.BLANK_RUNE.get()).key('a', Tags.Items.STONE).key('s', Ingredient.fromItems(BloodMagicItems.SLATE.get())).key('o', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_WEAK.get())).patternLine("aaa").patternLine("sos").patternLine("aaa").addCriterion("has_weak_orb", hasItem(BloodMagicItems.WEAK_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("blood_rune_blank"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.SPEED_RUNE.get()).key('a', Tags.Items.STONE).key('b', Ingredient.fromItems(BloodMagicItems.SLATE.get())).key('c', Ingredient.fromItems(Items.SUGAR)).key('d', BloodMagicBlocks.BLANK_RUNE.get()).patternLine("aba").patternLine("cdc").patternLine("aba").addCriterion("has_blank_rune", hasItem(BloodMagicItems.BLANK_RUNE_ITEM.get())).build(consumer, BloodMagic.rl("blood_rune_speed"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.SACRIFICE_RUNE.get()).key('a', Tags.Items.STONE).key('b', BloodMagicItems.REINFORCED_SLATE.get()).key('c', Tags.Items.INGOTS_GOLD).key('d', BloodMagicBlocks.BLANK_RUNE.get()).key('e', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_APPRENTICE.get())).patternLine("aba").patternLine("cdc").patternLine("aea").addCriterion("has_apprentice_orb", hasItem(BloodMagicItems.APPRENTICE_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("blood_rune_sacrifice"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.SELF_SACRIFICE_RUNE.get()).key('a', Tags.Items.STONE).key('b', Ingredient.fromItems(BloodMagicItems.REINFORCED_SLATE.get())).key('c', Ingredient.fromItems(Items.GLOWSTONE_DUST)).key('d', Ingredient.fromItems(BloodMagicItems.BLANK_RUNE_ITEM.get())).key('e', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_APPRENTICE.get())).patternLine("aba").patternLine("cdc").patternLine("aea").addCriterion("has_apprentice_orb", hasItem(BloodMagicItems.APPRENTICE_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("blood_rune_self_sacrifice"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.CAPACITY_RUNE.get()).key('a', Tags.Items.STONE).key('b', Items.BUCKET).key('c', BloodMagicBlocks.BLANK_RUNE.get()).key('d', BloodMagicItems.IMBUED_SLATE.get()).patternLine("aba").patternLine("bcb").patternLine("ada").addCriterion("has_imbued_slate", hasItem(BloodMagicItems.IMBUED_SLATE.get())).build(consumer, BloodMagic.rl("blood_rune_capacity"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.ORB_RUNE.get()).key('a', Tags.Items.STONE).key('b', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_WEAK.get())).key('c', BloodMagicBlocks.BLANK_RUNE.get()).key('d', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_MASTER.get())).patternLine("aba").patternLine("cdc").patternLine("aba").addCriterion("has_master_orb", hasItem(BloodMagicItems.MASTER_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("blood_rune_orb"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.CHARGING_RUNE.get()).key('R', Tags.Items.DUSTS_REDSTONE).key('r', BloodMagicBlocks.BLANK_RUNE.get()).key('s', BloodMagicItems.DEMONIC_SLATE.get()).key('e', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_MASTER.get())).key('G', Tags.Items.DUSTS_GLOWSTONE).patternLine("RsR").patternLine("GrG").patternLine("ReR").addCriterion("has_master_orb", hasItem(BloodMagicItems.MASTER_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("blood_rune_charging"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.BLANK_RITUAL_STONE.get(), 4).key('a', Tags.Items.OBSIDIAN).key('b', BloodMagicItems.REINFORCED_SLATE.get()).key('c', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_APPRENTICE.get())).patternLine("aba").patternLine("bcb").patternLine("aba").addCriterion("has_apprentice_orb", hasItem(BloodMagicItems.APPRENTICE_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("ritual_stone_blank"));
		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.MASTER_RITUAL_STONE.get()).key('a', Tags.Items.OBSIDIAN).key('b', BloodMagicBlocks.BLANK_RITUAL_STONE.get()).key('c', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_MAGICIAN.get())).patternLine("aba").patternLine("bcb").patternLine("aba").addCriterion("has_magician_orb", hasItem(BloodMagicItems.MAGICIAN_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("ritual_stone_master"));

		ShapedRecipeBuilder.shapedRecipe(BloodMagicItems.LAVA_CRYSTAL.get()).key('a', Tags.Items.GLASS).key('b', Items.LAVA_BUCKET).key('c', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_WEAK.get())).key('d', Tags.Items.OBSIDIAN).key('e', Tags.Items.GEMS_DIAMOND).patternLine("aba").patternLine("bcb").patternLine("ded").addCriterion("has_weak_orb", hasItem(BloodMagicItems.WEAK_BLOOD_ORB.get())).build(consumer, BloodMagic.rl("lava_crystal"));
//		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.SPEED_RUNE.get()).key('s', Items.GLASS).key('o', Ingredient.fromItems(Items.DIAMOND)).patternLine("sss").patternLine("sos").patternLine("sss").addCriterion("has_diamond", hasItem(Items.DIAMOND)).build(consumer, new ResourceLocation(BloodMagic.MODID, "speed_rune_from_standard"));
//		ShapedRecipeBuilder.shapedRecipe(BloodMagicBlocks.SPEED_RUNE.get()).key('s', Items.GLASS).key('o', IngredientBloodOrb.fromOrb(BloodMagicItems.ORB_WEAK.get())).patternLine("sss").patternLine("sos").patternLine("sss").addCriterion("has_diamond", hasItem(Items.DIAMOND)).build(consumer, new ResourceLocation(BloodMagic.MODID, "speed_rune_from_orb"));
	}
}
