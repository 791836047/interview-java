package com.java.interview.other.design.CommandPattern.demo;

/**
 * @author liaowenhui
 * @date 2023/10/30 15:26
 */
public class TestMain {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        textEditor.insertText("Hello, World!", 0);
        System.out.println("Text: " + textEditor.getText());

        // 使用命令模式执行操作
        CutCommand cutCommand = new CutCommand(textEditor, 0, 5);
        textEditor.executeCommand(cutCommand);
        System.out.println("Text after Cut: " + textEditor.getText());

        CopyCommand copyCommand = new CopyCommand(textEditor, 0, 5);
        textEditor.executeCommand(copyCommand);

        PasteCommand pasteCommand = new PasteCommand(textEditor, copyCommand.clipboard, 6);
        textEditor.executeCommand(pasteCommand);
        System.out.println("Text after Paste: " + textEditor.getText());

        // 撤销操作
        textEditor.undo();
        System.out.println("Text after Undo: " + textEditor.getText());

        // 重做操作
        textEditor.redo();
        System.out.println("Text after Redo: " + textEditor.getText());
    }
}
