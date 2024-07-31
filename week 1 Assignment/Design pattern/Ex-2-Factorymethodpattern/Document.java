package designPatterns.factoryMethodExample;

abstract class Document {
    abstract void open();
}


class WordDocument extends Document {
    void open() {
        System.out.println("Word document is now open.");
    }
}

class PdfDocument extends Document {
    void open() {
        System.out.println("PDF document is now open.");
    }
}

class ExcelDocument extends Document {
    void open() {
        System.out.println("Excel document is now open.");
    }
}
