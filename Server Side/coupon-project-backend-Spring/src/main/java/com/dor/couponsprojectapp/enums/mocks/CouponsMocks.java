package com.dor.couponsprojectapp.enums.mocks;

import com.dor.couponsprojectapp.enums.tables.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter

// Mocks for creating the Companies Coupons in the database.
public enum CouponsMocks {

    AMPM(1L, Category.BEVERAGE, "1+1 Milk", "second milk carton for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 10.00,"https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fbucketeer-e05bbc84-baa3-437e-9518-adb32be77984.s3.amazonaws.com%2Fpublic%2Fimages%2F327d019c-ba4e-4490-af9a-e13bc77c1a80_800x533.jpeg"),
    AMPM2(1L, Category.FOOD, "1+1 Chocolate", "second Chocolate box for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 5.00, "https://assets.epicurious.com/photos/6070b92dab8bd2c2fd18ee30/6:4/w_4132,h_2755,c_limit/ChocolateBakingBars_HERO_040821_12624_final.jpg"),
    SUPERYUDA(2L, Category.FOOD, "1+1 Shampoo", "second Shampoo bottle for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 20.00, "https://cloudinary.images-iherb.com/image/upload/f_auto,q_auto:eco/images/hds/hds94959/y/8.jpg"),
    SUPERYUDA2(2L, Category.FOOD, "1+1 Soap", "second Soap bottle for free",LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 7.00, "https://kajabi-storefronts-production.kajabi-cdn.com/kajabi-storefronts-production/blogs/28228/images/8iCuac7dQeOEEBl9HSLj_before-you-start-a-soap-business.jpg"),
    DOMINOS(3L, Category.JUNKFOOD, "1+1 Pizza", "second Pizza for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 50.00, "https://cdn.shopify.com/s/files/1/0205/9582/articles/20220211142347-margherita-9920_ba86be55-674e-4f35-8094-2067ab41a671.jpg?crop=center&height=800&v=1644590192&width=800"),
    MCDONALDS(4L, Category.JUNKFOOD, "1+1 Burger", "second Burger for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 30, "https://www.thespruceeats.com/thmb/POpuxXZ8hoq56_m7KUPcy41clvo=/2668x2001/smart/filters:no_upscale()/indian-style-burger-1957599-hero-01-266103a4bb4e4ee7b5feb4da2d2e99da.jpg"),
    SHUPERSAL(5L, Category.ELECTRONICS, "50% Off microwave", "50% Off microwave above 200NIS", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 100.00, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/wu4719microwavewithgrill-01-pcm155026-1574424415.jpg?crop=1.00xw:0.753xh;0,0.0856xh&resize=1200:*"),
    OSHERAD(6L, Category.BEVERAGE, "1+1 crystal", "second crystal bottle for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 2.00, "https://static.wixstatic.com/media/4189ab_96d5d1ccb8aa4e7687eec5090492f667~mv2.jpg/v1/fit/w_388%2Ch_218%2Cal_c%2Cq_80/file.jpg"),
    IVORY(7L, Category.ELECTRONICS, "20% off Keyboards", "20% off all logitech Keyboards", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 50.00, "https://www.espir.co.il/images/itempics/MX-Keys_16012022154130.jpg"),
    KSP(8L, Category.ELECTRONICS, "25% off Keyboards", "25% off all microsoft Keyboards", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 45.00, "https://cdn-dynmedia-1.microsoft.com/is/image/microsoftcorp/Accessories_4Up_All-in-one_Media_Keyboard?wid=515&hei=293&fit=crop"),
    YELP(9L, Category.RESTAURANTS, "40% off tlv restaurants", "40% off tlv restaurants only on 400NIS and above bill", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 100.00, "https://www.hilton.com/im/en/TLVHITW/15932330/main-dining.jpg?impolicy=crop&cw=4500&ch=2981&gravity=NorthWest&xposition=0&yposition=9&rw=645&rh=427"),
    TRIPADVISOR(10L, Category.RESTAURANTS, "40% off tlv museums", "40% off tlv restaurants only on 300NIS and above bill", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 75.00, "https://media.timeout.com/images/105426597/image.jpg"),
    AIRBNB(11L, Category.VACATION, "40% off tlv apartments", "40% off tlv apartments only on south tlv", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 200.00, "https://c8.alamy.com/comp/MGCF6N/aerial-view-of-south-tel-aviv-neighborhoods-cityspace-a-combination-of-new-and-old-construction-MGCF6N.jpg"),
    BOOKING(12L, Category.VACATION, "40% off europe hotels", "40% off europe hotels only on winter", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 300.00, "https://upload.wikimedia.org/wikipedia/commons/8/88/Grand_Hotel_Europe_4.jpg"),
    HACEREM(13L, Category.BEVERAGE, "1+1 beer", "second beer bottle for free",LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 7.00, "https://images.unsplash.com/photo-1608270586620-248524c67de9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YmVlciUyMG11Z3xlbnwwfHwwfHw%3D&w=1000&q=80"),
    COCACOLA(14L, Category.BEVERAGE, "1+1 cola", "second cola bottle for free", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 7.00, "https://feros.lk/wp-content/uploads/2021/08/Coke-1.5L.jpg"),
    ADIDAS(15L, Category.SHOES, "12% Off all the shoes", "Discount apply only on running shoes!", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 20.00, "https://hips.hearstapps.com/hmg-prod/images/run-adidas-running-shoes-1645131039.jpg"),
    CASTRO(16L, Category.CLOTHING, "20% Off all the jeans pants", " only above 200NIS", LocalDate.parse("2022-10-20"), LocalDate.parse("2023-10-22"), 2, 50.00, "https://d2d22nphq0yz8t.cloudfront.net/e3baa240-c8b7-44c1-b56d-ea0acff325fc/https://www.castro.com/pub/media/social/post/instagram/images/17936936228241632.jpg/f_auto");


    public Long companyID;
    public Category category;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;
    
    
}
