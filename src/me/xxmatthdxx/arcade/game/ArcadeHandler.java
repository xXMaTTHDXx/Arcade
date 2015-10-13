package me.xxmatthdxx.arcade.game;

import me.xxmatthdxx.arcade.Arcade;
import me.xxmatthdxx.arcade.kit.Kit;
import me.xxmatthdxx.arcade.kit.KitHandler;
import me.xxmatthdxx.arcade.player.ArcadePlayer;
import me.xxmatthdxx.arcade.timer.GameTimer;
import me.xxmatthdxx.arcade.util.LocationUtil;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Matthew on 2015-10-11.
 */
public class ArcadeHandler {

    private List<ArcadeGame> enabledGames = new ArrayList<>();
    private ArcadeGame lastGame;
    private ArcadeGame currentGame;

    private static ArcadeHandler instance;

    public void init(){
        currentGame = enabledGames.get(0);
        lastGame = currentGame;
    }

    public static ArcadeHandler getInstance(){
        if(instance == null){
            instance = new ArcadeHandler();
        }
        return instance;
    }

    public ArcadeGame getCurrentGame(){
        if(lastGame == null){
            currentGame = enabledGames.get(0);
        }
        return currentGame;
    }

    public ArcadeGame getNextGame(){
        Random ran = new Random();
        int ranInt = ran.nextInt(enabledGames.size() - 1);
        if(enabledGames.get(ranInt) == lastGame){
            return getNextGame();
        }
        else {
            return enabledGames.get(ranInt);
        }
    }

    public void startGame(){
        KitHandler handler = Arcade.getInstance().getKitHandler();
        for(ArcadePlayer player : currentGame.getAllPlayers()){
            handler.getKit(player).giveKit(player);
        }

        if(currentGame.getInfo().isTeamGame()){
            //TODO sort teams
        }
        else {
            LocationUtil.distribute(currentGame.getAllPlayers(), currentGame.getCurrentMap().getSpawns());
            Arcade.getInstance().setState(GameState.INGAME);
        }
    }

    public void endRound(){
        for(ArcadePlayer player : currentGame.getAllPlayers()){
            player.getPlayer().teleport(currentGame.getCurrentMap().getLobby());
            player.getPlayer().getInventory().clear();
        }
        Arcade.getInstance().setState(GameState.LOBBY);
    }

    public void cycleGame(){
        int index = enabledGames.indexOf(currentGame);
        if(enabledGames.get(index + 1) == null){
            stopGame();
        }
        currentGame = enabledGames.get(index + 1);
        startGame();
    }

    public void stopGame(){
        //TODO display winners.
    }

    public List<ArcadeGame> getEnabledGames() {
        return enabledGames;
    }

    public ArcadeGame getLastGame() {
        return lastGame;
    }

    public void setCurrentGame(ArcadeGame game){
        this.currentGame = game;
    }
}
