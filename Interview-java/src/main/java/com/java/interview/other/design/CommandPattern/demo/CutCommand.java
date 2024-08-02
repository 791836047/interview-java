package com.java.interview.other.design.CommandPattern.demo;

/**
 * @author liaowenhui
 * @date 2023/10/30 15:20
 */
public class CutCommand implements Command {
    private TextEditor textEditor;
    private String clipboard;
    private int start;
    private int end;

    public CutCommand(TextEditor textEditor, int start, int end) {
        this.textEditor = textEditor;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        clipboard = textEditor.getSelectedText(start, end);
        textEditor.deleteText(start, end);
    }

    @Override
    public void undo() {
        textEditor.insertText(clipboard, start);
    }
}
