package com.example.tasktracker.commands;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
@Command
public class UtilsCommands {
	
	@Command(command = "exit")
	public void exit() {
		System.out.println("Exiting the applcation...");
		System.exit(0);
	}
}
