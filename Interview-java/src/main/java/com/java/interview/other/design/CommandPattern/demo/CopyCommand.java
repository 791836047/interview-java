package com.java.interview.other.design.CommandPattern.demo;

/**
 * @author liaowenhui
 * @date 2023/10/30 15:25
 */
class CopyCommand implements Command {
    private TextEditor textEditor;
    public String clipboard;
    private int start;
    private int end;

    public CopyCommand(TextEditor textEditor, int start, int end) {
        this.textEditor = textEditor;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        clipboard = textEditor.getSelectedText(start, end);
    }

    @Override
    public void undo() {
        // Nothing to undo for copy operation
    }

}
