package com.lgim.hackathon.team4.location;

public class PostCodeNotFoundException extends Exception {
    public PostCodeNotFoundException(String postCodeString) {
        super(String.format("Post code %s not found", postCodeString));
    }
}
