package net.trivo.tutorialmodtrivo;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.trivo.tutorialmodtrivo.block.ModBlocks;
import net.trivo.tutorialmodtrivo.item.ModCreativeModTabs;
import net.trivo.tutorialmodtrivo.item.ModItems;
import org.slf4j.Logger;

@Mod(TutorialModTrivo.MOD_ID)
public class TutorialModTrivo
{
    public static final String MOD_ID = "tutorialmodtrivo";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialModTrivo()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
        }
            if (event.getTabKey() == CreativeModeTabs.COMBAT) {
                event.accept(ModItems.SCYTHE);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.RAW_SAPPHIRE_BLOCK);
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.CHARCOAL_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.SAPPHIRE_ORE);
            event.accept(ModBlocks.NETHER_SAPPHIRE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
            event.accept(ModBlocks.END_STONE_SAPPHIRE_ORE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
