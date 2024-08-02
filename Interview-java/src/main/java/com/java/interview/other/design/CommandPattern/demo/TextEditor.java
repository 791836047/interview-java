package com.java.interview.other.design.CommandPattern.demo;

import java.util.Stack;

/**
 * @author liaowenhui
 * @date 2023/10/30 15:26
 */
public class TextEditor {
    private StringBuilder text;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public String getSelectedText(int start, int end) {
        return text.substring(start, end);
    }

    public void insertText(String insertion, int position) {
        text.insert(position, insertion);
    }

    public void deleteText(int start, int end) {
        text.delete(start, end);
    }

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public String getText() {
        return text.toString();
    }
}
