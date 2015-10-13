package me.xxmatthdxx.arcade.game;

/**
 * Created by Matthew on 2015-10-10.
 */
public class GameInfo {

    private boolean isTeamGame = false;
    private boolean isPVP = true;
    private boolean isPVE = false;
    private boolean isCanBreakBlocks = false;
    private boolean isCanPlaceBlocks = false;

    public GameInfo(){

    }

    public GameInfo(boolean isTeamGame, boolean isPVP, boolean isPVE, boolean isCanBreakBlocks, boolean isCanPlaceBlocks) {
        this.isTeamGame = isTeamGame;
        this.isPVP = isPVP;
        this.isPVE = isPVE;
        this.isCanBreakBlocks = isCanBreakBlocks;
        this.isCanPlaceBlocks = isCanPlaceBlocks;
    }

    public boolean isTeamGame() {
        return isTeamGame;
    }

    public void setIsTeamGame(boolean isTeamGame) {
        this.isTeamGame = isTeamGame;
    }

    public boolean isPVP() {
        return isPVP;
    }

    public void setIsPVP(boolean isPVP) {
        this.isPVP = isPVP;
    }

    public boolean isPVE() {
        return isPVE;
    }

    public void setIsPVE(boolean isPVE) {
        this.isPVE = isPVE;
    }

    public boolean isCanBreakBlocks() {
        return isCanBreakBlocks;
    }

    public void setIsCanBreakBlocks(boolean isCanBreakBlocks) {
        this.isCanBreakBlocks = isCanBreakBlocks;
    }

    public boolean isCanPlaceBlocks() {
        return isCanPlaceBlocks;
    }

    public void setIsCanPlaceBlocks(boolean isCanPlaceBlocks) {
        this.isCanPlaceBlocks = isCanPlaceBlocks;
    }
}
