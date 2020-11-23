package io.github.Leonardo0013YT.UltraSkills.trades;

import io.github.Leonardo0013YT.UltraSkills.Main;
import io.github.Leonardo0013YT.UltraSkills.utils.ItemUtils;
import io.github.Leonardo0013YT.UltraSkills.utils.NBTEditor;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;

public class Trade {
  private String key;
  
  private String permission;
  
  private String displayname;
  
  private ItemStack give;
  
  private ItemStack cost;
  
  private int slot;
  
  private int page;
  
  private int perAmount;
  
  private int perCost;
  
  private List<String> lore;
  
  private Main plugin;
  
  public String getKey() {
    return this.key;
  }
  
  public String getPermission() {
    return this.permission;
  }
  
  public String getDisplayname() {
    return this.displayname;
  }
  
  public ItemStack getGive() {
    return this.give;
  }
  
  public ItemStack getCost() {
    return this.cost;
  }
  
  public int getSlot() {
    return this.slot;
  }
  
  public int getPage() {
    return this.page;
  }
  
  public int getPerAmount() {
    return this.perAmount;
  }
  
  public int getPerCost() {
    return this.perCost;
  }
  
  public List<String> getLore() {
    return this.lore;
  }
  
  public Main getPlugin() {
    return this.plugin;
  }
  
  public Trade(Main plugin, String path) {
    this.plugin = plugin;
    this.key = plugin.getTrades().getString(path + ".key");
    this.permission = plugin.getTrades().getString(path + ".permission");
    this.displayname = plugin.getTrades().getString(path + ".displayname");
    this.slot = plugin.getTrades().getInt(path + ".slot");
    this.page = plugin.getTrades().getInt(path + ".page");
    this.give = plugin.getTrades().getConfig().getItemStack(path + ".give");
    this.perAmount = this.give.getAmount();
    this.cost = plugin.getTrades().getConfig().getItemStack(path + ".cost");
    this.perCost = this.cost.getAmount();
    List<String> lore = new ArrayList<>();
    for (String s : plugin.getTrades().getList(path + ".lore"))
      lore.add(s.replaceAll("&", ")); 
    this.lore = lore;
  }
  
  public ItemStack getIcon(boolean main, int amount) {
    if (amount == 1 && this.perAmount == 1 && this.perCost == 1) {
      List<String> lore = new ArrayList<>();
      for (String s : this.lore) {
        if (s.equals("<tradingOptions>")) {
          if (main)
            lore.add(this.plugin.getLang().getString("tradingOptions")); 
          continue;
        } 
        lore.add(s.replaceAll("<amount>", ""));
      } 
      item = (new ItemUtils(this.give.clone(), amount)).setDisplayName(this.displayname.replaceAll("<amount>", "")).setLore(lore).build();
    } else if (amount == 1 && this.perAmount != 1 && this.perCost == 1) {
      List<String> lore = new ArrayList<>();
      for (String s : this.lore) {
        if (s.equals("<tradingOptions>")) {
          if (main)
            lore.add(this.plugin.getLang().getString("tradingOptions")); 
          continue;
        } 
        lore.add(s.replaceAll("<amount>", ""));
      } 
      item = (new ItemUtils(this.give.clone(), amount)).setDisplayName(this.displayname.replaceAll("<amount>", this.plugin.getLang().getString("amount").replace("<amount>", String.valueOf(amount * this.perAmount)))).setLore(lore).build();
    } else if (amount == 1 && this.perAmount != 1) {
      List<String> lore = new ArrayList<>();
      for (String s : this.lore) {
        if (s.equals("<tradingOptions>")) {
          if (main)
            lore.add(this.plugin.getLang().getString("tradingOptions")); 
          continue;
        } 
        lore.add(s.replaceAll("<amount>", this.plugin.getLang().getString("amount").replace("<amount>", String.valueOf(amount * this.perCost))));
      } 
      item = (new ItemUtils(this.give.clone(), amount)).setDisplayName(this.displayname.replaceAll("<amount>", this.plugin.getLang().getString("amount").replace("<amount>", String.valueOf(amount * this.perAmount)))).setLore(lore).build();
    } else {
      List<String> lore = new ArrayList<>();
      for (String s : this.lore) {
        if (s.equals("<tradingOptions>")) {
          if (main)
            lore.add(this.plugin.getLang().getString("tradingOptions")); 
          continue;
        } 
        lore.add(s.replaceAll("<amount>", this.plugin.getLang().getString("amount").replace("<amount>", String.valueOf(amount * this.perCost))));
      } 
      item = (new ItemUtils(this.give.clone(), amount)).setDisplayName(this.displayname.replaceAll("<amount>", this.plugin.getLang().getString("amount").replace("<amount>", String.valueOf(amount * this.perAmount)))).setLore(lore).build();
    } 
    ItemStack item = (ItemStack)NBTEditor.set(item, Integer.valueOf(amount), new Object[] { "ULTRASKILLS", "TRADE", "AMOUNT" });
    return (ItemStack)NBTEditor.set(item, this.key, new Object[] { "ULTRASKILLS", "TRADE", "KEY" });
  }
}
