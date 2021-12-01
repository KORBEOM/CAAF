package com.example.tnsfl;

import android.graphics.Bitmap;

public class DataModel {
    Bitmap image; // 사진
    String category; // 카테고리
    String title; // 제목
    String contents; // 내용
    String nickName; // 닉네임
    String email; // 이메일
    String hit; // 조회수
    String comment; // 댓글 수
    String date; // 날짜
    String section; //섹션(토픽인지, 직종인지)
    String contentsNum; // 게시글 숫자
    int likeCount; // 좋아요갯수
    boolean userLiked; // 좋아요 눌린 여부

    public DataModel( String contentsNum, String section, Bitmap image, String category, String title, String contents, String nickName, String hit, /*String comment,*/ String date, String email, int likeCount, boolean userLiked) {
        this.image = image;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.nickName = nickName;
        this.hit = hit;
        this.comment = comment;
        this.date = date;
        this.email = email;
        this.section = section;
        this.contentsNum = contentsNum;
        this.likeCount = likeCount;
        this.userLiked = userLiked;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getNickName() {
        return nickName;
    }

    public String getHit() {
        return hit;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getSection() {
        return section;
    }

    public String getContentsNum() {
        return contentsNum;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public boolean isUserLiked() {
        return userLiked;
    }



    public void setUserLiked(boolean userLiked) {
        this.userLiked = userLiked;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSection(String setcion) {
        this.section = section;
    }
    public void setContentsNum(String contentsNum) {
        this.contentsNum = contentsNum;
    }
}