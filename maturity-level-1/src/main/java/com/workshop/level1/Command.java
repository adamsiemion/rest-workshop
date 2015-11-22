package com.workshop.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {
    private String method;
    private List<String> arguments;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String getMethod() {
        return method;
    }

    public List<String> getArguments() {
        return arguments;
    }
}
