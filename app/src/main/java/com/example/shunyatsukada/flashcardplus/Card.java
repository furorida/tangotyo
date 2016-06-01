package com.example.shunyatsukada.flashcardplus;

/**
 * Created by shunyatsukada on 16/05/28.
 */
public class Card {
    public int imageId;
    public String title;
    public String content;
    public int likeNum;

    public String meaning;
//これはコンストラクタ。引数
    public Card(int imageId, String title ,String content, String meaning) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
        this.meaning = meaning;

    }
}
