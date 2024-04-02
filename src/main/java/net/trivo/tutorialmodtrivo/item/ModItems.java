package net.trivo.tutorialmodtrivo.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trivo.tutorialmodtrivo.TutorialModTrivo;

public class ModItems {
    public  static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialModTrivo.MOD_ID);

    public static  final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public  static  final   RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));
    public  static  final  RegistryObject<Item> SCYTHE = ITEMS.register("scythe",
            () -> new Item(new Item.Properties()));

    public  static  void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
