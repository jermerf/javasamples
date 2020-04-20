public class Journal {
    private String words = "";

    public void append(String moreWords) {
        words += "\n" + moreWords;
    }

    public String getWords(){
        return words;
    }

    private void innerHelperFunction(){

    }
}
