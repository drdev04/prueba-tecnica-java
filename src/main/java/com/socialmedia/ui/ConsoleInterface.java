/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.ui;

import com.socialmedia.service.SocialMediaService;
import com.socialmedia.exceptions.UserNotFoundException;
import java.util.Scanner;
/**
 *
 * @author RODRIGO
 */
public class ConsoleInterface {
    private final SocialMediaService service;

    public ConsoleInterface() {
        this.service = new SocialMediaService();
    }

    public void start() {
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            // Comando para salir de la aplicación
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Saliendo de la aplicación...");
                break;
            }

            handleInput(input);
        }
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String params = parts.length > 1 ? parts[1] : "";

        try {
            switch (command) {
                case "post":
                    handlePost(params);
                    break;
                case "follow":
                    handleFollow(params);
                    break;
                case "dashboard":
                    handleDashboard(params);
                    break;
                default:
                    System.out.println("Comando no reconocido.");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handlePost(String params) throws UserNotFoundException {
        String[] args = params.split(" ", 2);
        String username = args[0].substring(1);
        String message = args[1];

        service.postMessage(username, message);
    }

    private void handleFollow(String params) throws UserNotFoundException {
        String[] args = params.split(" ");
        String follower = args[0].substring(1);
        String followee = args[1].substring(1);

        service.followUser(follower, followee);
    }

    private void handleDashboard(String params) throws UserNotFoundException {
        String username = params.substring(1); // Eliminar '@'
        service.viewDashboard(username);
    }

    private void printWelcomeMessage() {
        System.out.println("***************************************");
        System.out.println("          Bienvenido a la Red Social   ");
        System.out.println("                en Consola             ");
        System.out.println("***************************************");
        System.out.println("Escribe 'exit' o 'quit' para salir.");
        System.out.println("Comandos disponibles:");
        System.out.println("- post @usuario mensaje");
        System.out.println("- follow @usuario1 @usuario2");
        System.out.println("- dashboard @usuario");
    }
}
