public class Picture {
    private String path;
    private int ID;
    private static int incrementId = 0;
    public Picture() {
    }

    public Picture(String path) {
        this.path = path;
        this.ID = incrementIds();
    }

    public int incrementIds() {
        Picture.incrementId++;
        return  Picture.incrementId;
    }

    public String getPath() {
        return path;
    }

    public int getID() {
        return ID;
    }
}
