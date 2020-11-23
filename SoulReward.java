package io.github.Leonardo0013YT.UltraSkills.souls;

import io.github.Leonardo0013YT.UltraSkills.api.UltraSkillsAPI;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SoulReward {
  private List<String> cmds = new ArrayList<>();
  
  private String attribute;
  
  private String msg;
  
  private int probability;
  
  private int amount;
  
  public List<String> getCmds() {
    return this.cmds;
  }
  
  public void setCmds(List<String> cmds) {
    this.cmds = cmds;
  }
  
  public String getAttribute() {
    return this.attribute;
  }
  
  public String getMsg() {
    return this.msg;
  }
  
  public int getProbability() {
    return this.probability;
  }
  
  public int getAmount() {
    return this.amount;
  }
  
  public SoulReward(String attribute, int probability, int amount, String msg) {
    this.attribute = attribute;
    this.probability = probability;
    this.amount = amount;
    this.msg = msg;
  }
  
  public void apply(Player p) {
    switch (this.attribute.toUpperCase()) {
      case "COMMAND":
        for (String cmd : this.cmds)
          Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), cmd.replaceAll("<player>", p.getName())); 
        break;
      case "HEALTH":
        UltraSkillsAPI.setHealth(p, this.amount);
        break;
      case "DEFENSE":
        UltraSkillsAPI.setShield(p, this.amount);
        break;
      case "INTELLIGENCE":
        UltraSkillsAPI.setIntelligence(p, this.amount);
        break;
      case "STRENGTH":
        UltraSkillsAPI.setForce(p, this.amount);
        break;
      case "SPEED":
        UltraSkillsAPI.setSpeed(p, this.amount);
        break;
      case "CRITCHANCE":
        UltraSkillsAPI.setCritChance(p, this.amount);
        break;
      case "CRITDAMAGE":
        UltraSkillsAPI.setCritDamage(p, this.amount);
        break;
    } 
  }
}
