package io.github.Leonardo0013YT.UltraSkills;

import io.github.Leonardo0013YT.UltraSkills.cmds.CollectionsCMD;
import io.github.Leonardo0013YT.UltraSkills.cmds.SetupCMD;
import io.github.Leonardo0013YT.UltraSkills.cmds.SkillsCMD;
import io.github.Leonardo0013YT.UltraSkills.cmds.TradesCMD;
import io.github.Leonardo0013YT.UltraSkills.cmds.UltraSkyBlockCoreCMD;
import io.github.Leonardo0013YT.UltraSkills.config.Settings;
import io.github.Leonardo0013YT.UltraSkills.database.MySQLDatabase;
import io.github.Leonardo0013YT.UltraSkills.interfaces.Database;
import io.github.Leonardo0013YT.UltraSkills.listeners.ArmorListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.CollectionsListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.CraftListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.DragonListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.MenuListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.PlayerListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.SetupListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.SkillsListener;
import io.github.Leonardo0013YT.UltraSkills.listeners.WithoutNBTCollectionsListener;
import io.github.Leonardo0013YT.UltraSkills.managers.AddonManager;
import io.github.Leonardo0013YT.UltraSkills.managers.ArmorManager;
import io.github.Leonardo0013YT.UltraSkills.managers.CollectionManager;
import io.github.Leonardo0013YT.UltraSkills.managers.ConfigManager;
import io.github.Leonardo0013YT.UltraSkills.managers.CraftManager;
import io.github.Leonardo0013YT.UltraSkills.managers.DragonsManager;
import io.github.Leonardo0013YT.UltraSkills.managers.ItemManager;
import io.github.Leonardo0013YT.UltraSkills.managers.MinesManager;
import io.github.Leonardo0013YT.UltraSkills.managers.PetManager;
import io.github.Leonardo0013YT.UltraSkills.managers.RunesManager;
import io.github.Leonardo0013YT.UltraSkills.managers.SetupManager;
import io.github.Leonardo0013YT.UltraSkills.managers.SkillManager;
import io.github.Leonardo0013YT.UltraSkills.managers.SoulsManager;
import io.github.Leonardo0013YT.UltraSkills.managers.TaskManager;
import io.github.Leonardo0013YT.UltraSkills.managers.TradeManager;
import io.github.Leonardo0013YT.UltraSkills.menus.SetupMenu;
import io.github.Leonardo0013YT.UltraSkills.menus.UltraSkyBlockCoreMenu;
import io.github.Leonardo0013YT.UltraSkills.placeholders.MVdWPlaceholders;
import io.github.Leonardo0013YT.UltraSkills.placeholders.Placeholders;
import io.github.Leonardo0013YT.UltraSkills.runes.Runnetable;
import io.github.Leonardo0013YT.UltraSkills.utils.DependUtils;
import io.github.Leonardo0013YT.UltraSkills.utils.GSonUtils;
import io.github.Leonardo0013YT.UltraSkills.xseries.XSound;
import java.io.File;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
  private static Main instance;
  
  private GSonUtils gsu;
  
  private Settings dragons;
  
  private Settings temp;
  
  private Settings runes;
  
  private Settings pets;
  
  private Settings crafts;
  
  private Settings souls;
  
  private Settings mines;
  
  private Settings armors;
  
  private Settings sources;
  
  private Settings lang;
  
  private Settings skills;
  
  private Settings trades;
  
  private Settings collections;
  
  private SkillManager skm;
  
  private ConfigManager cfm;
  
  private Database db;
  
  private UltraSkyBlockCoreMenu sem;
  
  private TaskManager tsm;
  
  private SetupManager sm;
  
  private SetupMenu stem;
  
  private ArmorManager am;
  
  private TradeManager tm;
  
  private CollectionManager clm;
  
  private AddonManager adm;
  
  private MinesManager mm;
  
  private SoulsManager slm;
  
  private CraftManager cm;
  
  private PetManager pm;
  
  private RunesManager rm;
  
  private DragonsManager dm;
  
  private ItemManager im;
  
  public GSonUtils getGsu() {
    return this.gsu;
  }
  
  public Settings getDragons() {
    return this.dragons;
  }
  
  public Settings getTemp() {
    return this.temp;
  }
  
  public Settings getRunes() {
    return this.runes;
  }
  
  public Settings getPets() {
    return this.pets;
  }
  
  public Settings getCrafts() {
    return this.crafts;
  }
  
  public Settings getSouls() {
    return this.souls;
  }
  
  public Settings getMines() {
    return this.mines;
  }
  
  public Settings getArmors() {
    return this.armors;
  }
  
  public Settings getSources() {
    return this.sources;
  }
  
  public Settings getLang() {
    return this.lang;
  }
  
  public Settings getSkills() {
    return this.skills;
  }
  
  public Settings getTrades() {
    return this.trades;
  }
  
  public Settings getCollections() {
    return this.collections;
  }
  
  public SkillManager getSkm() {
    return this.skm;
  }
  
  public ConfigManager getCfm() {
    return this.cfm;
  }
  
  public Database getDb() {
    return this.db;
  }
  
  public UltraSkyBlockCoreMenu getSem() {
    return this.sem;
  }
  
  public TaskManager getTsm() {
    return this.tsm;
  }
  
  public SetupManager getSm() {
    return this.sm;
  }
  
  public SetupMenu getStem() {
    return this.stem;
  }
  
  public ArmorManager getAm() {
    return this.am;
  }
  
  public TradeManager getTm() {
    return this.tm;
  }
  
  public CollectionManager getClm() {
    return this.clm;
  }
  
  public AddonManager getAdm() {
    return this.adm;
  }
  
  public MinesManager getMm() {
    return this.mm;
  }
  
  public SoulsManager getSlm() {
    return this.slm;
  }
  
  public CraftManager getCm() {
    return this.cm;
  }
  
  public PetManager getPm() {
    return this.pm;
  }
  
  public RunesManager getRm() {
    return this.rm;
  }
  
  public DragonsManager getDm() {
    return this.dm;
  }
  
  public ItemManager getIm() {
    return this.im;
  }
  
  public static Main get() {
    return instance;
  }
  
  public void onEnable() {
    instance = this;
    (new DependUtils(this)).loadDepends();
    getConfig().options().copyDefaults(true);
    saveSounds();
    saveConfig();
    saveSkills();
    this.armors = new Settings(this, "armors", true, false);
    this.sources = new Settings(this, "sources", true, false);
    this.lang = new Settings(this, "lang", true, false);
    this.skills = new Settings(this, "skills", true, false);
    this.trades = new Settings(this, "trades", false, false);
    this.collections = new Settings(this, "collections", false, false);
    this.mines = new Settings(this, "mines", false, false);
    this.souls = new Settings(this, "souls", false, false);
    this.crafts = new Settings(this, "crafts", false, false);
    this.pets = new Settings(this, "pets", false, false);
    this.runes = new Settings(this, "runes", false, false);
    this.temp = new Settings(this, "temp", false, false);
    this.dragons = new Settings(this, "dragons", true, false);
    this.gsu = new GSonUtils();
    this.pm = new PetManager(this);
    this.cm = new CraftManager(this);
    this.cfm = new ConfigManager(this);
    this.skm = new SkillManager(this);
    this.db = (Database)new MySQLDatabase(this);
    this.sem = new UltraSkyBlockCoreMenu(this);
    this.sm = new SetupManager(this);
    this.stem = new SetupMenu(this);
    this.am = new ArmorManager(this);
    this.tm = new TradeManager(this);
    this.clm = new CollectionManager(this);
    this.adm = new AddonManager(this);
    this.adm.loadAddons();
    this.mm = new MinesManager(this);
    this.slm = new SoulsManager(this);
    this.tsm = new TaskManager(this);
    this.dm = new DragonsManager(this);
    this.dm.reload();
    this.rm = new RunesManager(this);
    this.im = new ItemManager(this);
    getServer().getPluginManager().registerEvents((Listener)new DragonListener(this), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new PlayerListener(this), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new MenuListener(this), (Plugin)this);
    if (this.cfm.isUseNBT()) {
      getServer().getPluginManager().registerEvents((Listener)new CollectionsListener(this), (Plugin)this);
    } else {
      getServer().getPluginManager().registerEvents((Listener)new WithoutNBTCollectionsListener(this), (Plugin)this);
    } 
    getServer().getPluginManager().registerEvents((Listener)new SkillsListener(this), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new SetupListener(this), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new CraftListener(this), (Plugin)this);
    getServer().getPluginManager().registerEvents((Listener)new ArmorListener(new ArrayList()), (Plugin)this);
    getCommand("collections").setExecutor((CommandExecutor)new CollectionsCMD(this));
    getCommand("skills").setExecutor((CommandExecutor)new SkillsCMD(this));
    getCommand("trades").setExecutor((CommandExecutor)new TradesCMD(this));
    getCommand("ssetup").setExecutor((CommandExecutor)new SetupCMD(this));
    getCommand("usbc").setExecutor((CommandExecutor)new UltraSkyBlockCoreCMD(this));
    if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI"))
      (new Placeholders(this)).register(); 
    if (getServer().getPluginManager().isPluginEnabled("MVdWPlaceholderAPI"))
      (new MVdWPlaceholders(this)).register(); 
    (new BukkitRunnable() {
        public void run() {
          Main.this.pm.update();
        }
      }).runTaskTimer((Plugin)this, 2L, 2L);
  }
  
  public void onDisable() {
    getServer().getOnlinePlayers().forEach(on -> getPm().removePetPlayer(on));
    getRm().getRunnetables().values().forEach(Runnetable::remove);
    for (Player on : getServer().getOnlinePlayers())
      getDb().savePlayer(on, true); 
    try {
      Thread.sleep(3000L);
    } catch (InterruptedException interruptedException) {}
    getDb().close();
  }
  
  public void reload() {
    reloadConfig();
    this.armors.reload();
    this.lang.reload();
    this.skills.reload();
    this.trades.reload();
    this.mines.reload();
    this.souls.reload();
    this.crafts.reload();
    this.collections.reload();
    this.temp.reload();
    this.dragons.reload();
    this.pets.reload();
    this.runes.reload();
    this.cfm.reload();
    this.skm.reload();
    this.am.reload();
    this.tm.reload();
    this.tsm.reload();
    this.clm.reload();
    this.mm.reload();
    this.cm.reload();
    this.adm.loadAddons();
    this.slm.reload();
    this.pm.reload();
    this.rm.reload();
    this.dm.reload();
  }
  
  public void saveSounds() {
    getConfig().addDefault("sounds.pet.levelUp.sound", XSound.BLOCK_NOTE_BLOCK_HARP.parseSound().name());
    getConfig().addDefault("sounds.pet.levelUp.volume", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.pet.levelUp.pitch", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.progress.sound", XSound.BLOCK_NOTE_BLOCK_PLING.parseSound().name());
    getConfig().addDefault("sounds.progress.volume", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.progress.pitch", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.noHas.sound", XSound.ENTITY_ENDERMAN_TELEPORT.parseSound().name());
    getConfig().addDefault("sounds.noHas.volume", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.noHas.pitch", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.collection.unlocked.sound", XSound.ENTITY_PLAYER_LEVELUP.parseSound().name());
    getConfig().addDefault("sounds.collection.unlocked.volume", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.collection.unlocked.pitch", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.collection.levelUp.sound", XSound.ENTITY_PLAYER_LEVELUP.parseSound().name());
    getConfig().addDefault("sounds.collection.levelUp.volume", Float.valueOf(1.0F));
    getConfig().addDefault("sounds.collection.levelUp.pitch", Float.valueOf(1.0F));
  }
  
  public void saveSkills() {
    if (!(new File(getDataFolder(), "skills/farmer.yml")).exists())
      saveResource("skills/farmer.yml", false); 
    if (!(new File(getDataFolder(), "skills/miner.yml")).exists())
      saveResource("skills/miner.yml", false); 
    if (!(new File(getDataFolder(), "skills/combat.yml")).exists())
      saveResource("skills/combat.yml", false); 
    if (!(new File(getDataFolder(), "skills/foraging.yml")).exists())
      saveResource("skills/foraging.yml", false); 
    if (!(new File(getDataFolder(), "skills/fishing.yml")).exists())
      saveResource("skills/fishing.yml", false); 
    if (!(new File(getDataFolder(), "skills/enchanting.yml")).exists())
      saveResource("skills/enchanting.yml", false); 
    if (!(new File(getDataFolder(), "skills/alchemy.yml")).exists())
      saveResource("skills/alchemy.yml", false); 
    if (!(new File(getDataFolder(), "skills/taming.yml")).exists())
      saveResource("skills/taming.yml", false); 
    if (!(new File(getDataFolder(), "skills/runecrafting.yml")).exists())
      saveResource("skills/runecrafting.yml", false); 
  }
  
  public void sendLogMessage(String msg) {
    Bukkit.getConsoleSender().sendMessage("+ msg);
  }
  
  public void sendLogMessage(String... msg) {
    for (String m : msg)
      sendLogMessage(m); 
  }
}
