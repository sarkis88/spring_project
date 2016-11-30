package ru.sbt.bit.ood.hw1;

public interface Parser {
    Iterable<Trade> parse(String filename);
}