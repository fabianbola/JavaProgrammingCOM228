public class Singers {

    private int id;
    private String name;
    private String address;
    private String dateBirth;
    private int numAlbumsPublished;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDateOfBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    public void setNumberAlbumsPublished(int numAlbumsPublished) {
        this.numAlbumsPublished = numAlbumsPublished;
    }
    public void setAttributes(int id, String name, String address, String dateBirth, int numAlbumsPublished){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateBirth = dateBirth;
        this.numAlbumsPublished = numAlbumsPublished;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getDateOfBirth() {
        return dateBirth;
    }
    public int getNumberAlbumsPublished() {
        return numAlbumsPublished;
    }
    public Singers() {
        this.id = 301378302;
        this.name = "Fabian Bolanos";
        this.address = "35 rushbrooke Ave";
        this.dateBirth = "1990-06-16";
        this.numAlbumsPublished = 0;
    }
    public Singers(int id) {
        this.id = id;
    }
    public Singers(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Singers(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public Singers(int id, String name, String address, String dateBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateBirth = dateBirth;
    }
    public Singers(int id, String name, String address, String dateBirth, int numAlbumsPublished) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateBirth = dateBirth;
        this.numAlbumsPublished = numAlbumsPublished;
    }
}
