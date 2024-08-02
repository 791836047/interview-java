package com.java.interview.other.design.CommandPattern.demo;

/**
 * @author liaowenhui
 * @date 2023/10/30 15:25
 */
class PasteCommand implements Command {
    private TextEditor textEditor;
    private String clipboard;
    private int position;

    public PasteCommand(TextEditor textEditor, String clipboard, int position) {
        this.textEditor = textEditor;
        this.clipboard = clipboard;
        this.position = position;
    }

    @Override
    public void execute() {
        textEditor.insertText(clipboard, position);
    }

    @Override
    public void undo() {
        textEditor.deleteText(position, position + clipboard.length());
    }

}
