package org.example;

import org.example.client.ApiServises;

public class Main {
    public static void main(String[] args) {
        ApiServises api = new ApiServises();

        System.out.println(api.getOffsetNews());
    }
}