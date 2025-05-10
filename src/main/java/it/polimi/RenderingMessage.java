package it.polimi;

import java.util.ArrayList;

public class RenderingMessage {
    ArrayList<DrawableCard> drawableCards = new ArrayList<DrawableCard>();
    ArrayList<DrawableString> drawableStrings = new ArrayList<DrawableString>();

    public RenderingMessage(ArrayList<DrawableCard> drawableCards, ArrayList<DrawableString> drawableStrings) {
        this.drawableCards = drawableCards;
        this.drawableStrings = drawableStrings;
    }
}
