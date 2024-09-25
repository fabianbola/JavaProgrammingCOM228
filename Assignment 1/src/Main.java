//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Singers singer = new Singers();
        System.out.println("The singer " + singer.getName() +" has id "+ singer.getId()+" was born in "+ singer.getDateOfBirth() + " lives in "+ singer.getAddress()+ " and has published "+ singer.getNumberAlbumsPublished()+ " albums" );
        singer.setId(1234);
        singer.setName("Daniel Fabian");
        singer.setAddress("941 Progress Ave");
        singer.setDateOfBirth("1991-01-14");
        singer.setNumberAlbumsPublished(5);
        System.out.println("The singer " + singer.getName() +" has id "+ singer.getId()+" was born in "+ singer.getDateOfBirth() + " lives in "+ singer.getAddress()+ " and has published "+ singer.getNumberAlbumsPublished()+ " albums" );
        singer.setAttributes(301378302,"Fabian Bolanos","35 rushbrooke Ave","1990-06-16", 0);
        System.out.println("The singer " + singer.getName() +" has id "+ singer.getId()+" was born in "+ singer.getDateOfBirth() + " lives in "+ singer.getAddress()+ " and has published "+ singer.getNumberAlbumsPublished()+ " albums" );
    }
}