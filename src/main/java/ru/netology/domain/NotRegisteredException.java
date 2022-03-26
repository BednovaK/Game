package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException() {
        super("One of elements is not registered");
    }
}