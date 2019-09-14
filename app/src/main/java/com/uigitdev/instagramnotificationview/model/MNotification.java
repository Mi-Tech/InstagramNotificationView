package com.uigitdev.instagramnotificationview.model;

public class MNotification {
    private int likes;
    private int comments;
    private int followers;

    public MNotification(int likes, int comments, int followers) {
        this.likes = likes;
        this.comments = comments;
        this.followers = followers;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
