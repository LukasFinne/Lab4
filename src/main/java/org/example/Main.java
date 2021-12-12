package org.example;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        AddressDAO addressDAO = new AddressImpl();

       /* addressDAO.create(new Address("Smallgatan", 1,"67892","Sverige","Västra Götaland","Luleå","0678681432"));
        addressDAO.create(new Address("Tainabe", 23,"23874","Taiwan","Taipei","Taipei","9875681132"));
        addressDAO.create(new Address("Yils", 66,"54321","Taiwan","Yilan County","Yilan","6845681234"));
        addressDAO.create(new Address("Bachi", 54,"09876","Taiwan","Miaoli County","Tongxiao","521356546824"));
        addressDAO.create(new Address("Pizzagatan", 77,"89723","Norge","Østlandet","Oslo","3535654557"));
        addressDAO.create(new Address("Karasuma", 10,"63213","Japan","Kyoto prefecture","Kyoto","2057893642"));
        addressDAO.create(new Address("Ono", 27,"12356","Japan","Hyogo prefecture","Kobe","0213463602"));*/

        Address address = addressDAO.getById(8);
        address.setCountry("Sverige");
        //  addressDAO.delete(address);
        addressDAO.update(address);
        addressDAO.cityPerCountry();
        addressDAO.getAll().forEach(System.out::println);
    }
}
