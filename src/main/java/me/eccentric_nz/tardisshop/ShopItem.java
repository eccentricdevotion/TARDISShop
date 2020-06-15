package me.eccentric_nz.tardisshop;

import org.bukkit.Material;

public enum ShopItem {

    ACID_BATTERY("Acid Battery", Material.NETHER_BRICK, 10000001),
    APPLE_JELLY_BABY("Apple Jelly Baby", Material.MELON_SLICE, 10000014),
    ARS_SEED("ARS Seed", Material.RED_MUSHROOM_BLOCK, 10000014, ShopItemRecipe.SEED),
    ARTRON_STORAGE_CELL("Artron Storage Cell", Material.BUCKET, 10000001),
    AUTHORISED_CONTROL_DISK("Authorised Control Disk", Material.MUSIC_DISC_FAR, 10000001),
    BIGGER_SEED("Bigger Seed", Material.RED_MUSHROOM_BLOCK, 10000015, ShopItemRecipe.SEED),
    BIO_SCANNER_CIRCUIT("Bio-scanner Circuit", Material.GLOWSTONE_DUST, 10001969),
    BIOME_STORAGE_DISK("Biome Storage Disk", Material.MUSIC_DISC_CAT, 10000001, ShopItemRecipe.SHAPELESS),
    BLACK_BOW_TIE("Black Bow Tie", Material.LEATHER_HELMET, 10000038),
    BLANK_STORAGE_DISK("Blank Storage Disk", Material.MUSIC_DISC_STRAD, 10000001),
    BLUE_BOW_TIE("Blue Bow Tie", Material.LEATHER_HELMET, 10000034),
    BLUEBERRY_JELLY_BABY("Blueberry Jelly Baby", Material.MELON_SLICE, 10000012, ShopItemRecipe.SHAPELESS),
    BOWL_OF_CUSTARD("Bowl of Custard", Material.MUSHROOM_STEW, 10000001, ShopItemRecipe.SHAPELESS),
    BROWN_BOW_TIE("Brown Bow Tie", Material.LEATHER_HELMET, 10000035),
    BUBBLEGUM_JELLY_BABY("Bubblegum Jelly Baby", Material.MELON_SLICE, 10000004, ShopItemRecipe.SHAPELESS),
    BUDGET_SEED("Budget Seed", Material.RED_MUSHROOM_BLOCK, 10000016, ShopItemRecipe.SEED),
    CAPPUCCINO_JELLY_BABY("Cappuccino Jelly Baby", Material.MELON_SLICE, 10000013, ShopItemRecipe.SHAPELESS),
    CORAL_SEED("Coral Seed", Material.RED_MUSHROOM_BLOCK, 10000017, ShopItemRecipe.SEED),
    CUSTARD_CREAM("Custard Cream", Material.COOKIE, 10000002),
    CYAN_BOW_TIE("Cyan Bow Tie", Material.LEATHER_HELMET, 10000032),
    CYBERMAN_HEAD("Cyberman Head", Material.IRON_INGOT, 4, ShopItemRecipe.TWA),
    DALEK_HEAD("Dalek Head", Material.SLIME_BALL, 10000019),
    DELUXE_SEED("Deluxe Seed", Material.RED_MUSHROOM_BLOCK, 10000018, ShopItemRecipe.SEED),
    DIAMOND_DISRUPTOR_CIRCUIT("Diamond Disruptor Circuit", Material.GLOWSTONE_DUST, 10001971),
    EARL_GREY_JELLY_BABY("Earl Grey Jelly Baby", Material.MELON_SLICE, 10000008, ShopItemRecipe.SHAPELESS),
    ELEVENTH_SEED("Eleventh Seed", Material.RED_MUSHROOM_BLOCK, 10000019, ShopItemRecipe.SEED),
    EMERALD_ENVIRONMENT_CIRCUIT("Emerald Environment Circuit", Material.GLOWSTONE_DUST, 10001972),
    EMPTY_CHILD_HEAD("Empty Child Head", Material.SUGAR, 4, ShopItemRecipe.TWA),
    ENDER_SEED("Ender Seed", Material.RED_MUSHROOM_BLOCK, 10000020, ShopItemRecipe.SEED),
    FACTORY_SEED("Factory Seed", Material.RED_MUSHROOM_BLOCK, 10000026, ShopItemRecipe.SEED),
    FISH_FINGER("Fish Finger", Material.COOKED_COD, 10000001),
    FOB_WATCH("Fob Watch", Material.CLOCK, 10000001),
    GRAPE_JELLY_BABY("Grape Jelly Baby", Material.MELON_SLICE, 10000011, ShopItemRecipe.SHAPELESS),
    GREEN_BOW_TIE("Green Bow Tie", Material.LEATHER_HELMET, 10000036),
    GREY_BOW_TIE("Grey Bow Tie", Material.LEATHER_HELMET, 10000030),
    HANDLES("Handles", Material.BIRCH_BUTTON, 10000001),
    HATH_HEAD("Hath Head", Material.PUFFERFISH, 5, ShopItemRecipe.TWA),
    ICE_WARRIOR_HEAD("Ice Warrior Head", Material.SNOWBALL, 5, ShopItemRecipe.TWA),
    IGNITE_CIRCUIT("Ignite Circuit", Material.GLOWSTONE_DUST, 10001982),
    ISLAND_PUNCH_JELLY_BABY("Island Punch Jelly Baby", Material.MELON_SLICE, 10000010, ShopItemRecipe.SHAPELESS),
    JAMMY_DODGER("Jammy Dodger", Material.COOKIE, 10000001),
    JUDOON_HEAD("Judoon Head", Material.YELLOW_DYE, 10, ShopItemRecipe.TWA),
    K9("K9", Material.BONE, 1, ShopItemRecipe.TWA),
    KNOCKBACK_CIRCUIT("Knockback Circuit", Material.GLOWSTONE_DUST, 10001986),
    LEGACY_BIGGER_SEED("Legacy Bigger Seed", Material.RED_MUSHROOM_BLOCK, 10000033, ShopItemRecipe.SEED),
    LEGACY_BUDGET_SEED("Legacy Budget Seed", Material.RED_MUSHROOM_BLOCK, 10000034, ShopItemRecipe.SEED),
    LEGACY_DELUXE_SEED("Legacy Deluxe Seed", Material.RED_MUSHROOM_BLOCK, 10000035, ShopItemRecipe.SEED),
    LEGACY_ELEVENTH_SEED("Legacy Eleventh Seed", Material.RED_MUSHROOM_BLOCK, 10000036, ShopItemRecipe.SEED),
    LEGACY_REDSTONE_SEED("Legacy Redstone Seed", Material.RED_MUSHROOM_BLOCK, 10000037, ShopItemRecipe.SEED),
    LEMON_JELLY_BABY("Lemon Jelly Baby", Material.MELON_SLICE, 10000005, ShopItemRecipe.SHAPELESS),
    LICORICE_JELLY_BABY("Licorice Jelly Baby", Material.MELON_SLICE, 10000016, ShopItemRecipe.SHAPELESS),
    LIGHT_BLUE_BOW_TIE("Light Blue Bow Tie", Material.LEATHER_HELMET, 10000026),
    LIGHT_GREY_BOW_TIE("Light Grey Bow Tie", Material.LEATHER_HELMET, 10000031),
    LIME_BOW_TIE("Lime Bow Tie", Material.LEATHER_HELMET, 10000028),
    LIME_JELLY_BABY("Lime Jelly Baby", Material.MELON_SLICE, 10000006, ShopItemRecipe.SHAPELESS),
    MAGENTA_BOW_TIE("Magenta Bow Tie", Material.LEATHER_HELMET, 10000025),
    MASTER_SEED("Master Seed", Material.RED_MUSHROOM_BLOCK, 10000039, ShopItemRecipe.SEED),
    OOD_HEAD("Ood Head", Material.ROTTEN_FLESH, 29, ShopItemRecipe.TWA),
    ORANGE_BOW_TIE("Orange Bow Tie", Material.LEATHER_HELMET, 10000024),
    ORANGE_JELLY_BABY("Orange Jelly Baby", Material.MELON_SLICE, 10000002, ShopItemRecipe.SHAPELESS),
    PAINTER_CIRCUIT("Painter Circuit", Material.GLOWSTONE_DUST, 10001979),
    PAPER_BAG("Paper Bag", Material.PAPER, 10000001),
    PERCEPTION_CIRCUIT("Perception Circuit", Material.GLOWSTONE_DUST, 10001978),
    PERCEPTION_FILTER("Perception Filter", Material.GOLD_NUGGET, 14),
    PICKUP_ARROWS_CIRCUIT("Pickup Arrows Circuit", Material.GLOWSTONE_DUST, 10001984),
    PINK_BOW_TIE("Pink Bow Tie", Material.LEATHER_HELMET, 10000029),
    PLANK_SEED("Plank Seed", Material.RED_MUSHROOM_BLOCK, 10000021, ShopItemRecipe.SEED),
    PLAYER_STORAGE_DISK("Player Storage Disk", Material.MUSIC_DISC_WAIT, 10000001, ShopItemRecipe.SHAPELESS),
    PRESET_STORAGE_DISK("Preset Storage Disk", Material.MUSIC_DISC_MALL, 10000001, ShopItemRecipe.SHAPELESS),
    PURPLE_BOW_TIE("Purple Bow Tie", Material.LEATHER_HELMET, 10000033),
    PYRAMID_SEED("Pyramid Seed", Material.RED_MUSHROOM_BLOCK, 10000022, ShopItemRecipe.SEED),
    RASPBERRY_JELLY_BABY("Raspberry Jelly Baby", Material.MELON_SLICE, 10000015, ShopItemRecipe.SHAPELESS),
    RED_BOW_TIE("Red Bow Tie", Material.LEATHER_HELMET, 10000037),
    REDSTONE_ACTIVATOR_CIRCUIT("Redstone Activator Circuit", Material.GLOWSTONE_DUST, 10001970),
    REDSTONE_SEED("Redstone Seed", Material.RED_MUSHROOM_BLOCK, 10000023, ShopItemRecipe.SEED),
    RIFT_CIRCUIT("Rift Circuit", Material.GLOWSTONE_DUST, 10001983),
    RIFT_MANIPULATOR("Rift Manipulator", Material.BEACON, 10000001),
    ROTOR_SEED("Rotor Seed", Material.MUSHROOM_STEM, 10000044, ShopItemRecipe.SEED),
    RUST_PLAGUE_SWORD("Rust Plague Sword", Material.IRON_SWORD, 10000001),
    SAVE_STORAGE_DISK("Save Storage Disk", Material.MUSIC_DISC_CHIRP, 10000001, ShopItemRecipe.SHAPELESS),
    SERVER_ADMIN_CIRCUIT("Server Admin Circuit", Material.GLOWSTONE_DUST, 10001968),
    SILENT_HEAD("Silent Head", Material.END_STONE, 3, ShopItemRecipe.TWA),
    SILURIAN_HEAD("Silurian Head", Material.FEATHER, 4, ShopItemRecipe.TWA),
    SONIC_GENERATOR("Sonic Generator", Material.FLOWER_POT, 10000001),
    SONIC_OSCILLATOR("Sonic Oscillator", Material.GLOWSTONE_DUST, 10001967),
    SONIC_SCREWDRIVER("Sonic Screwdriver", Material.BLAZE_ROD, 10000011),
    SONTARAN_HEAD("Sontaran Head", Material.POTATO, 5, ShopItemRecipe.TWA),
    STATTENHEIM_REMOTE("Stattenheim Remote", Material.FLINT, 10000001),
    STEAMPUNK_SEED("Steampunk Seed", Material.RED_MUSHROOM_BLOCK, 10000024, ShopItemRecipe.SEED),
    STRAWBERRY_JELLY_BABY("Strawberry Jelly Baby", Material.MELON_SLICE, 10000007, ShopItemRecipe.SHAPELESS),
    STRAX_HEAD("Strax Head", Material.POTATO, 4, ShopItemRecipe.TWA),
    TARDIS_ARS_CIRCUIT("TARDIS ARS Circuit", Material.GLOWSTONE_DUST, 10001973),
    TARDIS_ARTRON_FURNACE("TARDIS Artron Furnace", Material.FURNACE, 10000001),
    TARDIS_BIOME_READER("TARDIS Biome Reader", Material.BRICK, 10000001),
    TARDIS_CHAMELEON_CIRCUIT("TARDIS Chameleon Circuit", Material.GLOWSTONE_DUST, 10001966),
    TARDIS_COMMUNICATOR("TARDIS Communicator", Material.LEATHER_HELMET, 10000040),
    TARDIS_INPUT_CIRCUIT("TARDIS Input Circuit", Material.GLOWSTONE_DUST, 10001976),
    TARDIS_INVISIBILITY_CIRCUIT("TARDIS Invisibility Circuit", Material.GLOWSTONE_DUST, 10001981),
    TARDIS_KEY("TARDIS Key", Material.GOLD_NUGGET, 1),
    TARDIS_KEYBOARD_EDITOR("TARDIS Keyboard Editor", Material.OAK_SIGN, 10000001),
    TARDIS_LOCATOR("TARDIS Locator", Material.COMPASS, 10000001),
    TARDIS_LOCATOR_CIRCUIT("TARDIS Locator Circuit", Material.GLOWSTONE_DUST, 10001965),
    TARDIS_MATERIALISATION_CIRCUIT("TARDIS Materialisation Circuit", Material.GLOWSTONE_DUST, 10001964),
    TARDIS_MEMORY_CIRCUIT("TARDIS Memory Circuit", Material.GLOWSTONE_DUST, 10001975),
    TARDIS_RANDOMISER_CIRCUIT("TARDIS Randomiser Circuit", Material.GLOWSTONE_DUST, 10001980),
    TARDIS_REMOTE_KEY("TARDIS Remote Key", Material.GOLD_NUGGET, 15),
    TARDIS_SCANNER_CIRCUIT("TARDIS Scanner Circuit", Material.GLOWSTONE_DUST, 10001977),
    TARDIS_STATTENHEIM_CIRCUIT("TARDIS Stattenheim Circuit", Material.GLOWSTONE_DUST, 10001963),
    TARDIS_TELEPATHIC_CIRCUIT("TARDIS Telepathic Circuit", Material.DAYLIGHT_DETECTOR, 10000001),
    TARDIS_TEMPORAL_CIRCUIT("TARDIS Temporal Circuit", Material.GLOWSTONE_DUST, 10001974),
    THIRTEENTH_SEED("Thirteenth Seed", Material.RED_MUSHROOM_BLOCK, 10000025, ShopItemRecipe.SEED),
    THREE_D_GLASSES("3-D Glasses", Material.LEATHER_HELMET, 10000039),
    TIME_ROTOR_EARLY("Time Rotor Early", Material.LIGHT_GRAY_DYE, 10000002),
    TIME_ROTOR_ELEVENTH("Time Rotor Eleventh", Material.LIGHT_GRAY_DYE, 10000004),
    TIME_ROTOR_TENTH("Time Rotor Tenth", Material.LIGHT_GRAY_DYE, 10000003),
    TIME_ROTOR_TWELFTH("Time Rotor Twelfth", Material.LIGHT_GRAY_DYE, 10000005),
    //    TOCLAFANE_HEAD("Toclafane Head", Material.GUNPOWDER, 2, ShopItemRecipe.TWA),
    TOM_SEED("Tom Seed", Material.RED_MUSHROOM_BLOCK, 10000027, ShopItemRecipe.SEED),
    TWELFTH_SEED("Twelfth Seed", Material.RED_MUSHROOM_BLOCK, 10000028, ShopItemRecipe.SEED),
    VANILLA_JELLY_BABY("Vanilla Jelly Baby", Material.MELON_SLICE, 10000001, ShopItemRecipe.SHAPELESS),
    VASHTA_NERADA_HEAD("Vashta Nerada Head", Material.BOOK, 5, ShopItemRecipe.TWA),
    VODKA_JELLY_BABY("Vodka Jelly Baby", Material.MELON_SLICE, 10000009, ShopItemRecipe.SHAPELESS),
    WAR_SEED("War Seed", Material.RED_MUSHROOM_BLOCK, 10000029, ShopItemRecipe.SEED),
    WATERMELON_JELLY_BABY("Watermelon Jelly Baby", Material.MELON_SLICE, 10000003, ShopItemRecipe.SHAPELESS),
    WEEPING_ANGEL_HEAD("Weeping Angel Head", Material.BRICK, 5, ShopItemRecipe.TWA),
    WHITE_BOW_TIE("White Bow Tie", Material.LEATHER_HELMET, 10000023),
    YELLOW_BOW_TIE("Yellow Bow Tie", Material.LEATHER_HELMET, 10000027),
    ZYGON_HEAD("Zygon Head", Material.PAINTING, 4, ShopItemRecipe.TWA);

    private final String displayName;
    private final Material material;
    private final int customModelData;
    private final ShopItemRecipe recipeType;

    ShopItem(String displayName, Material material, int customModelData) {
        this.displayName = displayName;
        this.material = material;
        this.customModelData = customModelData;
        recipeType = ShopItemRecipe.SHAPED;
    }

    ShopItem(String displayName, Material material, int customModelData, ShopItemRecipe recipeType) {
        this.displayName = displayName;
        this.material = material;
        this.customModelData = customModelData;
        this.recipeType = recipeType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Material getMaterial() {
        return material;
    }

    public int getCustomModelData() {
        return customModelData;
    }

    public ShopItemRecipe getRecipeType() {
        return recipeType;
    }
}
