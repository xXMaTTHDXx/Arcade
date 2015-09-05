package me.xxmatthdxx.arcade.game;

import me.xxmatthdxx.arcade.kit.Kit;
import me.xxmatthdxx.arcade.player.ArcadePlayer;
import me.xxmatthdxx.arcade.team.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Matthew on 2015-10-10.
 */
public class ArcadeGame {

    private String name;
    private String desc;
    private int maxPlayers;
    private int minPlayers;
    private GameMap currentMap;
    private List<GameMap> availibleMaps;
    private List<ArcadePlayer> allPlayers = new ArrayList<>();
    private List<ArcadePlayer> dead = new ArrayList<>();
    private GameInfo info;
    private List<Kit> kits;
    private GameState state;
    private List<Team> teams = new ArrayList<>();

    public ArcadeGame(String name, GameMap[] maps, Kit[] kits){
        this.name = name;
        this.availibleMaps = Arrays.asList(maps);
        this.kits = Arrays.asList(kits);
    }

    public ArcadeGame(String name, String desc, GameMap[] maps, Kit[] kits, GameInfo info) {
        this.name = name;
        this.desc = desc;
        this.availibleMaps = Arrays.asList(maps);
        this.kits = Arrays.asList(kits);
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public GameMap getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(GameMap currentMap) {
        this.currentMap = currentMap;
    }

    public List<GameMap> getAvailibleMaps() {
        return availibleMaps;
    }

    public void setAvailibleMaps(List<GameMap> availibleMaps) {
        this.availibleMaps = availibleMaps;
    }

    public List<ArcadePlayer> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(List<ArcadePlayer> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public GameInfo getInfo() {
        return info;
    }

    public void setInfo(GameInfo info) {
        this.info = info;
    }

    public List<Kit> getKits() {
        return kits;
    }

    public void setKits(List<Kit> kits) {
        this.kits = kits;
    }

    public List<ArcadePlayer> getDead() {
        return dead;
    }

    public void setDead(List<ArcadePlayer> dead) {
        this.dead = dead;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
