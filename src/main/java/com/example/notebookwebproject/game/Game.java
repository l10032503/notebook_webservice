package com.example.notebookwebproject.game;

public class Game {
    private int gameid;
    public String gamename;

    private int mincpuranking, minhdd, mingpuranking ;
    private float minram;
    private String minos, mincpu, mingpu, mindirectx;

    private int reccpuranking, recram, rechdd, recgpuranking;
    private String recos, recpu, recgpu, recdirectx;

    public int getGameid() {
        return  gameid;
    }
    public void setGameid(int gameid){
        this.gameid = gameid;
    }
    public String getGamename(){
        return gamename;
    }

    public String getMinos(){
        return minos;
    }

    public String getMincpu(){
        return mincpu;
    }

    public int getMincpuranking(){
        return mincpuranking;
    }

    public int getMinram(){ return (int)minram;
    }

    public int getMinhdd(){
        return minhdd;
    }

    public String getMingpu(){
        return mingpu;
    }

    public int getMingpuranking(){
        return mingpuranking;
    }

    public String getMindirectx(){
        return mindirectx;
    }

    public String getRecos(){
        return recos;
    }

    public String getRecpu(){
        return recpu;
    }

    public int getReccpuranking(){
        return reccpuranking;
    }

    public int getRecram(){
        return recram;
    }

    public int getRechdd(){
        return  rechdd;
    }

    public String getRecgpu(){
        return recgpu;
    }

    public int getRecgpuranking(){
        return recgpuranking;
    }

    public String getRecdirectx(){
        return recdirectx;
    }
}
