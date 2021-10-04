package com.example.lesiadspro;



public class AddNews {
    public String newsName;
    //public Integer date;
    public String date;
    public String articleName;
    public String position ;

    public AddNews() {}

    public AddNews(String newsName, String position) {
        this.newsName = newsName;
        this.position = position;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

  /*  public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }*/

      public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
}
