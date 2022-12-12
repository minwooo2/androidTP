package com.example.teamProject;

public class CardData {
    private int Id;//카드 ID
    private boolean Face;//카드 앞뒤 앞 : 1, 뒤 : 0
    private boolean Match;//매칭된 카드

    public CardData(int imageId, boolean isFaceUp, boolean isMatched) {
        this.Face = isFaceUp;
        this.Id = imageId;
        this.Match = isMatched;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public boolean getFace() {
        return Face;
    }

    public void setFace(boolean face) {
        Face = face;
    }

    public boolean getMatch() {
        return Match;
    }

    public void setMatch(boolean match) {
        this.Match = match;
    }
}